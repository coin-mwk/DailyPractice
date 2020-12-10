#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/12/10 9:14 上午
# @Author : Fitz
# @Description:
#               数据集--->>>MovieLens 1M数据集
#               方法：SVD,


import numpy as np
import pandas as pd


def svd_pre(user_id, N):
    # 获取数据
    ratings = pd.read_csv('../ml-1m/ratings.dat', sep='::', encoding='utf-8', header=None, names=['user_id', 'movie_id', 'rating', 'timestamp'], engine='python')
    users = pd.read_csv('../ml-1m/users.dat', sep='::', encoding='utf-8', header=None, names=['user_id', 'gender', 'age', 'occ_desc', 'zipcode'], engine='python')
    movies = pd.read_csv('../ml-1m/movies.dat', sep='::', encoding='utf-8', header=None, names=['movie_id', 'title', 'genres'], engine='python')
    n_users = users.user_id.unique().shape[0]
    n_movies = movies.movie_id.unique().shape[0]
    print("Number of users = ", n_users, " | Number of movies = ", n_movies)
    # 构建user-item矩阵
    Ratings = ratings.pivot(index='user_id', columns='movie_id', values='rating').fillna(0)
    # 经DataFrame格式转换为numpy的ndarray格式
    R = Ratings.values
    # user-item矩阵的稀疏性
    sparsity = round(1.0 - len(ratings) / float(n_users * n_movies), 3)
    print('The sparsity level of MovieLens1M dataset is ' + str(sparsity * 100) + '%')
    # 进行奇异值分解
    from scipy.sparse.linalg import svds
    U, sigma, Vt = svds(R, k=98)
    # 构建对角矩阵
    sigma = np.diag(sigma)
    # 构建预测评分矩阵
    all_user_predicted_ratings = np.dot(np.dot(U, sigma), Vt)
    preds = pd.DataFrame(all_user_predicted_ratings, columns=Ratings.columns)
    # 获取要推荐的用户的预测列表，
    user_row_number = user_id - 1
    sorted_user_predictions = preds.iloc[user_row_number].sort_values(ascending=False)  # 降序
    # 合并此用户评分信息与电影信息
    user_data = ratings[ratings.user_id == user_id]
    # user_full 包括6列['user_id', 'movie_id', 'rating', 'timestamp', 'title', 'genres']
    user_full = (user_data.merge(movies, how='left', left_on='movie_id', right_on='movie_id').
                 sort_values(['rating'], ascending=False)
                 )
    print('User {0} has already rated {1} movies.'.format(user_id, user_full.shape[0]))
    print('Recommending highest {0} predicted ratings movies not already rated.'.format(20))
    # 为用户user_id推荐N部电影

    # 未评分的电影
    preds_not_rated = movies[~movies['movie_id'].isin(user_full['movie_id'])]
    print(sorted_user_predictions.head(2))
    print(preds_not_rated.head(2))
    preds_not_rated = preds_not_rated.merge(pd.DataFrame(sorted_user_predictions).reset_index(), how='left', left_on='movie_id', right_on='movie_id')
    print(preds_not_rated)

    # recommendations = (movies[~movies['movie_id'].isin(user_full['movie_id'])].
    #                        merge(pd.DataFrame(sorted_user_predictions).reset_index(), how='left',
    #                              left_on='movie_id',
    #                              right_on='movie_id').
    #                        rename(columns={user_row_number: 'Predictions'}).
    #                        sort_values('Predictions', ascending=False).
    #                        iloc[:20, :-1]
    #                        )
    # print(recommendations)


def main():
    svd_pre(user_id=5, N=20)


if __name__ == '__main__':
    main()