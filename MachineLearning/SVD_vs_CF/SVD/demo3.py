#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/12/9 7:44 下午
# @Author : Fitz
# @Description:

from sklearn.model_selection import train_test_split as sp

from SVD_vs_CF.preprocessing import *
def main():
    small_data, title = loading_data_svd_test(15, 938)
    # 划分数据集
    train_data, test_data = sp(small_data, test_size=0.25)
    # Create two user-item matrices for training and testing data
    train_data_matrix = train_data.as_matrix(columns=['user_id', 'movie_id', 'rating'])
    test_data_matrix = test_data.as_matrix(columns=['user_id', 'movie_id', 'rating'])
    print(np.shape(train_data))
    print(train_data)


if __name__ == '__main__':
    main()