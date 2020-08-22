# -*- coding: utf-8 -*-
"""
@File    : 01_模拟浏览器模拟器发送请求.py
@Time    : 2020/8/21 9:33 上午
@Author  : fitz

"""

import urllib.request
# 全局取消证书验证
import ssl
ssl._create_default_https_context = ssl._create_unverified_context


def main():
    url = "https://www.cnblogs.com/zhuifeng-mayi/p/9652331.html"
    headers = {
        'user-agent': 'Mozilla / 5.0(Macintosh; IntelMacOSX10_15_6) AppleWebKit/537.36(KHTML,likeGecko) Chrome/84.0.4147.135 Safari / 537.36',
        'cookie': '_ga = GA1.2.1498036487.1589806626;__gads = ID = 3d3227a9c2c65e9f: T = 1589806626:S = ALNI_MbVY1RRyNy_xHDsMF_9tO6a3ElxGQ;UM_distinctid = 1722b0600b716 - 032369bb7e2873 - 30667d00 - 13c680 - 1722b0600b8b41;CNZZDATA1261691463 = 1510872962 - 1589855055 - https % 253A % 252F % 252Fwww.baidu.com % 252F % 7C1589855055;CNZZDATA1258637387 = 1273844497 - 1597227582 - https % 253A % 252F % 252Fwww.baidu.com % 252F % 7C1597227582;_gid = GA1.2.1855893327.1597883067'
    }
    request = urllib.request.Request(url=url, headers=headers)
    response = urllib.request.urlopen(request)
    print(response.read().decode("utf-8"))
    # print(response.readlines()[0])
    # print(response.getheaders())
    # print(response.geturl())
    # print(response.getcode())


if __name__ == '__main__':
    main()
