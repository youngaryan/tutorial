module Bags
  ( Bag,
    listToBag,
    bagEqual,
    bagInsert,
    bagSum,
    bagIntersection,
  )
where

newtype Bag a = Bag [(a, Int)] deriving (Show)

listToBag :: Ord a => [a] -> Bag a
listToBag xs = Bag (foldr insertOrIncrement [] xs)
  where
    insertOrIncrement x [] = (x, 1)
    insertOrIncrement x ((y, count) : ys)
      | x == y = (y, count + 1) : ys
      | otherwise = (y, count) : insertOrIncrement x ys

bagEqual :: Eq a => Bag a -> Bag a -> Bool
bagEqual (Bag xs) (Bag ys) = ys == xs

bagInsert :: Eq a => a -> Bag a -> Bag a
bagInsert a (Bag xs) = Bag (insertOrIncrement x xs)
  where
    insertOrIncrement x [] = (x, 1)
    insertOrIncrement x ((y, count) : ys)
      | x == y = (y, count + 1) : ys
      | otherwise = (y, count) : insertOrIncrement x ys

bagSum :: Eq a => Bag a -> Bag a -> Bag a
bagSum (Bag xs) (Bag ys) = Bag (foldr combine ys xs)
  where
    combine (x, count) bag = bagInsert x (Bag (replicate count bag))

bagIntersection :: Eq a => Bag a -> Bag a -> Bag a
bagIntersection (Bag xs) (Bag ys) = Bag (foldr intersect [] xs)
  where
    intersect (x, count) bag
      | count > 0 = bagInsert x (Bag (replicate count bag))
      | otherwise = bag
