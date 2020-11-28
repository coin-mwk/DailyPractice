#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 2:20 下午
# @Author : Fitz
# @Description:


from SVD_vs_CF.preprocessing import loading_data
# import svd_01
import numpy as np


def main():
    dataMat = loading_data()
    print(dataMat)


# def demo():
    # svd_01.matrixFill(dataMat)



if __name__ == '__main__':
    # demo()
    main()
