# -*- coding: utf-8 -*-
"""
@File    : 05_test.py
@Time    : 2020/8/22 9:29 上午
@Author  : fitz

"""

import urllib.request
import urllib.parse
import ssl
import json


def main():
    # 取消全局证书验证
    ssl._create_default_https_context = ssl._create_unverified_context
    url = 'https://fanyi.baidu.com/sug'
    date = {
        'kw': 'crawl'
    }
    # post 请求必须编码
    date = urllib.parse.urlencode(date).encode("utf-8")
    headers = {
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36',
    }
    request = urllib.request.Request(url=url, headers=headers, data=date)
    response = urllib.request.urlopen(request)
    content = response.read().decode("utf-8")

    # 反序列化
    obj = json.loads(content)
    s = json.dumps(obj, ensure_ascii=False)
    print(s)
    
    

if __name__ == '__main__':
    main()

