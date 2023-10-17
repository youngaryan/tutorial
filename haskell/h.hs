main :: IO ()
main = print (mystery [1, 2, 3])

mystery xs = foldr (++) [] (map sing xs)
  where
    sing x = [x]

-- week 4
-- a . map (+ 3) xs
-- b . filter (> 7) xs
-- c . concat (map (\x -> map (\y -> (x, y)) ys) xs)
-- d . filter (> 3) (map (\(x, y) -> x + y) xys)

-- filterTupple :: [(Int, Int)] -> [Int]
-- filterTupple xys = [x + y | (x, y) <- xys, x + y > 3]

-- concat11 :: [a] -> [b] -> [(a, b)]
-- concat11 (x : xs) (y : ys) = [(a, b) | a <- x : xs, b <- y : ys]

-- filterLessThan7  :: [Int] -> [Int]
-- filterLessThan7 [] = []
-- filterLessThan7 (x:xs) = [i| i <- x:xs, i < 7 ]

-- incrementBy3 :: [Int] -> [Int]
-- incrementBy3 [] = []
-- incrementBy3 (x : xs) = [i + 3 | i <- [x]] ++ incrementBy3 xs
-- data BinaryTree a = EmptyTree | Node a (BinaryTree a) (BinaryTree a)

-- balance :: [a] -> BinaryTree a

-- balance [] = EmptyTree
-- balance xs = Node mid (balance left) (balance right)
--   where
--     (left, mid : right) = splitAt (length xs `div` 2) xs

-- data Shape = Circle Float | Rect Float Float deriving (Show)

-- scale :: Float -> Shape -> Shape
-- scale x (Circle r) = Circle (r * x)
-- scale x (Rect l w) = Rect (l * x) (w * x)

-- week 3
-- facSum :: Int -> Int
-- facSum n =
--   sum
--     [i| i<-[1..n-1] , n `mod` i == 0]

-- perfects :: Int -> [Int]

-- perfects n = [i| i<-[1..n], facSum i == i]

-- grid :: Int -> Int -> [(Int, Int)]
-- grid x y = [(i, j) | i <- [0 .. x], j <- [0 .. y]]

-- range1 :: [(String, Int)] -> (Int, Int, Int, Int, Int, Int)
-- range1 grades = foldr countG (0, 0, 0, 0, 0, 0) grades
--   where
--     countG :: (String, Int) -> (Int, Int, Int, Int, Int, Int) -> (Int, Int, Int, Int, Int, Int)
--     countG (_, g) (a, b, c, d, e, f)
--       | g < 30 = (a + 1, b, c, d, e, f)
--       | g < 40 = (a, b + 1, c, d, e, f)
--       | g < 50 = (a, b, c + 1, d, e, f)
--       | g < 60 = (a, b, c, d + 1, e, f)
--       | g < 70 = (a, b, c, d, e + 1, f)
--       | otherwise = (a, b, c, d, e, f + 1)

-- z :: [a] -> [b] -> [(a, b)]
-- z _ [] = []
-- z [] _ = []
-- z (x : xs) (y : ys) = (x, y) : z xs ys
-- last1 :: [a] -> a
-- last1 [x] = x
-- last1 (x : xs) = last1 xs

-- take1 :: Int -> [a] -> [a]
-- take1 _ [] = []
-- take1 0 _ = []
-- take1 s (x : xs) = x : take1 (s - 1) xs

-- s :: [Int] -> Int
-- s [] = 0
-- s (x : xs) = x + s xs
-- eqc :: Eq Int => Int -> Int -> Int

-- eqc x y
--     | p == 0 = y
--     | otherwise = eqc y p
--      where p = x `mod` y

-- indices :: Eq a => a -> [a] -> [Int]

-- indices n xs= [i |(x,i) <- zip xs[0..] , x == n]

-- nth :: Int -> [a] -> a
-- nth 0 (x:xs) = x
-- nth n (x:xs) = nth(n-1)xs
-- nth _ []=error"empty list"

-- fac :: Int -> Int
-- fac x
--     | x < 0 = error"factorial is undefined for x < 0"
--     | otherwise =  product[1..x]
-- sq :: [Int] -> [Int]
-- sq xs = map(\x->x^2)(filter even xs)

-- records = [(True,5), (False,7), (True,12), (True,8), (False,15), (True,4)]

-- choose :: (Ord a, Num a) => [(Bool, a)] -> [(Bool, a)]
-- choose xs = filter(\(x1, x2) -> x1 == True && x2 < 10) xs
-- choose records should return

-- main = putStrLn  $ (\ x-> if x `mod` 2 ==0 || any(\ y->x `mod` y==0)[2..x-2]
--     then "False"
--     else "True") (10)

-- main = putStrLn  $  (\ x -> show (x-1)) (10)
-- main = putStrLn  $ (\ (_:xs) ->  xs) ['a','b','s']

-- main = putStrLn  $ (\ x -> show (x+1) )(10)

-- week 2

-- uhnDouble

-- uhnDouble :: Int -> Int
-- uhnDouble x = if  x*2 > 9 then
--     x*2 - 9
--     else
--     x*2

-- luhn :: Int -> Int -> Int -> Int -> Bool

-- luhn a b c d = (uhnDouble a + uhnDouble c + b + d) `mod` 10 == 0
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
-- roots
-- test = (1,-12,36)
-- roots :: (Float, Float, Float) -> (Float, Float)
-- roots (a, b, c)=
--     if disc >= 0
--         then ((-b + sqrt disc) / (2*a), (-b - sqrt disc) / (2*a))
--         else (-10, -10)
--     where
--         disc = b^2 - 4*a*c

-- capitalizeStart

-- capitalizeStart :: String -> String
-- capitalizeStart [] = []
-- capitalizeStart (x:xs) = toUpper x : xs
-- test = "hello hjm"

-- halves
-- halves :: [Int] -> [Int]
-- halves[] = []
-- halves (x:xs) = x `div` 2 : halves xs

-- test = [2,4,6,8,10]

-- addc
-- addc :: Char -> String -> String
-- addc c s = [c] ++ s

-- --range
-- range :: Int -> Bool
-- range x = if x <= 20 && x>=1 then
--     True
--     else
--     False

-- test :: [Int]

-- stack
-- test = [1,2,3,4,5]
-- stack :: a ->[a] -> [a]
-- stack h [] = [h]
-- stack h (x:xs) = xs ++ [h]

-- stack takes the first element of a list and puts it on the end of a list

-- [1,2,3,4,5]
-- [2,3,4,5,1]

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

-- halve xs = splitAt(l xs `div` 2) xs

-- xs :: [Int]
-- xs = [1, 2, 3, 4, 5]

-- second xs = head (tail xs)
-- swap (x,y) = (y,x)
-- pair x y = (x,y)
-- double x = x*2
-- palin xs = reverse xs == xs
-- twice f x = f (f x)

-- n = a `div` l xs
--     where
--         a = 10
--         xs = [1,2,3,4,5]

-- N = a 'div' l xs
-- where
-- a = 10
-- xs = [1, 2, 3, 4, 5]
