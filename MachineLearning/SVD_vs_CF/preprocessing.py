#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 10:56 上午
# @Author : Fitz
# @Description: 对movielens数据进行预处理，得到user-item矩阵，并按列平均值将user_item矩阵补齐


import numpy as np


def loading_data(user_count, item_count):
    # user_count = 6040
    # item_count = 3952
    # 将用户评分矩阵初始化为零矩阵， 共有6040个用户对3952部电影进行评分
    dataMat = np.zeros((user_count, item_count))  # 1M数据集
    # 根据ratings.dat将dataMat构造为user-item矩阵
    for row in open("../ml-1m/ratings.dat", "r"):
        user, item, rating, _ = row.split('::')
        user, item, rating = int(user), int(item), int(rating)
        dataMat[user - 1][item - 1] = rating

    # 关联电影id与title
    item_title = {}
    for row in open("../ml-1m/movies.dat", "r"):
        movie_id, movie_name, movie_desc = row.split('::')
        item_title[movie_id] = movie_name

    """将稀疏矩阵按列均值进行填充"""
    dataMat = np.mat(dataMat)
    row_sum = np.sum(dataMat, axis=0)  # 返回每部电影的评分总和的矩阵
    dataMat_T = dataMat.T
    for i in range(item_count):
        nonzero_count = np.mat(np.nonzero(dataMat_T[i])).shape[1]  # 每部电影已评分的用户数量
        if nonzero_count == 0:
            row_average = 0
        else:
            row_average = row_sum[0, i] / nonzero_count  # 第i部电影的评分均值
        # print("第", i, "个用户有", (3952-nonzero_count), "部电影未评分,此用户对所有电影的平均评分为", row_average)
        for j in range(user_count):
            if dataMat_T[i, j] == 0:
                dataMat_T[i, j] = row_average
    dataMat = dataMat
    # 返回user-item矩阵和电影列表
    return np.mat(dataMat), item_title


def loading_data_CF(user_count, item_count):
    # 将用户评分矩阵初始化为零矩阵， 共有15个用户对938部电影进行评分
    dataMat = np.zeros((user_count, item_count))  # 1K数据集中的一个u.base
    # 根据ratings.dat将dataMat构造为user-item矩阵
    for row in open("user_item.base", "r"):
        user, item, rating, _ = row.split('	')
        user, item, rating = int(user), int(item), int(rating)
        dataMat[user - 1][item - 1] = rating

    # 关联电影id与title
    item_title = {}
    for row in open("../ml-1m/movies.dat", "r"):
        movie_id, movie_name, movie_desc = row.split('::')
        item_title[movie_id] = movie_name

    # 返回user-item矩阵和电影列表
    return np.mat(dataMat), item_title


def loading_data_svd_test(user_count, item_count):
    # 将用户评分矩阵初始化为零矩阵， 共有15个用户对938部电影进行评分
    dataMat = np.zeros((user_count, item_count))  # 1K数据集中的一个u.base
    # 根据ratings.dat将dataMat构造为user-item矩阵
    for row in open("../CF/user_item.base", "r"):
        user, item, rating, _ = row.split('	')
        user, item, rating = int(user), int(item), int(rating)
        dataMat[user - 1][item - 1] = rating

    # 关联电影id与title
    item_title = {}
    for row in open("../ml-1m/movies.dat", "r"):
        movie_id, movie_name, movie_desc = row.split('::')
        item_title[movie_id] = movie_name

    # 返回user-item矩阵和电影列表
    # return np.mat(dataMat), item_title
    return dataMat, item_title


def main():
    dataMat, item_title = loading_data_svd_test(15, 938)
    print(dataMat)


if __name__ == '__main__':
    main()