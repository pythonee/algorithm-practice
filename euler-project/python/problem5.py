def gcd(a,b):return b and gcd(b,a%b) or a
def lcm(a,b) return a*b/gcd(a,b)

for i in xrange(1,21):
    n=lcm(n,i)
    print n

