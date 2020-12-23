#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/12/18 9:47 下午
# @Author : Fitz
# @Description:      Gauss Seidel迭代法


import numpy as np


def get_base(A):
    #获得一个基
    base = list(np.zeros((len(A), len(A))))
    D = []
    for i in base:
        D.append(list(i))
    return D


def get_U(A):
    #获得U
    D = get_base(A)
    i = 0
    while i < len(A):
        k = i+1
        while k < len(A):
            D[i][k] = -A[i][k]
            k = k+1
        i = i+1
    return D


def get_DL(A,U):
    #获得D-L
    AA = np.array(A)
    UU = np.array(U)
    DDLL = AA + UU
    DL = []
    for i in DDLL:
        DL.append(list(i))
    return DL


def get_DL_I(DL):
    #获得D-L的逆
    DL1 = np.mat(DL)
    DL2 = DL1.I
    return DL2


def get_B(DLI,U):#获得B
    U1 = np.mat(U)
    B = DLI * U1
    return B


def get_f(DLI, b):#获得f
    b1 = np.mat(b)
    f = DLI * b1.T
    return f


def matrix_to_list(x):
    d = []
    ans = []
    for i in x:
        d.append(i.tolist())
    for i in d:
        ans.append(i[0])
    return ans


def roll(A, b, x0):#主循环结构
    U = get_U(A)
    DL = get_DL(A,U)
    DLI = get_DL_I(DL)
    B = get_B(DLI, U)
    f = get_f(DLI, b)
    x = np.mat(x0).T
    y = B * x + f
    return matrix_to_list(y.T)


def g_s(A, b, x0, x1, e):
    """"输入系数矩阵，方程组右端b，初始值x0，以及需要的绝对误差限"""
    n = 0
    ans = []
    ans.append(x1)
    ans.append(x0)
    ans1 = []
    ans1.append(x1[0])
    ans1.append(x0[0])
    while abs(ans[-1][0][1]-ans[-2][0][1]) > e:
        n = n+1
        x0 = roll(A, b, x0)
        ans.append(x0)
    for i in ans:
        ans1.append(i[0])
    return ans1, len(ans1)-2


def main():
    A = [[10, 3, 1],
         [2, -10, 3],
         [1, 3, 10]]
    b = [[14, -5, 14]]
    x1 = [[0, 0, 0]]
    x0 = roll(A, b, x1)
    e = 0.00001
    # print("初始值为：{}".format(x1))
    # print("当e=0.00001时高斯-塞德尔的迭代次数为{}次".format(g_s(A, b, x0, x1, e)[1]))
    # print("最终结果为：")
    # print(g_s(A, b, x0, x1, e)[0][-1])
    arr_gs = g_s(A, b, x0, x1, e)
    from test3 import ca
    arr_ca = ca()
    print(arr_ca)
    print("++++++++++++++++++++++++++++++")
    print(g_s(A, b, x0, x1, e))
    # print()

    import numpy as np
    import matplotlib.pyplot as plt
    import mpl_toolkits.mplot3d

    from mpl_toolkits.mplot3d import axes3d
    import matplotlib.pyplot as plt
    import pandas as pd

    #  [, , ], [0.929, 1.0550000000000002, 0.929], [0.9906, 0.9645000000000001, 0.9906],
    #  [1.01159, 0.9953000000000001, 1.01159], [1.000251, 1.005795, 1.000251],
    #  [0.9982364000000001, 1.0001255, 0.9982364000000001], [1.00013871, 0.9991182000000001, 1.00013871],
    #  [1.0002506690000001, 1.0000693550000002, 1.0002506690000001], [0.9999541266, 1.0001253345, 0.9999541266],
    #  [0.9999669869900001, 0.9999770633, 0.9999669869900001], [1.0000101823110001, 0.999983493495, 1.0000101823110001]]
    x1 = [1.4000000000000001,1.4000000000000001,1.11,5]
    z1 = [0.5,0.5,1,1]
    y1 = [1.4000000000000001,1.4000000000000001,1.2000000000000002,3]
    x2 = [3,1,5,1]
    y2 = [1,4,1,5]
    z2 = [2,2,2,1]
    x3 = [1,1,1,1]
    y3 = [1,1,1,1]
    z3 = [1,1,1,1]

    # new a figure and set it into 3d
    fig = plt.figure()
    ax = fig.gca(projection='3d')

    # set figure information
    ax.set_title("3D")
    ax.set_xlabel("X")
    ax.set_ylabel("Y")
    ax.set_zlabel("Z")

    # draw the figure, the color is r = read
    figure1 = ax.plot(x1, y1, z1, c='r')
    figure2 = ax.plot(x2, y2, z2, c='b')
    plt.show()


if __name__ == '__main__':
    main()
