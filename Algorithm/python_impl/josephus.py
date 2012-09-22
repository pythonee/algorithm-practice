# -*- coding:utf-8 -*-

def josephus( n, s , m ):
    #直接用数字表示人会更节省空间，然后通过这些数字来
    #获取真正存放人的列表的数据进行排序，在人很多的时候，
    #就很节省内存了
    person = [x + 1 for x in range( n )]
    print( person )
    t = []
    while len( person ):

        #下面这行代码是最具思想性的一行
        #a是索引，%len(person)可以保证a一直在
        # ··［0：len(person)]之间
        s = ( s + m - 1 ) % len( person )
        tmp = person[s]
        t.append( tmp )
        person.remove( tmp )
    print( t )

josephus( 8, 0 , 4 )
