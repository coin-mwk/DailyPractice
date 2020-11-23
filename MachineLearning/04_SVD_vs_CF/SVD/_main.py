#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 2:20 下午
# @Author : Fitz
# @Description:


import preprocessing
import svd_01


def main():
    dataMat = preprocessing.loading_data()
    print(dataMat)


if __name__ == '__main__':
    main()
