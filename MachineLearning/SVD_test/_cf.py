#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 9:00 下午
# @Author : Fitz
# @Description: 实现基于item的CF推荐过程
# 1、计算物品之间的相似度
# 2、根据物品的相似度和用户的历史行为给用户生成推荐列表


import numpy as np
import pandas as pd


def cf_pre(user_count, item_count):
    # 计算物品之间的相似度
    # 1、导入数据
    ratings = pd.read_csv('user_item.base', sep='\t', encoding='utf-8', header=None,
                          names=['user_id', 'movie_id', 'rating', 'timestamp'], engine='python')
    # 构建user-item矩阵
    Ratings = ratings.pivot(index='user_id', columns='movie_id', values='rating').fillna(0)
    # 将DataFrame格式转换为numpy的ndarray格式
    dataMat = Ratings.values
    # user-item矩阵的稀疏性
    sparsity = round(1.0 - len(ratings) / float(15 * 733), 3)
    print('The sparsity level of MovieLens1M dataset is ' + str(sparsity * 100) + '%')
    # 2、统计喜欢每部电影的用户数量，（求user_item评分矩阵每一列的非零元素个数，将user_item转置求每一行的非零元素的个数）
    transpose_dataMat = dataMat.T
    movie_popular = list()            # 统计喜欢每部电影的用户数
    user_popular = list()             # 统计每个用户喜欢的电影总数
    for i in range(item_count):
        nonzero_count = np.mat(np.nonzero(transpose_dataMat[i])).shape[1]      # 转置后第i行非零元素的个数
        movie_popular.append(nonzero_count)
    for i in range(15):
        nonzero_count = np.mat(np.nonzero(dataMat[i])).shape[1]                # 第i行非零元素的个数
        user_popular.append(nonzero_count)
    # 3.1、计算出喜欢两两物品用户数，填入矩阵C中
    # 得到矩阵C后，利用公式计算物品之间的相似度得到相似度矩阵W
    C = np.mat(np.zeros(item_count * item_count).reshape((item_count, item_count)))
    W = np.mat(np.zeros(item_count * item_count).reshape((item_count, item_count)))
    for i in range(item_count):
        for j in range(item_count):
            count = 0
            N_i = movie_popular[i]    # 喜欢电影i的用户数
            N_j = movie_popular[j]    # 喜欢电影j的用户数
            W_count = 0.0            # 公式Wij的分子
            for k in range(user_count):
                if dataMat[k, i] != 0:
                    if dataMat[k, j] != 0:
                        # 此时用户k同时喜欢电影i和j
                        count += 1
                        W_count += np.log(1+user_popular[k])
            # C[i, j] = count
            if np.sqrt(N_i * N_j) != 0:
                W[i, j] = W_count / (np.sqrt(N_i * N_j))
            else:
                W[i, j] = 0

    # print(W)
    # 关联电影id与title
    movieId_name_dict = {}
    for row in open("ml-1m/movies.dat", "r"):
        movie_id, movie_name, movie_desc = row.split('::')
        movieId_name_dict[movie_id] = movie_name
    # 计算准确率  平方绝对误差
    from sklearn.metrics import mean_absolute_error
    x_norm = np.linalg.norm(W, ord=None, axis=None, keepdims=True)
    pred = (np.inner(dataMat, W))/x_norm
    print("CF算法的平均绝对误差为：{0}".format(mean_absolute_error(dataMat, pred)))
    return W, dataMat, movieId_name_dict


# 943 * 1682
def recommendation(user, N, user_count, item_count):
    user = user
    if user < 0 or user > user_count:
        print("请正确输入参数！")
        return
    # 为用户user推荐N部电影
    W, dataMat, movieId_names = cf_pre(user_count, item_count)
    dataMat = np.mat(dataMat)
    mt_liked = np.sort(dataMat[user], axis=1)[0, -1]
    item_id = 0
    for i in range(item_count):
        if mt_liked == dataMat[user, i]:
            item_id = i
    # 求出与item_id最相似的N部电影推荐给用户user
    rec_list = dict()
    for i in range(item_count):
        if W[item_id, i] != 0:
            rec_list[i] = W[item_id, i]
    rec_list = sorted(rec_list.items(), key=lambda d: d[1], reverse=True)
    length_rec = len(rec_list)
    if N > length_rec:
        print("只有", length_rec, "部电影可被推荐！")
        print("为用户", user, "推荐的", length_rec, "部电影如下：")
        for temp in rec_list[:N]:
            print(movieId_names[str(temp[0])])
    print("为用户", user, "推荐的", N, "部电影如下：")
    for temp in rec_list[:N]:
        print(movieId_names[str(temp[0])])


def main():
    user_count = 15
    item_count = 733
    recommendation(user=6, N=12, user_count=user_count, item_count=item_count)


if __name__ == '__main__':
    main()
