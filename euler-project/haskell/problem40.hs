import Data.Char
problem_40 = (d 1)*(d 10)*(d 100)*(d 1000)*(d 10000)*(d 100000)*(d 1000000)
    where n = concat [show n | n <- [1..]]
          d j = digitToInt (n !! (j-1))
