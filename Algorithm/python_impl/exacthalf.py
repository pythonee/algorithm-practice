# -*- coding: utf-8 -*-
"""
Find the majority element in an array
"""

def majority(a):
    count = 1
    current = a[0]
    for x in a[1::]:
        if x == current:
            count += 1
        else:
            count -= 1
        if count==0:
            current = x
            count = 1
    if 2*a.count(current)>len(a):
        return current
    else:
        return None

"""
找出2n个数字重复n次出现的数字
http://fayaa.com/tiku/view/54/
"""
def exactly_half(a):
    x = majority(a[1::])
    if x:
        return x
    else:
        return a[0]
