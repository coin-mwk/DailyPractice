#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 3:14 下午
# @Author : Fitz
# @Description:

import preprocessing
import svd_01
import numpy as np

def main():
    dataMat, item_title = preprocessing.loading_data()
    # print(dataMat)
    # print(np.shape(dataMat))
    print(item_title[str(1)],item_title[str(2)],item_title[str(3)])

    # 对编号为1的用户推荐评分较高的3部电影
    # print("---------")
    final_N_prediction = svd_01.recommend(dataMat, 1, N=3, percentage=0.8)
    print(final_N_prediction)


if __name__ == '__main__':
    main()