# Kiwi Language Documentation (English)

## Data Types

### Number
64-bit floating-point numbers.

```lisp
> 42
42
> 2.718
2.718
```

### List

Linked list evaluated as a function call.

```lisp
> (+ 1 2 3)
6
```

Use quote to avoid evaluation:

```lisp
> (quote (+ 1 2 3))
(+ 1 2 3)
```

### `t` and `nil`

- `t` represents truth. Any value other than `nil` is also considered true.
- `nil` is false and also represents an empty list.

```lisp
> (= 1 1)
t
> (= 1 2)
nil
```

### Symbol

Symbols act like variables.

```lisp
> (set! two 2)
2
> two
2
```

### Function

Define functions with `fun`:

```
> (set! double (fun (a) (* a 2)))
> (double 3)
6
```

Supports recursion:

```lisp
> (set! pow (fun (a n) (if (< n 1) 1 (* a (pow a (- n 1))))))
> (pow 2 3)
8
```

Supports variable arguments with `..`:

```lisp
> (set! rest (fun (x ..xs) xs))
> (rest 1 2 3)
(2 3)
```

## Built-in Functions

- Arithmetic: `+`, `-`, `*`, `/`, `mod`
- Comparison: `=`, `<`, `<=`, `>`, `>=`
- Logical: `(not expr)`{:.lisp}
- Conditional: `(if predicate then else)`{:.lisp}
- Lambda Function: `(fun params body)`{:.lisp}
- Apply: `(apply fun args)`{:.lisp}
- Binding: `(set! symbol expr)`{:.lisp}
- Quote: `(quote expr)`{:.lisp}
- List mapping: `(map fun list)`{:.lisp}
- List filtering: `(filter fun list)`{:.lisp}
- Range creation: `(range start end)`{:.lisp}
- Current Time: `(time)`{:.lisp}
- Print: `(println expr)`{:.lisp}
