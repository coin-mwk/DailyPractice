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
    headers = {
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36',
        'Cookie': 'BIDUPSID = 7B29EE858C76326615492301466E958B;PSTM = 1589793848;BAIDUID = 7B29EE858C7632660E11D6026371F4E9: FG = 1;BD_UPN = 123253;MCITY = - % 3A;BDUSS = piNmdCflJmUm45TGNQbmJpTElMT3VrbElWV01DRFR6QkJqd29Xb2NWbWU1VnhmRVFBQUFBJCQAAAAAAAAAAAEAAADrdztoS2V2aW7TyDEyMwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJ5YNV - eWDVfMH;BDUSS_BFESS = piNmdCflJmUm45TGNQbmJpTElMT3VrbElWV01DRFR6QkJqd29Xb2NWbWU1VnhmRVFBQUFBJCQAAAAAAAAAAAEAAADrdztoS2V2aW7TyDEyMwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJ5YNV - eWDVfMH;BDORZ = B490B5EBF6F3CD402E515D22BCDA1598;delPer = 0;BD_CK_SAM = 1;PSINO = 1;BD_HOME = 1;H_PS_PSSID = 1464_32573_31660_32349_32045_32115_31709_26350_32508_32482;sugstore = 0;H_PS_645EC = fbdcR7NCoNIvLJ9cr % 2Fo % 2BDmAXcMBzk1s % 2BS0Q2OyxOpXJtrFWab % 2F7uKQeMF % 2Fw'
    }
    request = urllib.request.Request(url=url ,headers=headers)
    response = urllib.request.urlopen(request)
    content = response.read().decode("utf-8")
    print(content)


if __name__ == '__main__':
    main()

