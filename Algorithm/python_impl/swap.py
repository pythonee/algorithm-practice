# of course a,b = b,a is the perfect solution
# this is show how to do swap without third variable

def swap1(a, b):
    print a,b
    a = a + b
    b = a - b
    a = a - b
    print a,b

def swap2(a,b):
    print a,b
    a ^= b
    b ^= a
    a ^= b
    print a,b

if __name__ == '__main__':
    swap1(1,2)
    swap2(1,2)
