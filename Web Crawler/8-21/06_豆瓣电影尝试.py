# -*- coding: utf-8 -*-
"""
@File    : 06_豆瓣电影尝试.py
@Time    : 2020/8/23 11:03 下午
@Author  : fitz

"""

import urllib.request
import urllib.parse
import ssl
import json


def main():
    ssl._create_default_https_context = ssl._create_unverified_context
    url = "https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&page_limit=50&page_start=0"
    headers = {
        'user-agent': 'Mozilla / 5.0(Macintosh; IntelMacOSX10_15_6) AppleWebKit/537.36(KHTML,likeGecko) Chrome/84.0.4147.135 Safari / 537.36',
        'Cookie': 'bid = p1 - b_Q2l5c8;gr_user_id = 3fe73754 - 6372 - 434e - b811 - 919869dc25bd;_vwo_uuid_v2 = D04395269AD8D9892E8355B0BA4629B21 | 41fa7f8627f419f41125f1b10f036c40;__gads = ID = 8c45a3e4ac93a854: T = 1590638754:S = ALNI_MYzuR968QwTLzXgcmR1PbFwUxTlSw;_ga = GA1.2.750621692.1590638753;__utmv = 30149280.15775;douban - profile - remind = 1;ll = "118405";douban - fav - remind = 1;dbcl2 = "157759898:7Mzr3Tx8o9E";_pk_ref.100001.4cf6 = % 5B % 22 % 22 % 2C % 22 % 22 % 2C1598195055 % 2C % 22https % 3A % 2F % 2Fwww.baidu.com % 2Flink % 3Furl % 3DCZk6u3RhBhAu45c - hBrKXZSH - -juv8ToySDXqn1YDPMlr2I4Xw33nNoFDvY40OzG % 26wd % 3D % 26eqid % 3Dc733739400034c5b000000035f42853b % 22 % 5D;_pk_ses.100001.4cf6 = *;ap_v = 0, 6.0;__utma = 30149280.750621692.1590638753.1591268025.1598195055.3;__utmb = 30149280.0.10.1598195055;__utmc = 30149280;__utmz = 30149280.1598195055.3.2.utmcsr = baidu | utmccn = (organic) | utmcmd = organic;__utma = 223695111.750621692.1590638753.1590638951.1598195055.2;__utmb = 223695111.0.10.1598195055;__utmc = 223695111;__utmz = 223695111.1598195055.2.2.utmcsr = baidu | utmccn = (organic) | utmcmd = organic;__yadk_uid = vVGJ4gEBbYEJL4IKAvAm7hcv1JtNDIkt;_pk_id.100001.4cf6 = 97d0b1ae00f9453f.1590638951.2.1598195279.1590638966.'
    }

    request = urllib.request.Request(url=url, headers=headers)
    response = urllib.request.urlopen(request)
    contents = response.read().decode("utf-8")
    obj = json.loads(contents)
    contents = json.dumps(obj, ensure_ascii=False)
    print(contents)





if __name__ == '__main__':
    main()

