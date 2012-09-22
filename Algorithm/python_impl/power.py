def power(base, n):
    result = 1
    while n > 0:
        if n & 1: # 1-bit                                                                                             
            result *= base
        else: # 0-bit, no change                                                                                       
            pass
        n = n >> 1
        print n
        base *= base # double myself, base^(2^k) == (base^(2^(k-1)))^2
        #print base
    return result

if __name__ == '__main__':
    print power(2,2)
    print power(2,3)
    print power(2,5)
    #print power(2,7)
