# -*- coding: utf-8 -*-
"""
@File    : test3.py
@Time    : 2020/10/29 8:39 上午
@Author  : fitz
@Description : 使用tf-idf对文本更好的分类

"""

from sklearn.feature_extraction.text import TfidfVectorizer
import jieba


def main():
    """中文特征值化"""
    # 用jieba进行分词
    con1 = jieba.cut("虽然两本都是英文书，但是对于中文presentation也有借鉴的地方。")
    con2 = jieba.cut("第一本是比较全面的介绍整个presentation的结构，语言，以及一部分的PPT设计。")
    con3 = jieba.cut("而第二本则是专注在业余者怎么设计出专业的PPT. 两本都是非常非常好的书.")
    # 分词后的返回值为一个对象，将其转为列表中的一个一个的值
    content1 = list(con1)
    content2 = list(con2)
    content3 = list(con3)
    # 将列表转换为带空格的字符串
    c1 = ' '.join(content1)
    c2 = ' '.join(content2)
    c3 = ' '.join(content3)

    tf = TfidfVectorizer()
    data = tf.fit_transform([c1,c2,c3])
    print(tf.get_feature_names())

    print(data.toarray())


if __name__ == '__main__':
    main()
