import Numeric
import Data.Char
 
showBin = flip (showIntAtBase 2 intToDigit) ""
 
isPalindrome x = x == reverse x
 
problem_36 = sum [x | x <- [1,3..1000000], isPalindrome (show x), isPalindrome (showBin x)]
