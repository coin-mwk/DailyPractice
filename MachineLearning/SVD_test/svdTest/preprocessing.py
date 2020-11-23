#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 2:52 下午
# @Author : Fitz
# @Description:
import numpy as np

def loading_data():
    # 将用户评分矩阵初始化为零矩阵， 共有6040个用户对3900部电影进行评分
    dataMat = np.zeros((6040, 3952))
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

    # 返回user-item矩阵和电影列表
    print(dataMat)
    print(item_title)
    return dataMat, item_title


if __name__ == '__main__':
    loading_data()