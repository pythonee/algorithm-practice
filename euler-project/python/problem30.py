sum(n for n in xrange(2,200000) if reduce(lambda x,y:x+y,[int(z)**5 for z in str(n)])==n)
