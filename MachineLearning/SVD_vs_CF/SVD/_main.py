#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 2:20 下午
# @Author : Fitz
# @Description:


from SVD_vs_CF.preprocessing import loading_data
from SVD_vs_CF.SVD.svd_01 import *
from SVD_vs_CF.similarityMethod import *

def main():
    user_count = 6040
    item_count = 3952
    # 导入预处理后的评分矩阵，此时矩阵空缺位置已被列平均值补齐
    # dataMat, id_name = loading_data(user_count, item_count)

    # 以下为测试部分
    from SVD_vs_CF.preprocessing import loading_data_svd_test
    dataMat, id_name = loading_data_svd_test(15, 938)
    print(dataMat)
    a = recommend(dataMat=dataMat, user=4, N=10, simMeas=cos_sim, percentage=0.9)
    print(a)

# recommend(dataMat, user, N=5, simMeas=cosSim, estMethod=svdEst, percentage=0.9):



# def demo():
    # svd_01.matrixFill(dataMat)



if __name__ == '__main__':
    # demo()
    main()
