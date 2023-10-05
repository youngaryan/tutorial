--import Data.Char (toUpper)
main :: IO ()
main = putStrLn (show ( luhn 4 7 8 3))



--uhnDouble 

uhnDouble :: Int -> Int
uhnDouble x = if  x*2 > 9 then
    x*2 - 9
    else
    x*2

luhn :: Int -> Int -> Int -> Int -> Bool

luhn a b c d = (uhnDouble a + uhnDouble c + b + d) `mod` 10 == 0
-- pyths 

-- pyths :: Int -> [(Int, Int, Int)]

-- pyths x = [(i,j,k)| i <- [1,2..x], j <- [1,2..x], k <- [1,2..x], i^2 + j^2 == k^2 ]





-- predict 


-- test = [10..1]
-- test = [1.2,0.9..0]
-- test = [0.1..1]
-- test = [-1..1]



-- --oddItems 
-- isOdd:: Int -> Bool
-- isOdd x = x `mod` 2 == 1

-- oddItems :: [Int] -> [Int]
-- oddItems x = filter isOdd x

-- test = [2,4,6,8,10, 11]
--roots 
-- test = (1,-12,36)
-- roots :: (Float, Float, Float) -> (Float, Float)
-- roots (a, b, c)= 
--     if disc >= 0
--         then ((-b + sqrt disc) / (2*a), (-b - sqrt disc) / (2*a))
--         else (-10, -10)
--     where 
--         disc = b^2 - 4*a*c


--capitalizeStart 

-- capitalizeStart :: String -> String
-- capitalizeStart [] = [] 
-- capitalizeStart (x:xs) = toUpper x : xs
-- test = "hello hjm"

--halves 
-- halves :: [Int] -> [Int]
-- halves[] = []
-- halves (x:xs) = x `div` 2 : halves xs

-- test = [2,4,6,8,10]

--addc 
-- addc :: Char -> String -> String
-- addc c s = [c] ++ s


-- --range 
-- range :: Int -> Bool
-- range x = if x <= 20 && x>=1 then
--     True
--     else
--     False




--test :: [Int]


--stack
-- test = [1,2,3,4,5]
-- stack :: a ->[a] -> [a]
-- stack h [] = [h]
-- stack h (x:xs) = xs ++ [h]

 --stack takes the first element of a list and puts it on the end of a list

--[1,2,3,4,5]
--[2,3,4,5,1]

-- safeTail :: [a] -> [a]
-- safeTail[] = []
-- safeTail (x:xs) = xs
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
-- xs = [1, 2, 3, 4, 5]
