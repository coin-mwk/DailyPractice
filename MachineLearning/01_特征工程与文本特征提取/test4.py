# -*- coding: utf-8 -*-
"""
@File    : test4.py
@Time    : 2020/10/29 8:08 下午
@Author  : fitz
@Description : 降维 ：特征选择、主成分分析（PCA）

"""


from sklearn.feature_selection import VarianceThreshold
from sklearn.decomposition import PCA

def var():
    var = VarianceThreshold(threshold=0)
    data = var.fit_transform([[0,2,0,3], [0,1,4,3], [0,1,1,3]])
    print(data)


def pca():
    pca = PCA(0.9)
    data = pca.fit_transform([[0,2,0,3], [0,1,4,3], [0,1,1,3]])
    print(data)


if __name__ == '__main__':
    pca()

