import benchmark

def hammingweight1(n):
    count = 0
    while n:
        n &= n -1
        count += 1
    return count

def hammingweight2(n):
    n = (n & 0x55555555) + ((n>>1) & 0x55555555)
    n = (n & 0x33333333) + ((n>>2) & 0x33333333)
    n = (n & 0x0f0f0f0f) + ((n>>4) & 0x0f0f0f0f)
    n = (n & 0x00ff00ff) + ((n>>8) & 0x00ff00ff)
    n = (n & 0x0000ffff) + ((n>>16) & 0x0000ffff)
    return n


if __name__ == '__main__':

    assert hammingweight1(111111143) == hammingweight2(111111143)
    benchmark.rt(hammingweight1, 111111143)
    benchmark.rt(hammingweight2, 111111143)
