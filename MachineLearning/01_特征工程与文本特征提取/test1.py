# -*- coding: utf-8 -*-
"""
@File    : test1.py
@Time    : 2020/10/28 9:24 上午
@Author  : fitz
@Description : 字典特征提取

"""

from sklearn.feature_extraction import DictVectorizer



def main():

    dict_data = [{'city':'北京','temperature':100},{'city':'吴忠','temperature':90},{'city':'保定','temperature':400},{'city':'银川','temperature':160}]

    # 实例化
    dict = DictVectorizer()

    data = dict.fit_transform(dict_data)

    # 返回值为转换之前的数据格式
    print(dict.inverse_transform(data))

    # 返回特征值列表
    print(dict.get_feature_names())

    # 返回sparse矩阵
    print(data)


if __name__ == '__main__':
    main()
