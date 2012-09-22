import Control.Monad

isPrime p = p > 1 && (all (\n -> p `mod` n /= 0 ) $ takeWhile (\n -> n*n <= p) [2..])

primes = 2: filter isPrime [3,5..1000000]

findMaxPrimeSum ps 
	| isPrime sumps = Just sumps
	| otherwise     = findMaxPrimeSum (tail ps) `mplus` findMaxPrimeSum (init ps)
	where sumps = sum ps

problem50 = findMaxPrimeSum $ take 546 primes


