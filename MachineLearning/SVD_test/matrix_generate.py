#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/12 6:53 下午
# @Author : Fitz
# @Description:
#
# loadtxt(fname, dtype=<class 'float'>, comments='#', delimiter=None, converters=None, skiprows=0, usecols=None, unpack=False, ndmin=0)
#
# fname要读取的文件、文件名、或生成器。
# dtype数据类型，默认float。
# comments注释。
# delimiter分隔符，默认是空格。
# skiprows跳过前几行读取，默认是0，必须是int整型。
# usecols：要读取哪些列，0是第一列。例如，usecols = （1,4,5）将提取第2，第5和第6列。默认读取所有列。
# unpack如果为True，将分列读取。
#
# 作者：Wang华子
# 链接：https://www.jianshu.com/p/ef37f739b531
# 来源：简书
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


from numpy import *

def data_split1():


    data = mat([[0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 5],
     [1, 0, 0, 3, 0, 4, 0, 0, 0, 0, 3],
     [2, 0, 0, 0, 4, 0, 0, 1, 0, 4, 0],
     [3, 3, 4, 0, 0, 0, 0, 2, 2, 0, 0],
     [4, 4, 5, 0, 0, 0, 0, 5, 5, 0, 0],
     [5, 0, 0, 0, 5, 0, 1, 0, 0, 5, 0],
     [6, 3, 4, 0, 0, 0, 0, 5, 5, 0, 1],
     [7, 0, 0, 4, 0, 4, 0, 0, 0, 0, 4],
     [8, 0, 0, 2, 0, 2, 5, 0, 0, 1, 2],
     [9, 0, 0, 0, 5, 0, 0, 0, 0, 4, 0],
     [10, 2, 1, 2, 1, 2, 1, 1, 2, 2, 1]])
    print(data[1, :])
    print(data[1, 1:4])

    print(nonzero(data[1, :].A==0)[1])


if __name__ == '__main__':
    data_split1()