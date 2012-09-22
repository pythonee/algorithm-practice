def findMaxSumOfSubArray(lst):
    cursum = 0
    maxsum = 0
    for ele in lst:
        cursum += ele
        if cursum < 0:
            cursum = 0
        if cursum > maxsum:
            maxsum = cursum
    if maxsum == 0:
        maxsum = lst[0]
        for ele in lst:
            if ele > maxsum:
                maxsum = ele

    print maxsum


if __name__ == '__main__':
    lst_1 = [-1,-2,-3]
    lst_2 = [-1,0,1]
    lst_3 = [0,1,2,3]
    lst_4 = [-1,2,5,4,78,-44,-3,-5,7,23,8,-345,-2,9,-46]

    findMaxSumOfSubArray(lst_1)
    findMaxSumOfSubArray(lst_2)
    findMaxSumOfSubArray(lst_3)
    findMaxSumOfSubArray(lst_4)
