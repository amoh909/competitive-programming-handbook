# Repunit Identities

A **repunit** is a number consisting only of the digit `1`.

Let `R_n` denote the base-10 repunit with `n` digits:

```text
R_1 = 1
R_2 = 11
R_3 = 111
...
```

## Closed form

```text
R_n = (10^n - 1) / 9
```

This follows from the geometric series:

```text
1 + 10 + 10^2 + ... + 10^{n-1} = (10^n - 1) / 9
```

## Recurrence

```text
R_{n+1} = 10R_n + 1
```

This is the identity used to update repunit remainders efficiently.

## Divisibility by 3 and 9

The digit sum of `R_n` is `n`.

Therefore:

```text
R_n is divisible by 3 iff n is divisible by 3
R_n is divisible by 9 iff n is divisible by 9
```

## Divisibility by 11

Using the alternating-sum rule:

```text
R_n is divisible by 11 iff n is even
```

Examples:

```text
R_2 = 11
R_4 = 1111 = 11 × 101
```

## GCD identity

A major repunit identity is:

```text
gcd(R_m, R_n) = R_gcd(m, n)
```

Consequences:

- `R_m` divides `R_n` exactly when `m` divides `n`.
- If `n` is composite, then `R_n` is composite.
- A prime repunit can only have prime length, although prime length does not guarantee a prime repunit.

## Existence theorem modulo k

There exists some `n >= 1` such that:

```text
R_n ≡ 0 (mod k)
```

if and only if:

```text
gcd(k, 10) = 1
```

### Necessity

Every repunit ends in `1`, so it cannot be divisible by `2` or `5`.

### Sufficiency

Among `R_1, ..., R_k`, either one is divisible by `k`, or two have the same remainder. Their difference is `10^i R_{j-i}`. Since `10` is invertible modulo `k`, `R_{j-i}` must be divisible by `k`.

## Multiplicative-order connection

Because `10^n - 1 = 9R_n`:

```text
k | R_n
```

is equivalent to:

```text
10^n ≡ 1 (mod 9k)
```

Whenever `gcd(k, 10) = 1`, the smallest valid `n` is therefore the multiplicative order of `10` modulo `9k`.
