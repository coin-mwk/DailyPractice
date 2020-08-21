# -*- coding: utf-8 -*-
"""
@File    : 01_模拟浏览器模拟器发送请求.py
@Time    : 2020/8/21 9:33 上午
@Author  : fitz

"""

import urllib.request


def main():
    url = "http://www.baidu.com"
    response = urllib.request.urlopen(url=url)
    print(type(response))
    print(response.readlines()[0])
    print(response.getheaders())
    print(response.geturl())
    print(response.getcode())


if __name__ == '__main__':
    main()
