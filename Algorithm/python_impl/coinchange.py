# -*- coding: utf-8 -*-

def countCoinChange_1(cointypes, money):

    if(money == 0):
        return 1

    if(money < 0 or len(cointypes) <= 0):
        return 0

    return countCoinChange_1(cointypes[1:], money) + \
            countCoinChange_1(cointypes, money-cointypes[0])

# 想用母函数解决
def countCoinChange_2(cointypes, money):
    pass


def countMinCoinChange(cointypes, money):
    
    lastcoin = [0 for i in range(0, money+1)]
    usedcoin = [0 for i in range(0, money+1)]
    
    for x in range(1, money+1):
        mincoins = x
        for coin in cointypes:
            if coin <= x:
                if(usedcoin[x - coin] + 1 <= mincoins):
                    mincoins = usedcoin[x - coin] + 1
                    lastcoin[x] = coin
                    usedcoin[x] = mincoins
                    
    if checksolution(lastcoin, money):
        print 'money %d need at least %d coins [%s]' % (money,
                                                        usedcoin[money],
                                                        trackprint(lastcoin, money, [])
                                                        )
    else:
        print 'money %d have no solution' % money

def checksolution(lastcoin, money):
    while money>0:
        if lastcoin[money] == 0:
            return False
        money = money - lastcoin[money]
    return True    
    
def trackprint(lastcoin, money, coins=[]):
    if money == 0:
        return ','.join(str(i) for i in coins)

    else:
        coins.append(lastcoin[money])
        return trackprint(lastcoin, money-lastcoin[money], coins)
        
if __name__ == '__main__':
    cointypes = [ 50, 10, 1, 5, 25 ]
    print countCoinChange_1(cointypes, 100)
    
    cointypes = [25, 20, 10, 5, 2]
    countMinCoinChange(cointypes, 0)
    countMinCoinChange(cointypes, 16)
    countMinCoinChange(cointypes, 15)
    countMinCoinChange(cointypes, 11)
    countMinCoinChange(cointypes, 49)
    countMinCoinChange(cointypes, 62)
    countMinCoinChange(cointypes, 63)
    countMinCoinChange(cointypes, 100)
