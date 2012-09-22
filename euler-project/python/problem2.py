def even_fib_sum(limit):
    a,b,sum=0,1,0
    while a<=limit:
        if a%2 == 0:
            sum +=a
        a,b=b,a+b
    return sum

