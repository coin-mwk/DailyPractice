#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 3:58 下午
# @Author : Fitz
# @Description:

import numpy as np

from scipy.sparse.linalg import svds


def main():
    aa = np.mat(np.array([[1,2,0,1],[0,4,1,1], [3,0,4,1], [5,0,6,1]]))
    bb = np.mat(np.array([[1,2,0],[0,4,1], [3,0,4], [5,0,6],[2,3,4]]))


    print(aa)
    svds(aa, k=3)


if __name__ == '__main__':
    main()