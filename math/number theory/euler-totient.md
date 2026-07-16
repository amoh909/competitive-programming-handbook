# Euler's Totient Function

## Definition

Euler's totient function is written:

```text
φ(n)
```

It counts the integers from `1` through `n` that are coprime to `n`.

Formally:

```text
φ(n) = number of integers x such that
1 <= x <= n
and
gcd(x, n) = 1
```

By convention:

```text
φ(1) = 1
```

Examples:

```text
φ(1) = 1
φ(2) = 1
φ(5) = 4
φ(8) = 4
φ(12) = 4
```

For `n = 12`, the coprime values are:

```text
1, 5, 7, 11
```

Therefore:

```text
φ(12) = 4
```

## Prime Input

If `p` is prime, every integer from `1` to `p - 1` is coprime to `p`.

Therefore:

```text
φ(p) = p - 1
```

Example:

```text
φ(7) = 6
```

## Prime Powers

For:

```text
n = p^k
```

where `p` is prime, the only values not coprime to `n` are multiples of `p`.

Therefore:

```text
φ(p^k) = p^k - p^(k - 1)
```

Equivalently:

```text
φ(p^k) = p^k(1 - 1/p)
```

Example:

```text
φ(16)
= φ(2^4)
= 2^4 - 2^3
= 16 - 8
= 8
```

## General Product Formula

If the distinct prime divisors of `n` are:

```text
p1, p2, ..., pr
```

then:

```text
φ(n) = n(1 - 1/p1)(1 - 1/p2)...(1 - 1/pr)
```

Equivalently:

```text
φ(n) = n * product over distinct p dividing n of (1 - 1/p)
```

Each distinct prime factor appears exactly once.

Example:

```text
36 = 2^2 * 3^2
```

Therefore:

```text
φ(36)
= 36(1 - 1/2)(1 - 1/3)
= 36 * 1/2 * 2/3
= 12
```

## Prime Factorization Form

If:

```text
n = p1^a1 * p2^a2 * ... * pr^ar
```

then:

```text
φ(n)
= p1^(a1 - 1)(p1 - 1)
  * p2^(a2 - 1)(p2 - 1)
  * ...
  * pr^(ar - 1)(pr - 1)
```

## Computing φ(n) in O(sqrt(n))

Avoid floating-point arithmetic.

Whenever a distinct prime divisor `p` is found, update:

```text
result -= result / p
```

### Java implementation

```java
public static int phi(int n) {
    int result = n;
    int remaining = n;

    for (int p = 2; p <= remaining / p; p++) {
        if (remaining % p != 0) {
            continue;
        }

        while (remaining % p == 0) {
            remaining /= p;
        }

        result -= result / p;
    }

    if (remaining > 1) {
        result -= result / remaining;
    }

    return result;
}
```

### Complexity

```text
Time: O(sqrt(n))
Space: O(1)
```

