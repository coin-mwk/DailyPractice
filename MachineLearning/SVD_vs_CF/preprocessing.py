#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 10:56 上午
# @Author : Fitz
# @Description: 对movielens数据进行预处理，目的得到user-item矩阵


import numpy as np


def loading_data():
    # 将用户评分矩阵初始化为零矩阵， 共有6040个用户对3952部电影进行评分
    # dataMat = np.zeros((6040, 3952))               # 1M数据集
    dataMat = np.zeros((15, 938))                  # 1K数据集中的一个u.base
    # 根据ratings.dat将dataMat构造为user-item矩阵
    # for row in open("../ml-1m/ratings.dat", "r"):
    for row in open("user_item.base", "r"):
        # user, item, rating, _ = row.split('::')
        user, item, rating, _ = row.split('	')
        user, item, rating = int(user), int(item), int(rating)
        dataMat[user - 1][item - 1] = rating

    # 关联电影id与title
    item_title = {}
    for row in open("../ml-1m/movies.dat", "r"):
        movie_id, movie_name, movie_desc = row.split('::')
        item_title[movie_id] = movie_name

    # 返回user-item矩阵和电影列表
    # return np.mat(dataMat), np.mat(item_title)
    return np.mat(dataMat), item_title
