# [338. Counting Bits](https://leetcode.com/problems/counting-bits/)

**Difficulty:** 🟢 Easy

## Problem

Given an integer `n`, return an array `ans` of length `n + 1` where:

```text
ans[i] = number of 1's in the binary representation of i
```

For example:

```text
n = 5
```

Binary representations:

```text
0 → 000 → 0
1 → 001 → 1
2 → 010 → 1
3 → 011 → 2
4 → 100 → 1
5 → 101 → 2
```

Therefore:

```text
[0, 1, 1, 2, 1, 2]
```

---

## Algorithm

This solution uses **Dynamic Programming**.

For every number `i`, we remove its highest power of `2` and use the already calculated result:

```text
dp[i] = 1 + dp[i - offset]
```

where `offset` is the largest power of `2` less than or equal to `i`.

```text
Algorithm → Dynamic Programming
Pattern   → Bit Manipulation
```

---

## Intuition

Consider:

```text
i = 5
```

Binary:

```text
5 = 101
```

The largest power of `2` less than or equal to `5` is:

```text
4 = 100
```

Remove `4`:

```text
5 - 4 = 1
```

Since `4` contributes one `1` bit:

```text
dp[5] = 1 + dp[1]
      = 1 + 1
      = 2
```

---

## Approach

1. Create a DP array:

   ```java
   int[] dp = new int[n + 1];
   ```

2. Initialize:

   ```java
   dp[0] = 0;
   int offset = 1;
   ```

3. For every number from `1` to `n`, update `offset` whenever `i` reaches the next power of `2`:

   ```java
   if(offset * 2 == i) offset = i;
   ```

4. Calculate the number of set bits:

   ```java
   dp[i] = 1 + dp[i - offset];
   ```

5. Return the DP array.

---

## Dry Run

Let's take:

```text
n = 5
```

### i = 1

```text
offset = 1

dp[1] = 1 + dp[0]
      = 1
```

### i = 2

Since `2 * offset == i`:

```text
offset = 2
```

Then:

```text
dp[2] = 1 + dp[0]
      = 1
```

### i = 3

```text
dp[3] = 1 + dp[1]
      = 2
```

### i = 4

```text
offset = 4

dp[4] = 1 + dp[0]
      = 1
```

### i = 5

```text
dp[5] = 1 + dp[1]
      = 2
```

Final result:

```text
[0, 1, 1, 2, 1, 2]
```

---

## Why This Works

Every number can be represented as:

```text
i = highestPowerOf2 + remainder
```

The highest power of `2` contributes exactly **one set bit**.

Therefore:

```text
dp[i] = 1 + dp[i - offset]
```

Since `dp[i - offset]` has already been calculated, we can solve the problem efficiently using previously computed results.

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* Each number from `0` to `n` is processed once.

**Space Complexity:** `O(n)`

* The `dp` array stores the result for every number.

---

## Key Takeaway

Use the largest power of `2` less than or equal to `i`:

```text
i
↓
Remove highest power of 2
↓
Solve the remainder using DP
↓
Add 1
```

```text
dp[i] = 1 + dp[i - offset]
```

```text
Algorithm → Dynamic Programming
Pattern   → Bit Manipulation
Time      → O(n)
Space     → O(n)
```
