#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/9 7:43 下午
# @Author : Fitz
# @File : _main.py
# @Description:

import numpy as np

def main():
    data = [[1, 1, 1, 0, 0],
            [2, 2, 2, 0, 0],
            [3, 3, 3, 0, 0],
            [5, 5, 3, 2, 2],
            [0, 0, 0, 3, 3],
            [0, 0, 0, 6, 6]]
    u, sigma, v = np.linalg.svd(data)
    print("这是分解后的u向量")
    print(u)
    print("这是分解后的奇异值")
    print(sigma)
    print("这是分解后的v向量")
    print(v)

import svd
def junit():
    testdata = [[1, 1, 1, 0, 0],
            [2, 2, 2, 0, 0],
            [3, 3, 3, 0, 0],
            [5, 5, 3, 2, 2],
            [0, 0, 0, 3, 3],
            [0, 0, 0, 6, 6]]
    estdata = svd.loadExData()
    svd.recommend(testdata, 1, N=3, percentage=0.8)  # 对编号为1的用户推荐评分较高的3件商品

if __name__ == '__main__':
    # main()
    junit()
