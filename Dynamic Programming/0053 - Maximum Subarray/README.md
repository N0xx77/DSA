# [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

**Difficulty:** 🟡 Medium

## Problem

Given an integer array `nums`, find the **contiguous subarray** with the largest sum and return its sum.

For example:

```text
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

The maximum subarray is:

```text
[4, -1, 2, 1]
```

Its sum is:

```text
4 + (-1) + 2 + 1 = 6
```

Therefore:

```text
6
```

---

## Algorithm

This solution uses **Dynamic Programming**.

For every index `i`, `dp[i]` stores the **maximum subarray sum ending at index `i`**.

At each element, we have two choices:

```text
Start a new subarray
OR
Continue the previous subarray
```

```java
dp[i] = Math.max(prevSum + nums[i], nums[i]);
```

```text
Algorithm → Dynamic Programming
Pattern   → Kadane's Algorithm
```

---

## Intuition

Consider:

```text
nums = [-2, 1, -3, 4, -1, 2, 1]
```

At every element, decide whether it is better to:

```text
Continue previous sum + current value
OR
Start from current value
```

For example, at `4`:

```text
Previous sum = -2
4 + (-2) = 2
```

Starting a new subarray is better:

```text
4
```

Then:

```text
4 + (-1) = 3
3 + 2 = 5
5 + 1 = 6
```

So the maximum sum is:

```text
6
```

---

## Approach

1. Create a DP array:

   ```java
   int[] dp = new int[nums.length];
   ```

2. Keep track of the previous maximum sum:

   ```java
   int prevSum = 0;
   ```

3. For every element, choose between starting a new subarray or continuing the previous one:

   ```java
   dp[i] = Math.max(prevSum + nums[i], nums[i]);
   ```

4. Update `prevSum`:

   ```java
   prevSum = dp[i];
   ```

5. Traverse `dp` to find the maximum value.

6. Return the maximum subarray sum.

---

## Dry Run

Let's take:

```text
nums = [-2, 1, -3, 4, -1, 2, 1]
```

The DP values are:

```text
nums: [-2,  1, -3,  4, -1,  2,  1]
dp:   [-2,  1,  -2,  4,  3,  5,  6]
```

For example:

```text
dp[3] = max(dp[2] + 4, 4)
      = max(-2 + 4, 4)
      = 4
```

And:

```text
dp[6] = max(dp[5] + 1, 1)
      = max(5 + 1, 1)
      = 6
```

Therefore:

```text
Maximum = 6
```

---

## Why This Works

At every index, the maximum subarray ending there must either:

```text
Continue the previous subarray
        ↓
prevSum + nums[i]
```

or:

```text
Start a new subarray
        ↓
nums[i]
```

Taking the larger value gives the best subarray ending at that index.

Finally, the largest value in `dp` is the maximum subarray sum.

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* Each element is processed once.
* Finding the maximum in `dp` takes another `O(n)`.

**Space Complexity:** `O(n)`

* The `dp` array stores the maximum subarray sum ending at each index.

---

## Key Takeaway

At every element, decide:

```text
Continue previous subarray
          OR
Start a new subarray
```

```text
dp[i] = max(prevSum + nums[i], nums[i])
```

The largest value in `dp` is the answer.

```text
Algorithm → Dynamic Programming
Pattern   → Kadane's Algorithm
Time      → O(n)
Space     → O(n)
```
