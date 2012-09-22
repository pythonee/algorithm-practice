# -*- coding:utf-8 -*-

import time
def hanoi( n, a, b, c ):
    if n == 1:
        print a, "————>", c
        #只有一个时，从a移到c

    else:

        #当n大于等于2的时候，把n-1个移到b上，

        hanoi( n - 1, a, c, b )
        #把a上的最后一个移动到c
        print a, "————>", c

        #把b上的n-1个移动到c
        hanoi( n - 1, b, a , c )

start = time.time()
hanoi( 3, 'a', 'b', 'c' )
end = time.time()
print "The time used:%f" % ( end - start )
