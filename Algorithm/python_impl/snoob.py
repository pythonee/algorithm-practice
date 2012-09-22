def snoob(x):
    smallest = x & -x

    ripple = x + smallest
    ones = x ^ ripple

    ones =(ones >> 2)/smallest
    return ripple | ones

if __name__ == '__main__':
    assert snoob(3) == 5
    assert snoob(5) == 6
    assert snoob(24) == 33
    assert snoob(44) == 49
