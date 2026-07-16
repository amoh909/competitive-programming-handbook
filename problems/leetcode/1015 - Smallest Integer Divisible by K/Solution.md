Intuition
Our goal is to analyze numbers in the sequence N∈{1,11,111,1111,…} to find the first one where N(modK)=0. Doing this naively by constructing N directly is impossible because N grows exponentially and will quickly overflow any 64-bit signed integer. Therefore, we must rely on two core mathematical observations:

Instead of tracking the massive number N, we only need to keep track of its remainder modulo K. Suppose a number currently has value x in base b. Appending digit d produces:
x' = bx + d
Therefore, to keep track of the remainder under modulo arithemtic:

x' mod k = ((x mod k) \* b + d) mod k
Alright, so translating this general framework into our problem, b = 10 and x = 11....111 (i times), so the crucial formula becomes:

x' mod k = ((x mod k) \* 10 + 1) mod k
or

new_remainder = (old_remainder \* 10 + 1) mod k
How do we know if a solution is impossible? Notice, when dividing any number by K, there are only K possible remainders: {0,1,2,…,K−1}. Using this fact, if we iterate K times and never hit a remainder of 0, we must have seen a repeated remainder by pigeonhole principle. Thus, if we do not find a remainder of 0 within K steps, no such N exists.
Approach
Step 1: Any number composed entirely of 1's must be odd. Because of this, it can never be divisible by 2 or 5. We can immediately return -1 if k is a multiple of 2 or 5.
Step 2: We initialize our tracking variable remainder = 0. As we iterate the length of our repunit from 1 to K, we repeatedly apply the modular formula.
Step 3: If remainder ever hits 0, we return the current loop index length because that represents the number of 1's in the sequence.

Complexity
Time complexity: O(k)
Space complexity: O(1)
