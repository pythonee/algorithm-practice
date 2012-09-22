import time

def rt(func, *argv): # running time
    start = time.clock()
    func(*argv)
    end = time.clock()
    print '%s method takes %f seconds' %(func.__name__, end-start)
