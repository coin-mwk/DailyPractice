# -*- coding: utf-8 -*-
"""
@File    : 04_翻译接口.py
@Time    : 2020/8/21 10:56 下午
@Author  : fitz

"""
import urllib.request
import urllib.parse
import ssl


def main():
    """谷歌翻译接口练习"""
    # 请求方式为GET
    ssl._create_default_https_context = ssl._create_unverified_context

    url = 'https://translate.google.cn/translate_a/single?client=webapp&sl=auto&tl=zh-CN&hl=zh-CN&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca&dt=rw&dt=rm&dt=sos&dt=ss&dt=t&otf=2&ssel=0&tsel=0&xid=45662847&kc=3&tk=271651.189216&q=crawl'

    headers = {
        'user-agent': 'Mozilla / 5.0(Macintosh; IntelMacOSX10_15_6) AppleWebKit/537.36(KHTML,likeGecko) Chrome/84.0.4147.135 Safari / 537.36'
    }


    request = urllib.request.Request(url=url, headers=headers)
    response = urllib.request.urlopen(request)
    content = response.read().decode("utf-8")
    print(content)


if __name__ == '__main__':
    main()


