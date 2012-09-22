def find_lost_number(lst):
    N = len(lst) + 1
    missing_num = 0
    for index,ele in enumerate(lst):
        missing_num ^= (index+1)^ele
    return missing_num^N


if __name__ == '__main__':
    print find_lost_number([1,3,4,6,2,8,7,10,5])
    print find_lost_number([3,2,1,5])
