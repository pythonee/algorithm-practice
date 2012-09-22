from math import log, floor, sqrt
import benchmark

def fib1(n): # recursive version, slow
    if n < 2:
        return n
    else:
        return fib1(n-1) + fib1(n-2)

def fib2 (n): # super fast
    if n == 0: return 0
    elif n == 1: return 1
    elif n == 2: return 1
    else:
        F = 1
        L = 1
        sign = -1
        mask = 2 ** (int(floor (log (n,2)))-1)
        for i in xrange (1, int(floor (log(n,2)))):
            temp = F ** 2
            F = (F + L) / 2
            F = 2 * F ** 2 - 3 * temp - 2 * sign
            L = 5 * temp + 2 * sign
            sign = 1
            if n & mask:
                temp = F
                F = (F + L) / 2
                L = F + 2 * temp
                sign = -1
            mask = mask / 2
        if n & mask == 0:
            F = F * L
        else:
            F = (F + L) / 2
            F = F * L - sign
        return F

def fib3(n): # Dijkstra version, good
    fibs = {0: 0, 1: 1}
    if n in fibs: return fibs[n]
    if n % 2 == 0:
        fibs[n] = ((2 * fib3((n / 2) - 1)) + fib3(n / 2)) * fib3(n / 2)
        return fibs[n]
    else:
        fibs[n] = (fib3((n - 1) / 2) ** 2) + (fib3((n+1) / 2) ** 2)
        return fibs[n]

def fib4(n): # write state, faster, same to tail recursion
      a, b = 0, 1
      for _ in xrange(n):
          a, b = b, a + b
      return a

def fib5(n): # tail recursive version
    def fib_tail(end, a, b, start):
        if end == start:
            return a + b
        else:
            return fib_tail(end, b, a+b, start+1)
    if( n == 1 or n == 2 ):
        return 1
    else:
        return fib_tail(end, 1, 1, 3)
    
if __name__ == '__main__':
    benchmark.rt(fib1, 20)
    benchmark.rt(fib2, 100)
    benchmark.rt(fib3, 100)
    benchmark.rt(fib4, 1000)
    benchmark.rt(fib4, 1000)
