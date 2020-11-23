#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 10:50 上午
# @Author : Fitz
# @Description: 用原始SVD方法实现推荐，评分缺失值用平均值补齐

import numpy as np
from numpy import *
from numpy import linalg as la

'''以下是三种计算相似度的算法，分别是欧式距离、皮尔逊相关系数和余弦相似度 
注意三种计算方式的参数inA和inB都是列向量'''


def cosineMethod(a, b):
    from sklearn.metrics.pairwise import cosine_similarity
    s = cosine_similarity(a, b)
    return 1


def ecludSim(a, b):
    # 这里的1/(1+距离)表示将相似度的范围放在0与1之间
    return 1.0 / (1.0 + la.norm(a - b))


def pearsSim(a, b):
    # 皮尔逊相关系数的计算方法corrcoef()，参数rowvar=0表示对列求相似度，这里的0.5+0.5*corrcoef()是为了将范围归一化放到0和1之间=
    if len(a) < 3:
        return 1.0
    return 0.5 + 0.5 * corrcoef(a, b, rowvar=0)[0][1]


def cosSim(a, b):
    num = float(a.T * b)
    denom = la.norm(a) * la.norm(b)
    return 0.5 + 0.5 * (num / denom)  # 将相似度归一到0与1之间


def sigmaPct(sigma, percentage):
    """对K值得预测
        方法：按照前k个奇异值的平方和占总奇异值的平方和的百分比percentage来确定k的值
             后续计算SVD时需要将原始矩阵转换到k维空间"""
    sigma2 = sigma ** 2  # 对sigma求平方
    sum_sigma2 = sum(sigma2)  # 求所有奇异值sigma的平方和
    sum_sigmak = 0  # 求前k个奇异值的平方和
    k = 0
    for i in sigma:
        sum_sigmak += i ** 2
        k += 1
        if sum_sigmak >= sum_sigma2 * percentage:
            return k


def svdExt(dataMat, percentage):
    # 先将矩阵0元素用均值补齐， 矩阵大小为6040*3952
    row_sum = np.sum(dataMat, axis=1)  # 返回每个用户评分均值的矩阵
    # 计算每个用户的评分均值并补齐缺失评分
    for i in range(6040):
        nonzero_count = np.mat(np.nonzero(dataMat[i])).shape[1]  # 第i行非零元素的个数
        row_average = row_sum[i, 0] / nonzero_count  # 第i行的评分均值
        # print("第", i, "个用户有", (3952-nonzero_count), "部电影未评分,此用户对所有电影的平均评分为", row_average)
        for j in range(3952):
            if dataMat[i, j] == 0:
                dataMat[i, j] = row_average
    # print(dataMat)
    # 奇异值分解---->降维
    u, sigma, vt = la.svd(dataMat)
    # 确定变换后的维数k
    k = sigmaPct(sigma, percentage)
    sigmaK = mat(eye(k) * sigma[:k])  # 构建对角矩阵
    # print(k)
    # print(sigmaK)
    # 根据k的值将原始数据转换到k维空间(低维),xformedItems表示物品(item)在k维空间转换后的值
    xformedItems = dataMat.T * u[:, :k] * sigmaK.I
    # print(xformedItems)
    return xformedItems


"""
description:函数的作用是基于item的相似性对用户未评过分的物品进行预测评分
dataMat:数据矩阵
user:用户编号
item:物品编号
simMeas:相似度度量的方法
percentage:奇异值占比的阈值
"""


def svdEst(xformedItems, dataMat, user, simMeas, item):
    n = shape(dataMat)[1]
    simTotal = 0.0
    ratSimTotal = 0.0

    for j in range(n):
        userRating = dataMat[user, j]
        # print("来啦！", "userRating="+str(dataMat[user, j]), "j="+str(j), "item="+str(item))
        if userRating == 0 or j == item:
            continue
        similarity = simMeas(xformedItems[item, :].T, xformedItems[j, :].T)  # 计算物品item与物品j之间的相似度
        simTotal += similarity  # 对所有相似度求和
        ratSimTotal += similarity * userRating  # 用"物品item和物品j的相似度"乘以"用户对物品j的评分"，并求和
    if simTotal == 0:
        return 0
    else:
        return ratSimTotal / simTotal  # 得到对物品item的预测评分


"""
dataMat:数据矩阵
user:用户编号
N:推荐的结果数量
simMeas:相似度度量的方法
eatMerhod:预测评分的方法
percentage:奇异值占比的阈值
"""


def recommend(dataMat, user, N=5, simMeas=cosSim, estMethod=svdEst, percentage=0.9):
    """生成评分最高的N个结果"""
    unratedItems = nonzero(dataMat[user, :].A == 0)[1]  # 建立一个用户未评分item的列表
    print("==========non-predicted items=========")
    print(unratedItems)
    print("用户", user, "有", len(unratedItems), "部电影未评分")
    print("==========non-predicted items=========\n")
    if len(unratedItems) == 0:
        return 'you rated everything'  # 如果都已经评过分，则退出
    # 先对整个矩阵进行奇异值分解
    xformedItems = svdExt(dataMat, percentage)
    itemScores = []
    # 对于每个未评分的item，都计算其预测评分
    for item in unratedItems:
        # print("now predicting item_id:", item)
        estimatedScore = estMethod(xformedItems, dataMat, user, cosSim, item)
        # print("the estimated score of item_id=", item, "------>", estimatedScore, "\n")

        itemScores.append((item, estimatedScore))

    # 此时只对预测的列表进行排序，推荐前N个,没有考虑用户之前评分吗过的项目

    itemScores = np.sorted(itemScores, key=lambda x: x[1], reverse=True)  # 按照item的得分进行从大到小排序
    print(itemScores)
    return itemScores[:N]  # 返回前N大评分值的item名，及其预测评分值
