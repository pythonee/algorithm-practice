import random
import heapq
import benchmark

def nth_ele1(lst, n):
    pivot = lst[0]

    below = [s for s in lst if s < pivot]
    above = [s for s in lst if s > pivot]
    i, j = len(below), len(lst) - len(above)

    if n < i : return nth_ele1(below, n)
    if n >= j : return nth_ele1(above, n-j)
    else: return pivot

def nth_ele2(lst, n):
    return heapq.nlargest(n, lst)[-1]

if __name__ == '__main__':
    lst = [2,2,2,2,2,2,2]
    benchmark.rt(nth_ele1, lst,6)
    benchmark.rt(nth_ele2, lst,6)

    

