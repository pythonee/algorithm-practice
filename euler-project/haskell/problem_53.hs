facs = scanl (*) 1 [1..100]
comb (r,n) = facs!!n `div` (facs!!r * facs!!(n-r))
perms = [(n,x) | x<-[1..100], n<-[1..x]]
problem_53 = length $ filter (>1000000) $ map comb $ perms
