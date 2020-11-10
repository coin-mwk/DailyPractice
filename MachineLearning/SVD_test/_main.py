#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/9 7:43 下午
# @Author : Fitz
# @File : _main.py
# @Description:


import svd


def main():

    testdata = [[1, 1, 1, 0, 0],
            [2, 2, 2, 0, 0],
            [3, 3, 3, 0, 0],
            [5, 5, 3, 2, 2],
            [0, 0, 0, 3, 3],
            [0, 0, 0, 6, 6]]
    estdata = svd.loadExData()
    svd.recommend(testdata, 1, N=3, percentage=0.8)  # 对编号为1的用户推荐评分较高的3件商品


if __name__ == '__main__':
    main()

