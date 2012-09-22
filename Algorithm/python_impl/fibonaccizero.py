def count_fibonaci_zero(num):
    count = 0
    for x in range(5,num+1):
        k = x
        while(k%5==0):
            k /= 5
            count += 1
        x += 5
    return count
if __name__ == '__main__':
    print count_fibonaci_zero(5)
    print count_fibonaci_zero(18)
    print count_fibonaci_zero(20)
    print count_fibonaci_zero(100)
    print count_fibonaci_zero(1000)
