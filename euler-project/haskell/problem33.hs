import Data.Ratio
problem_33 = denominator $ product 
             [ a%c | a<-[1..9], b<-[1..9], c<-[1..9],
                     isCurious a b c, a /= b && a/= c]
   where isCurious a b c = ((10*a+b)%(10*b+c)) == (a%c)
