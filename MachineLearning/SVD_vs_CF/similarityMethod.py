#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 9:02 下午
# @Author : Fitz
# @Description: 此文件描述几种推荐所用的相似度方法


import numpy as np


# 余弦相似度
def cos_sim(a, b):
    a_norm = np.linalg.norm(a)
    b_norm = np.linalg.norm(b)
    cos = np.dot(a, b) / (a_norm * b_norm)
    # 归一化
    return 0.5 + 0.5 * cos


# 欧式距离（Euclidean Distance)
def ecl_sim(a, b):
    # 这里的1/(1+距离)表示将相似度的范围放在0与1之间
    ecl = np.linalg.norm(a -b)
    # 归一化
    return 1.0 / (1.0 + np.linalg.norm(a - b))


# 皮尔逊相关系数 (Pearson Correlation Coefficient)
def pea_sim(a, b):
    pea = np.corrcoef(a, b, rowvar=0)[0][1]
    # 归一化
    return 0.5 + 0.5 * pea






def main():
    t1 = np.array([-0.4, 0.8, 0.5, -0.2, 0.3])
    t2 = np.array([-0.5, 0.4, -0.2, 0.7, -0.1])
    print(cos_sim(t1, t2))
    print(ecl_sim(t1, t2))
    print(pea_sim(t1, t2))

if __name__ == '__main__':
    main()