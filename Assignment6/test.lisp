(> 3 2)
(> 2 3)
(> 4 5)
(> 5 34)
(>= 3 3)
(>= 4 17)
(>= 9 9)
(>= (+ 1 4) (+ 2 9))
(< (+ 1 4) (+ 9 2))
(< 2 4)
(< 9 3)
(< 8 8)
(<= 9 9)
(<= (+ 4 5) (+ 6 3))
(<= 298 299)
(<= 3000 30000)
(and (<= 23 28) (<= 92 93))
(and (>= (+ 1 2) (+ 2 2)) ())
(and T T)
(and NIL NIL)
(and () ())
(and 1 2)
(and 3 4)
(and T ())
(or T NIL)
(or () ())
(or (>= 3 1) (>= 1 3))
(or T T)
(not T)
(not NIL)
(not ())
(not (>= 5 6))
(cons 12 24)
(cons 12 (cons 13 30))
(cons 6 (cons 5 NIL))
(quote 1)
(quote (+ 1 2))
(quote (<= 2 3))
(eval (+ 1 2))
(eval (<= 2 3))
(eval (quote (+ 1 2)))
(list 1)
(list)
(list 1 2 3 (+ 2 2))
(list (+ 3 2) (- 7 5))
(cond (nil 1) (T 2) (nil 3))
(cond (nil 1) (nil 2) (T 3))
(cond (nil 1) (nil 2) (nil 3))
(cond (nil 1) (nil 2) (nil 3) (9 (+ 5 (+ 5 5))))
(cond (T 1) (nil 2) (nil 3))
(cond (nil 1) (T 2))
(setq A 29)
(setq B (+ A 13))
B
((lambda () 42))
((lambda (X) X) 42)
((lambda (X Y) (* X Y)) 3 14)
((lambda (X Y Z) (+ X (+ Y Z))) 14 15 13)
((lambda (X Y) (- X Y)) 84 42)