import Data.Set hiding (filter,null,map)
import Data.List (foldl',group)

doubleUs x y=doubleMe x + doubleMe y
doubleMe x = 2*x

sayMe :: (Integral a) => a -> String   
sayMe 1 = "One!"   
sayMe 2 = "Two!"   
sayMe 3 = "Three!"   
sayMe 4 = "Four!"   
sayMe 5 = "Five!"   
sayMe x = "Not between 1 and 5"  

factorial :: (Integral a) => a -> a
factorial 0 = 1
factorial n = n * factorial (n - 1)

length' :: (Num b) => [a] -> b
length' [] = 0
length' (_:xs) = 1 + length' xs

fibonacci :: (Num a) => a -> a
fibonacci 0 = 1
fibonacci 1 = 1
fibonacci n = fibonacci (n-1) + fibonacci (n-2)

capital :: String -> String   
capital "" = "Empty string, whoops!"   
capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ xs

{-
	where binding
-}
bmiTell :: (RealFloat a) => a -> a -> String
bmiTell weight height 
	| bmi < skinny  = "low"
	| bmi > fat  = "high"
	| otherwise = "you'r are perfect"
	where bmi = weight/height^2
	      (skinny,fat)=(18.5,25.0) 	


--where binding for pattern mathch
initials :: String->String->String
initials firstname lastname = [f] ++ " " ++ [l]
	 where (f:_) = firstname
	       (l:_) = lastname
	 	

cylinder :: (RealFloat a)=> a->a->a
cylinder r h =
	 let sideArea = 2*pi*r*h
	     topArea  = pi*r^2

	 in sideArea + 2*topArea

calcBmis :: (RealFloat a) => [(a,a)] -> [a]
calcBmis xs = [bmi | (w,h) <- xs,let bmi=w/h^2,bmi >= 2.5]


{-
	case expression

-}
describeList :: [a] -> String
describeList xs = "The list is " ++ case xs of []  -> "empyt"
					       [x] -> "a singleton list"
					       xs  -> "a long list"


-- recurision

maximum' :: (Ord a) => [a] -> a
maximum' []  = error "maximum of empty list"
maximum' [x] = x
maximum' (x:xs) = max x (maximum' xs)

countChange ::(Ord a,Num a) => [a] -> a -> a
countChange list amount 
	| amount < 0 = 0
countChange [] _ = 0
countChange  _ 0 = 1
countChange all@(x:xs) amount = (countChange xs amount) + (countChange all (amount-x))

quickSort :: (Ord a) => [a] -> [a]
quickSort [] = []
quickSort (x:xs) = 
		 let smallerSorted = quickSort (filter (<=x) xs)
		     biggerSorted = quickSort (filter (>x) xs)
		 in smallerSorted ++ [x] ++ biggerSorted


rightTriangle :: (Fractional a,Enum a) => a -> [(a,a,a)]
rightTriangle length = filter lenghtLimit (filter rightAngle [(a,b,c) | c<-[1..(length/2)],b<-[1..c],a<-[1..b]]) 
	 where  rightAngle  (a,b,c) =a^2+b^2==c^2
	        lenghtLimit (a,b,c) = a+b+c==length

sum' :: (Num a) => [a] -> a
sum' [] = 0
sum' (x:xs) = x+ sum' xs




-- High order function
zipWith' :: (a->b->c) -> [a]->[b]->[c]
zipWith' _ [] _ = []
zipWith' _ _ [] = []
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys

-- curry
addThree ::(Num a) => a->a->a->a
addThree = \x -> \y -> \z -> x+y+z

flip' :: (a->b->c) -> b->a->c
flip' f = \x y -> f y x

elem' :: (Eq a) => a -> [a] -> Bool
elem' y ys = foldl (\acc x -> if x==y then True else acc) False ys


isPrime x = null $ filter (\y -> x `mod` y == 0) $ takeWhile (\y -> y^2 <= x) [2..]


fib 0 = 0
fib 1 = 1
fib n | even n         = f1 * (f1 + 2 * f2)
      | n `mod` 4 == 1 = (2 * f1 + f2) * (2 * f1 - f2) + 2
      | otherwise      = (2 * f1 + f2) * (2 * f1 - f2) - 2
   where k = n `div` 2
         f1 = fib k
         f2 = fib (k-1)



collatzChain :: (Integral a) => a -> [a]
collatzChain 1 = [1]
collatzChain n 
	     | even n = n : collatzChain (n `div` 2)
	     | odd  n = n : collatzChain (n*3+1)

maxLengthList ::(Num a) => [[a]] -> [a]
maxLengthList [] = error "error"
maxLengthList [x] = x
maxLengthList (x:xs)
		| (length x) > length maxTail = x
		| otherwise  = maxTail
		where maxTail = maxLengthList xs 


problem_14 = j 1000000 where   
f :: Int -> Integer -> Int   
f k 1 = k   
f k n = f (k+1) $ if even n then div n 2 else 3*n + 1   
g x y = if snd x < snd y then y else x   
h x n = g x (n, f 1 n)   
j n = fst $ foldl' h (1,1) [2..n-1]


problem_18 = head $ foldr1 g tri 
  where
    f x y z = x + max y z
    g xs ys = zipWith3 f xs ys $ tail ys
    tri = [
        [75],
        [95,64],
        [17,47,82],
        [18,35,87,10],
        [20,04,82,47,65],
        [19,01,23,75,03,34],
        [88,02,77,73,07,63,67],
        [99,65,04,28,06,16,70,92],
        [41,41,26,56,83,40,80,70,33],
        [41,48,72,33,47,32,37,16,94,29],
        [53,71,44,65,25,43,91,52,97,51,14],
        [70,11,33,28,77,73,17,78,39,68,17,57],
        [91,71,52,38,17,14,91,43,58,50,27,29,48],
        [63,66,04,68,89,53,67,30,73,16,69,87,40,31],
        [04,62,98,27,23,09,70,98,73,93,38,53,60,04,23]]



problem_44 = head solutions
  where solutions = [a-b | a <- penta,
                           b <- takeWhile (<a) penta,
                           isPenta (a-b),
                           isPenta (b+a) ]
    	isPenta = (`member` fromList  penta)
    	penta = [(n * (3*n-1)) `div` 2 | n <- [1..5000]]




factorize n = filter (\s -> if n `mod` s==0 then True else False) [1..n]
triangleNum n = foldl (+) 0 [1..n]

{-
primes = 2 : filter ((==1) . length . primeFactors) [3,5..]
primeFactors n = factor n primes
  where
    factor n (p:ps) 
        | p*p > n        = [n]
        | n `mod` p == 0 = p : factor (n `div` p) (p:ps)
        | otherwise      = factor n ps

--primeFactors in problem_3
problem_12 = head $ filter ((> 500) . nDivisors) triangleNumbers
  where nDivisors n = product $ map ((+1) . length) (group (primeFactors n))    
        triangleNumbers = scanl1 (+) [1..]

-}


problem_21_v2 = sum [n | n <- [2..9999], let m = d n,
                         m > 1, m < 10000, n == d m, d m /= d  (d m)]
d n = product [(p * product g - 1) `div` (p - 1) |
                 g <- group $ primeFactors n, let p = head g
              ] - n
primeFactors = pf primes
  where
    pf ps@(p:ps') n
     | p * p > n = [n]
     | r == 0    = p : pf ps q
     | otherwise = pf ps' n
     where (q, r) = n `divMod` p
primes = 2 : filter (null . tail . primeFactors) [3,5..]
