def fac(n):
	return reduce(lambda x,y:x*y,range(1,n+1))

print reduce(lambda x,y:x+y,[int(x) for x in str(fac(100))])

