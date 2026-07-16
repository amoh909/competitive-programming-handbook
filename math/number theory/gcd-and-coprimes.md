# GCD and Coprime Integers

## Greatest Common Divisor

For integers `a` and `b`, not both zero:

```text
gcd(a, b)
```

is the greatest positive integer that divides both.

Examples:

```text
gcd(12, 18) = 6
gcd(17, 5) = 1
gcd(25, 0) = 25
```

## Euclidean Algorithm

The key identity is:

```text
gcd(a, b) = gcd(b, a mod b)
```

Repeatedly replace:

```text
(a, b) -> (b, a mod b)
```

until `b = 0`.

Then:

```text
gcd(a, 0) = |a|
```

### Java implementation

```java
public static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);

    while (b != 0) {
        int remainder = a % b;
        a = b;
        b = remainder;
    }

    return a;
}
```

### Complexity

```text
Time: O(log(min(a, b)))
Space: O(1)
```

## Why the Euclidean Algorithm Works

Write:

```text
a = qb + r
```

where:

```text
r = a mod b
```

A number divides both `a` and `b` exactly when it divides both `b` and:

```text
a - qb = r
```

Therefore:

```text
gcd(a, b) = gcd(b, r)
```

## Coprime Integers

Two integers are coprime, or relatively prime, when:

```text
gcd(a, b) = 1
```

Coprime does not mean both numbers are prime.

Examples:

```text
8 and 15 are coprime.
14 and 25 are coprime.
8 and 12 are not coprime.
```

### Java check

```java
public static boolean areCoprime(int a, int b) {
    return gcd(a, b) == 1;
}
```

## Important Equivalent Statements

The following statements are equivalent:

```text
gcd(a, n) = 1
```

```text
There exist integers x and y such that ax + ny = 1. (Throwback to MATH 241: Group Theory)
```

```text
a has a multiplicative inverse modulo n.
```

That means there exists some `x` such that:

```text
ax ≡ 1 (mod n)
```

## Bézout's Identity

For any integers `a` and `b`, there exist integers `x` and `y` satisfying:

```text
ax + by = gcd(a, b)
```

Example:

```text
gcd(30, 18) = 6
```

One valid identity is:

```text
30(-1) + 18(2) = 6
```

## GCD Identities:
```text
gcd(a,a) = |a|
```
