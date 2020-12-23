#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/12/22 10:02 下午
# @Author : Fitz
# @Description:


#jacobi迭代法
import numpy as np


def get_base(A):#获得一个基，在基上修改
    base=list(np.zeros((len(A),len(A))))
    D=[]
    for i in base:
        D.append(list(i))
    return D

def get_D(A):#获得对角矩阵D
    D=get_base(A)
    for i in A:
        D[A.index(i)][A.index(i)]=A[A.index(i)][A.index(i)]
    return D

def get_LU(A,D):#获得L+U
    AA=np.array(A)
    DD=np.array(D)
    LLUU=DD-AA
    LU=[]
    for i in LLUU:
        LU.append(list(i))
    return LU

def matrix_to_list(x):#将矩阵转换为列表的函数，numpy中应当有这一函数
    d=[]
    ans=[]
    for i in x:
        d.append(i.tolist())
    for i in d:
        ans.append(i[0])
    return ans

def roll(A,b,x0):#主循环结构
    D=get_D(A)
    LU=np.mat(get_LU(A,D))
    D=np.mat(get_D(A))
    B=D.I*LU
    b1=np.mat(b).T
    f=D.I*b1
    x=np.mat(x0).T
    y=B*x+f
    return matrix_to_list(y.T)

def aa(A,b,x0,x1,e):#输入系数矩阵，方程组右端b，初始值x0，以及需要的绝对误差限
    n=0
    ans=[]
    ans.append(x1)
    ans.append(x0)
    ans1=[]
    ans1.append(x1[0])
    ans1.append(x0[0])
    while abs(ans[-1][0][1]-ans[-2][0][1])>e:
        n=n+1
        x0=roll(A,b,x0)
        ans.append(x0)
    for i in ans:
        ans1.append(i[0])
    return ans1,n#输出迭代结果和迭代次数

def ca():
    A = [[10, 3, 1],
         [2, -10, 3],
         [1, 3, 10]]
    b = [[14, -5, 14]]
    x1 = [[0, 0, 0]]
    x0 = roll(A, b, x1)
    e=0.00001
    # print(aa(A,b,x0,x1,e))
    # print("初始值为：{}".format(x1))
    # print("当e=0.00001时雅可比的迭代次数为{}次".format(aa(A, b, x0, x1, e)[1]))
    # print("最终结果为：")
    # print(aa(A, b, x0, x1, e)[0][-1])
    return aa(A, b, x0, x1, e)


if __name__ == '__main__':
    ca()
