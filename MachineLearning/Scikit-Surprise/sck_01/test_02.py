#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/15 9:18 下午
# @Author : Fitz
# @Description:

# 可以使用上面提到的各种推荐系统算法
from surprise import SVD
from surprise import Dataset
from surprise.prediction_algorithms.matrix_factorization import SVD




# 默认载入movielens数据集，会提示是否下载这个数据集，这是非常经典的公开推荐系统数据集——MovieLens数据集之一
data = Dataset.load_builtin('ml-100k')

a = SVD()
