#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 3:14 下午
# @Author : Fitz
# @Description:


import numpy as np

from SVD_vs_CF.preprocessing import *
from SVD_vs_CF.SVD._svd import recommend

def main():
    # 加载数据
    dataMat, item_title = loading_data_svd_test(15, 938)
    print(dataMat)
    print(np.shape(dataMat))
    # recommend(dataMat, user, N, simMeas=cos_sim, percentage=0.9):
    rec_list = recommend(dataMat=dataMat, user=7, N=10, percentage=0.8)



if __name__ == '__main__':
    main()
