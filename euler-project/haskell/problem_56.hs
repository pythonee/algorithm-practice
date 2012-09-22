digitalSum 0 = 0
digitalSum n = 
    let (d,m) = quotRem n 10 in m + digitalSum d

problem_56 = 
    maximum [digitalSum (a^b) | a <- [1..100], b <- [1..100]] 
