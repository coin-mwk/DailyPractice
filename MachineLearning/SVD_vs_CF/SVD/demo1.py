#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 3:14 下午
# @Author : Fitz
# @Description:

import preprocessing
import svd_01
import numpy as np

def main():
    # 加载数据
    dataMat, item_title = preprocessing.loading_data()
    # 对编号为1的用户推荐评分较高的3部电影
    user = 244
    N = 5
    rec_list = final_N_prediction = svd_01.recommend(dataMat, user, N, percentage=0.8)
    print("为用户", user, "推荐的", N, "部电影如下:")
    print(rec_list)
    for i in range(len(rec_list)):
        temp = rec_list[i]
        print(item_title[str(temp[0]+1)])



if __name__ == '__main__':
    main()
