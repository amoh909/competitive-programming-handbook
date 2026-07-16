## Use this pattern when

A number is formed one digit at a time, but the complete value may be far too large to store.

Typical questions ask whether the number is divisible by `k`, what its remainder is, or which sequence of digits first reaches remainder `0`.

## Fundamental update

Suppose a number currently has value `x` in base `b`. Appending digit `d` produces:

```text
x' = bx + d
```

Therefore:

```text
x' mod k = ((x mod k) * b + d) mod k
```

Only the old remainder is needed.

## Decimal form

```java
remainder = (remainder * 10 + digit) % k;
```

## Processing a huge number stored as a string

```java
static int remainderOf(String number, int k) {
    int remainder = 0;

    for (int i = 0; i < number.length(); i++) {
        int digit = number.charAt(i) - '0';
        remainder = (remainder * 10 + digit) % k;
    }

    return remainder;
}
```

## Repeated digit example

For numbers:

```text
1, 11, 111, 1111, ...
```

use:

```java
remainder = (remainder * 10 + 1) % k;
```
