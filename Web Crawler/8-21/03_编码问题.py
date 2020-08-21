# -*- coding: utf-8 -*-
"""
@File    : 03_编码问题.py
@Time    : 2020/8/21 10:00 下午
@Author  : fitz

"""
import urllib.request


def main():
    """url编码问题---urlencode"""
    url = "http://www.baidu.com/s?"
    date = {
        'wd': '韩红',
        'sex': '女'
    }
    date = urllib.parse.urlencode(date)
    url = url + date
    request = urllib.request.Request(url)
    response = urllib.request.urlopen(request)
    content = response.read().decode("utf-8")
    print(content)


if __name__ == '__main__':
    main()

