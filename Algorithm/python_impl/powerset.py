# From another DaniWeb snippet
def int2bin(n, count=24):
    """returns the binary of integer n, using count number of digits"""
    return "".join([str((n >> y) & 1) for y in range(count-1, -1, -1)])

# PowerSet of a List
def PowerSet(orignal_list):
	list_size = len(orignal_list)
	num_sets = 2**list_size
	powerset = []
	# Don't include empty set
	for i in range(num_sets)[1:]:
		subset = []
		binary_digits = list(int2bin(i,list_size))
		list_indices = range(list_size)
		for (bit,index) in zip(binary_digits,list_indices):
			if bit == '1':
				subset.append(orignal_list[index])
		powerset.append(subset)
	return powerset

if __name__ == "__main__":
        print int2bin(4)
        print PowerSet([1,2,3,4])

