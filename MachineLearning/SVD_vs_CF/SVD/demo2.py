#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 3:58 下午
# @Author : Fitz
# @Description:

import numpy as np
import math

from scipy.sparse.linalg import svds
from SVD_vs_CF.preprocessing import *

def main():

    data, title = loading_data_svd_test(15, 938)
    u, sigma, v = svds(data, k=5)
    print(np.shape(u))
    print(np.shape(v))
    v = v.T
    # 生成对角矩阵
    sigma = abs(np.sort(-sigma))
    print(sigma)

    sigma = np.diag(sigma)
    # print(u[0])
    # print(v[0])
    # print(u)
    while 1:
        print("输入行和列：")
        i = int(input())
        j = int(input())
        print("实际评分为：", data[i, j])
        print("预测得分：", abs(np.dot(np.dot(u[i], sigma), v[j])))

    # sigma2 = sigma ** 2  # 对sigma求平方
    # sum_sigma2 = sum(sigma2)  # 求所有奇异值sigma的平方和
    # print("sigma总和",sum_sigma2)
    # sum_sigmak = 0  # 求前k个奇异值的平方和
    # k = 0
    # for i in sigma:
    #     sum_sigmak += i ** 2
    #     k += 1
    #     if sum_sigmak >= sum_sigma2 * 0.9:
    #         print(k)


def demo1():
    data, title = loading_data_svd_test(15, 938)
    u, sigma, v = np.linalg.svd(data)
    print(np.shape(u))
    print(np.shape(v))
    v = v.T
    # 生成对角矩阵
    print(sigma)
    # sigma = np.diag(sigma)
    # print(sigma)


if __name__ == '__main__':
    # demo1()
    main()