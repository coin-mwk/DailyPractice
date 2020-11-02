# -*- coding: utf-8 -*-
"""
@File    : test1.py
@Time    : 2020/11/2 2:58 下午
@Author  : fitz
@Description : 朴素贝叶斯文本分类

1、加载数据
2、划分数据集
3、特征工程，文本特征抽取----> tf-idf
4、朴素贝叶斯算法预估器流程
5、算法评估

"""
import ssl

from sklearn.datasets import fetch_20newsgroups
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB


from sklearn.preprocessing import StandardScaler


def naiveBayes():
    # 获取数据
    news = fetch_20newsgroups(subset="all")

    # 划分数据集
    x_train, x_test, y_train, y_test = train_test_split(news.data, news.target, test_size=0.25)
    print(len(y_train))
    # 文本特征抽取
    tf = TfidfVectorizer()
    x_train = tf.fit_transform(x_train)   # 训练集的特征抽取
    x_test = tf.transform(x_test)
    print(tf.get_feature_names())

    # 朴素贝叶斯算法预估器流程
    estimator = MultinomialNB()
    estimator.fit(x_train, y_train)

    # 模型评估
    # 方法一：直接比对真实值和预测值

    #拟合程度？
    y_train_predict = estimator.predict(x_train)
    print("y_train:\n", y_train)
    print("y_train_predict:\n", y_train_predict)

    #泛化能力？
    y_test_predict = estimator.predict(x_test)
    print("y_test:\n", y_test)
    print("y_test_predict:\n", y_test_predict)

    # print("直接比对真实值和预测值：\n", y_test == y_predict)

    # 可视化
    from matplotlib import pyplot as plt


    print(y_train)
    plt.plot(y_train)
    plt.show()

    # 方法二：计算准确率
    score = estimator.score(x_test, y_test)
    print("准确率为：\n", score)



if __name__ == '__main__':
    naiveBayes()

