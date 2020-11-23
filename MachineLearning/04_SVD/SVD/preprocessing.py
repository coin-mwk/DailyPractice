#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 10:56 上午
# @Author : Fitz
# @Description: 对movielens数据进行预处理，目的得到user-item矩阵

import numpy as np


def loading_data():
    # 将用户评分矩阵初始化为零矩阵， 共有6040个用户对3900部电影进行评分
    dataMat = np.zeros((6040, 3952))
    # dataMat1 = np.zeros((4, 5))
    # 根据ratings.dat将dataMat构造为user-item矩阵
    for row in open("ml-1m/ratings.dat", "r"):
        user, item, rating, _ = row.split('::')
        user, item, rating = int(user), int(item), int(rating)
        dataMat[user - 1][item - 1] = rating

    # 关联电影id与title
    return dataMat
