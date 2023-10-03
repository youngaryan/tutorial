main :: IO ()
main = putStrLn (show (safeTail ("the trickier test string")))


safeTail :: [a] -> [a]
safeTail[] = []
safeTail (x:xs) = xs
-- safeTail x = if null x then
--         []
--     else
--         tail x
-- safeTail a = tail a
-- safeTail [] = []


-- firstWord :: String -> String

-- firstWord x = head(words x)

-- eq :: Floating a => (a, a, a, a) -> a

-- eq (x1,y1,x2,y2) = (sqrt((x2 - x1)^2 + (y2 - y1)^2))









-- halve :: [a] -> ([a],[a])


-- halve xs = splitAt(length xs `div` 2) xs

-- xs :: [Int]
-- xs = [1, 2, 3, 4, 5]



-- second xs = head (tail xs)
-- swap (x,y) = (y,x)
-- pair x y = (x,y)
-- double x = x*2
-- palin xs = reverse xs == xs
-- twice f x = f (f x)

-- n = a `div` length xs
--     where 
--         a = 10
--         xs = [1,2,3,4,5]


-- N = a 'div' length xs
-- where
-- a = 10
-- xs = [1, 2, 3, 4, 5