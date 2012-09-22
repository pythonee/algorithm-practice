import Data.List
import Data.Char
problem_22 =
    do input <- readFile "names.txt"
       let names = sort $ read$"["++ input++"]"
       let scores = zipWith score names [1..]
       print . sum $ scores
  where score w i = (i *) . sum . map (\c -> ord c - ord 'A' + 1) $ w
