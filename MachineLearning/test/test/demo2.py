#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/21 4:39 下午
# @Author : Fitz
# @Description:

import numpy as np


def demo1():
    arr0 = np.array([1])
    print(arr0)
    print(arr0.shape)
    print(np.squeeze(arr0).shape)
    print(np.shape(arr0))
    print("+++++++++++++++++++++++++++")
    arr1 = np.array([1, 2, 3])
    print(arr1)
    print(arr1.shape)
    print(np.squeeze(arr1).shape)
    print("+++++++++++++++++++++++++++")
    arr2 = np.array([[1,2,3],[4,5,6]])
    print(arr2)
    print(arr2.shape)
    print(np.squeeze(arr2).shape)
    print("+++++++++++++++++++++++++++")
    arr3 = np.array([[1],[2],[3]])
    print(arr3)
    print(arr3.shape)
    print(np.squeeze(arr3).shape)




if __name__ == '__main__':
    demo1()