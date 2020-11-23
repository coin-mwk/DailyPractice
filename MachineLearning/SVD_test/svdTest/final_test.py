#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/10 9:28 上午
# @Author : Fitz
# @Description:


import pandas as pd
import numpy as np
import svd
def main():
    testdata = svd.loadExData()

    final_N_prediction = svd.recommend(testdata, 2, N=5, percentage=0.8) # 对编号为1的用户推荐评分较高的3件商品
    # file_path = "./../ml-1m/ratings.dat"
    # u1_data = pd.read_csv(file_path)
    # print(u1_data.head(10))

if __name__ == '__main__':
    main()
