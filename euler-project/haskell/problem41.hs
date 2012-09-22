import Data.List
isprime a = isprimehelper a primes
isprimehelper a (p:ps)
    | a == 1         = False
    | p*p > a        = True
    | a `mod` p == 0 = False
    | otherwise      = isprimehelper a ps
primes = 2 : filter isprime [3,5..]
problem_41 = 
    head . filter isprime . filter fun $ [7654321,7654320..]
    where
    fun = (=="1234567") . sort . show
