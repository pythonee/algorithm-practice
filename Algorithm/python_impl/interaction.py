def interaction(a,b):
    hash_table = {}
    for ele in a:
        hash_table[str(ele)] = 1

    for ele in b:
        if hash_table.has_key(str(ele)):
            hash_table[str(ele)] += 1
        else:
            hash_table[str(ele)] =1

    c = []
    d = []
    for k in hash_table:
        if hash_table[k] == 2:
            c.append(k)
        else:
            d.append(k)

    print "interactive collection"
    print c

    print "non interative collection"
    print d

a = [1,2,3,'d']
b = [1,2,4,5,6]

interaction(a,b)
