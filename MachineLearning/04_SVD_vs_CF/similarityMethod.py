#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 9:02 下午
# @Author : Fitz
# @Description: 此文件描述几种推荐所用的相似度方法


from numpy import linalg as la


def cosineMethod(a, b):
    from sklearn.metrics.pairwise import cosine_similarity
    s = cosine_similarity(a, b)
    return 1


# 欧式距离
def ecludSim(a, b):
    # 这里的1/(1+距离)表示将相似度的范围放在0与1之间
    return 1.0 / (1.0 + la.norm(a - b))


# 皮尔逊相关系数
def pearsSim(a, b):
    # 皮尔逊相关系数的计算方法corrcoef()，参数rowvar=0表示对列求相似度，这里的0.5+0.5*corrcoef()是为了将范围归一化放到0和1之间=
    if len(a) < 3:
        return 1.0
    return 0.5 + 0.5 * corrcoef(a, b, rowvar=0)[0][1]


# 余弦相似度
def cosSim(a, b):
    num = float(a.T * b)
    denom = la.norm(a) * la.norm(b)
    return 0.5 + 0.5 * (num / denom)  # 将相似度归一到0与1之间