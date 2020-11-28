#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 9:00 下午
# @Author : Fitz
# @Description: 实现基于item的CF推荐过程
# 1、计算物品之间的相似度
# 2、根据物品的相似度和用户的历史行为给用户生成推荐列表


import numpy as np


def cul_sim():
    # 计算物品之间的相似度
    # 1、导入数据
    from SVD_vs_CF.preprocessing import loading_data
    dataMat, movieId_name_dict = loading_data()
    # 2、统计喜欢每部电影的用户数量，（求user_item评分矩阵每一列的非零元素个数，将user_item转置求每一行的非零元素的个数）
    transpose_dataMat = dataMat.T
    movie_popular = list()            # 统计喜欢每部电影的用户数
    user_popular = list()             # 统计每个用户喜欢的电影总数
    for i in range(938):
        nonzero_count = np.mat(np.nonzero(transpose_dataMat[i])).shape[1]      # 转置后第i行非零元素的个数
        movie_popular.append(nonzero_count)
    for i in range(15):
        nonzero_count = np.mat(np.nonzero(dataMat[i])).shape[1]                # 第i行非零元素的个数
        user_popular.append(nonzero_count)
    # 3.1、计算出喜欢两两物品用户数，填入矩阵C中
    # 得到矩阵C后，利用公式计算物品之间的相似度得到相似度矩阵W
    C = np.mat(np.zeros(938 * 938).reshape((938, 938)))
    W = np.mat(np.zeros(938 * 938).reshape((938, 938)))
    for i in range(938):
        for j in range(938):
            count = 0
            N_i = movie_popular[i]    # 喜欢电影i的用户数
            N_j = movie_popular[j]    # 喜欢电影j的用户数
            W_count = 0.0            # 公式Wij的分子
            for k in range(15):
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
    return W, dataMat, movieId_name_dict


# 943 * 1682
def recommendation(user, N):
    # 为用户user推荐N部电影
    W, dataMat, movieId_names = cul_sim()
    mt_liked = np.sort(dataMat[user], axis=1)[0, -1]
    item_id = 0
    for i in range(938):
        if mt_liked == dataMat[user, i]:
            item_id = i
    # 求出与item_id最相似的N部电影推荐给用户user
    rec_list = dict()
    for i in range(938):
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
    recommendation(12, 7)


if __name__ == '__main__':
    main()