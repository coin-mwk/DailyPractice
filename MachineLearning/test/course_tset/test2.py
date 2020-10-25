# -*- coding: utf-8 -*-
"""
@File    : test2.py
@Time    : 2020/10/25 3:57 下午
@Author  : fitz

"""

from sklearn.model_selection import train_test_split
from sklearn.datasets import load_breast_cancer
from sklearn.naive_bayes import GaussianNB
from sklearn.model_selection import learning_curve
from sklearn.model_selection import ShuffleSplit
import numpy as np
from sklearn.naive_bayes import GaussianNB
import matplotlib.pyplot as plt
cancer = load_breast_cancer()

print('肿瘤的分类:',cancer['target_names'])
print('\n肿瘤的特征:\n',cancer['feature_names'])

X,y = cancer.data,cancer.target
X_train,X_test,y_train,y_test = train_test_split(X,y,random_state=38)

# 使用高斯朴素贝叶斯拟合数据
gnb = GaussianNB()
gnb.fit(X_train,y_train)

# 打印模型评分
print('训练集得分:{:.3f}'.format(gnb.score(X_train,y_train)))
print('测试集得分:{:.3f}'.format(gnb.score(X_test,y_test)))

# 高斯朴素贝叶斯的学习曲线
def plot_learning_curve(estimator, title, X, y, ylim=None, cv=None, n_jobs=1, train_sizes=np.linspace(.1, 1.0, 5)):
    plt.figure()
    plt.title(title)
    if ylim is not None:
        plt.ylim(*ylim)
    plt.xlabel("Training examples")
    plt.ylabel("Score")
    train_sizes, train_scores, test_scores = learning_curve(estimator, X, y, cv=cv, n_jobs=n_jobs,
                                                            train_sizes=train_sizes)
    train_scores_mean = np.mean(train_scores, axis=1)
    test_scores_mean = np.mean(test_scores, axis=1)
    plt.grid()
    plt.plot(train_sizes, train_scores_mean, 'o-', color="r", label="Training score")
    plt.plot(train_sizes, test_scores_mean, 'o-', color="g", label="Cross-valldation score")
    plt.legend(loc="lower right")
    return plt

title = "Learning Curves (Naive Bayes)"
cv = ShuffleSplit(n_splits=100, test_size=0.2, random_state=0)
estimator = GaussianNB()
plot_learning_curve(estimator, title, X, y, ylim=(0.9, 1.01), cv=cv, n_jobs=4)
plt.show()