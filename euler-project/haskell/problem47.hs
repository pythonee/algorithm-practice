import Data.List

problem47 =head [x | x <- [1000..], and $ map (\x -> (length $ nub $ primeFactors x) == 4 ) [x..x+3]]

 
primeFactors n = factor n primes
  where factor n (p:ps) | p*p > n = [n]
                        | n `mod` p /= 0 = factor n ps
                        | otherwise = p : factor (n `div` p) (p:ps)
        primes = 2 : filter ((==1) . length . primeFactors) [3,5..]
