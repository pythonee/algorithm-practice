import itertools
import benchmark

# fast, but not take account to repeat element
def perm1(lst,n): 
    return itertools.permutations(lst,n)

# faster and not consider the repeat element
def perm2(lst, n): 
    if n == 0:
        yield []

    for i in range(len(lst)):
        rest = lst[:i] + lst[i+1:]
        for p in perm2(rest, n-1):
            yield lst[i:i+1] + p


if __name__ == '__main__':
    lst = [0,1,2,3,4,5,6,7,8,9]

    benchmark.rt(perm1 , lst, len(lst))
    benchmark.rt(perm2 , lst, len(lst))
