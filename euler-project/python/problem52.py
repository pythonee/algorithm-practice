def filterFunc(n):
	keys=dict.fromkeys(list(str(n)))
	for x in xrange(2,7):
		for d in list(str(x*n)):
			if not keys.has_key(d): return False
	return True


filter(filterFunc,range(1,200000))

