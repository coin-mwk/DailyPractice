# -*- coding: utf-8 -*-
"""
@File    : 04_翻译接口.py
@Time    : 2020/8/21 10:56 下午
@Author  : fitz

"""
import urllib.request
import urllib.parse


def main():
    """谷歌翻译接口练习"""
    url = 'https://fanyi.baidu.com/sug'
    date = {
        'kw': 'car'
    }
    headers = {
        'user-agent': 'Mozilla / 5.0(Macintosh; IntelMacOSX10_15_6) AppleWebKit/537.36(KHTML,likeGecko) Chrome/84.0.4147.135 Safari / 537.36'
    }
    # post请求必须进行编码
    date = urllib.parse.urlencode(date).encode("utf-8")
    print(date)
    request = urllib.request.Request(url=url, headers=headers, data=date)
    response = urllib.request.urlopen(request)
    content = response.read().decode("utf-8")
    print(content)



if __name__ == '__main__':
    main()


