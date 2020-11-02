# -*- coding: utf-8 -*-
"""
@File    : test2.py
@Time    : 2020/11/2 4:00 下午
@Author  : fitz
@Description : 

"""

# -*- coding: utf-8 -*-
# @Time    : 2019/4/8 0:07
# @Author  : YYLin
# @Email   : 854280599@qq.com
# @File    : Third-Program-MultinomialNB-20news.py
# 从sklearn.datasets里导入新闻数据抓取器fetch_20newsgroups。
from sklearn.datasets import fetch_20newsgroups
from sklearn.model_selection import train_test_split
# CountVectorizer根据单词出现的次数表示单词的独热编码
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics import classification_report

# 加载数据集并进行划分
news = fetch_20newsgroups(subset='all')
print(len(news.data))
print(news.data[0])
X_train, X_test, y_train, y_test = train_test_split(news.data, news.target, test_size=0.25, random_state=33)

# 处理数据集
vec = CountVectorizer()
X_train = vec.fit_transform(X_train)
X_test = vec.transform(X_test)

# 使用朴素贝叶斯模型进行划分
from sklearn.naive_bayes import MultinomialNB

mnb = MultinomialNB()
mnb.fit(X_train, y_train)

# 测试数据集 显示预测的结果
y_predict = mnb.predict(X_test)
print('The accuracy of Naive Bayes Classifier is', mnb.score(X_test, y_test))
print(classification_report(y_test, y_predict, target_names=news.target_names))