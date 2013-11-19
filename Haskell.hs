-- Definiciones funcionales
potencia :: Int -> Int -> Int
potencia base 0 = 1
potencia base 1 = base
potencia base exponente = base * potencia base (exponente-1)

valAbsoluto :: Int -> Int
valAbsoluto 0 = 0
valAbsoluto x = if x>0 then x else x * (-1)

sumatoria :: Int -> Int
sumatoria 0 = 0
sumatoria 1 = 1
sumatoria n = n + sumatoria (n-1)

divisor :: Int -> Int -> Bool
divisor 0 x = True
divisor 1 x = False
divisor a b = if (a - b) < 0 then False else
  if (a - b) == 0 then True else divisor (a - b) b

divisor' :: Int -> Int -> Bool
divisor' a b
  | a == 0 = True
  | a == 1 = False
  | (a - b) < 0 = False
  | (a - b) == 0 = True
  | otherwise = divisor (a - b) b

mcd :: Int -> Int -> Int
mcd a b
  | b == 0 = a
  | otherwise = mcd b (a `mod` b)

-- (\x y->if x>y then x else y) 100 100
-- (\x->if (valAbsoluto x) `mod` 2 == 0 then True else False) (-3)


-- Tratamiento de listas
suma :: (Floating a) => [a] -> a
suma [] = 0.0
suma lista = head lista + suma (tail lista)

cantidad :: [a] -> Int
cantidad [] = 0
cantidad lista = 1 + cantidad (tail lista)

ultimo :: [a] -> a
ultimo lista = if cantidad lista == 1 then head lista else ultimo (tail lista)

ultimo' :: [a] -> a
ultimo' lista
  | cantidad lista == 1 = head lista
  | cantidad lista > 1 = ultimo' (tail lista)

inversa :: [a] -> [a]
inversa lista
  | cantidad lista == 0 = []
  | cantidad lista > 0 = inversa (tail lista)++[head lista]

sacar :: Int -> [a] -> [a]
sacar i lista
  | i == 0 = tail lista
  | i > (cantidad lista) = lista
  | i > 0 = [head lista]++sacar (i-1) (tail lista)
  | otherwise = lista

sacar' :: Int -> [a] -> [a]
sacar' i lista = if i == 0 then tail lista else
  if i > (cantidad lista) then lista else
    if i > 0 then [head lista]++sacar (i-1) (tail lista) else lista

eliminar :: Eq a => a -> [a] -> [a]
eliminar x [] = []
eliminar x (l:lx) = if x == l then eliminar x lx else l:eliminar x lx

-- Auxiliar
existe :: Eq a => a -> [a] -> Bool
existe e [] = False
existe e (l:lx) = if e == l then True else existe e lx

intersec :: Eq a => [a] -> [a] -> [a]
intersec l [] = []
intersec [] l = []
intersec (l:lx) x = if (existe l x) then l:intersec lx x else intersec lx x

rotarIzq :: Int -> [a] -> [a]
rotarIzq 0 l = l
rotarIzq n (l:lx) = rotarIzq (n-1) (lx++[l])

insertarEn :: Int -> a -> [a] -> [a]
insertarEn 0 e l = e:l
insertarEn n e (l:lx) = if (n > cantidad (l:lx)) then (l:lx)++[e] else l:(insertarEn (n-1) e lx)

insertOrd :: Ord a => a -> [a] -> [a]
insertOrd e [] = [e]
insertOrd e (l:lx) = if e>l then l:(insertOrd e lx) else e:l:lx

ordenada :: Ord a => [a] -> [a]
ordenada [] = []
ordenada (l:lx) = insertOrd l (ordenada lx)

-- Prueba map potencia
-- map (potencia 2) [1,2,3,4]
-- [2,4,8,16]
--
-- map (mcd 3) [1,2,3,9]
-- [1,1,3,3]


-- Estructuras de datos
parejas :: [a] -> [a] -> [(a,a)]
parejas l1 [] = []
parejas [] l1 = []
parejas (l:lx) (r:rx) = if (cantidad lx) == (cantidad rx) then [(l,r)] ++ parejas lx rx else []

-- aplica :: Eq a => b -> a -> a -> [a] -> [a]
aplica f a b [] = []
aplica f a b (l:lx) = (f a l):aplica f a b lx


type Entradas=(Bool, Bool)
_and :: Entradas -> Bool
_and(a,b) = a && b

_or :: Entradas -> Bool
_or(a,b) = a || b

_not :: Bool -> Bool
_not a = not a

circuito :: Entradas -> Bool
circuito(a,b) = _or(_and((_not a),b),_and((_not b),a))

data Arbol a = Rama (Arbol a) (Arbol a) | Hoja a

elArbol = Rama (Rama (Hoja 45) (Hoja 78))
    (Rama (Hoja 12) (Rama (Hoja 23) (Hoja 13)))

elOtroArbol = Rama (Rama (Hoja 45) (Hoja 78))
    (Rama (Hoja 12) (Rama (Rama (Hoja 30) (Hoja 23)) (Hoja 13)))

cantidad2 :: Arbol a -> Integer
cantidad2 (Hoja x) = 1
cantidad2 (Rama x y) = cantidad2 x + cantidad2 y

mostrarHojas :: Arbol a -> [a]
mostrarHojas (Hoja x) = [x]
mostrarHojas (Rama x y) = mostrarHojas x ++ mostrarHojas y

prof :: Arbol a -> Integer
prof (Hoja x) = 0
prof (Rama x y) = 1 + max (prof x) (prof y)

