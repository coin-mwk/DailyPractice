#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 3:58 下午
# @Author : Fitz
# @Description:

import numpy as np


def main():
    aa = np.array([[1,2,0],[0,4,1], [3,0,4], [5,0,6],[2,3,4]])
    bb = np.mat(np.array([[1,2,0],[0,4,1], [3,0,4], [5,0,6],[2,3,4]]))
    print(bb[0])
    nonzero_count = np.mat(np.nonzero(bb[4])).shape[1]  # 矩阵非零元素的个数
    print(nonzero_count)


    print(bb)
    cc = np.sum(bb, axis=1)
    print(cc)
    print(cc[1,0])
    print(cc.shape)
    print(np.squeeze(cc))


if __name__ == '__main__':
    main()