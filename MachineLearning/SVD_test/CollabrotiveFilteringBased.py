#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/12/9 7:39 下午
# @Author : Fitz
# @Description:

from sklearn import cross_validation as cv


def demo():

    train_data, test_data = cv.train_test_split(small_data, test_size=0.2)

if __name__ == '__main__':
    demo()