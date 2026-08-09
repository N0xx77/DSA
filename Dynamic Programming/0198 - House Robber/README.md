# [198. House Robber](https://leetcode.com/problems/house-robber/)

**Difficulty:** 🟠 Medium

## Problem

You are a professional robber planning to rob houses along a street.

Each house has a certain amount of money. However, you **cannot rob two adjacent houses** because the security system will automatically alert the police.

Given an integer array `nums` where `nums[i]` represents the amount of money in the `i`-th house, return the **maximum amount of money you can rob without robbing two adjacent houses**.

---

## Intuition

For every house, we have **two choices**:

1. **Rob the current house**

   * If we rob the current house, we cannot rob the previous house.
   * Therefore, the amount becomes:

   ```text
   dp[i - 1] + nums[i]
   ```

2. **Skip the current house**

   * We simply keep the maximum amount we had before:

   ```text
   dp[i]
   ```

We choose the better of these two options:

```text
dp[i + 1] = max(dp[i - 1] + nums[i], dp[i])
```

Here, `dp[i]` represents the **maximum amount of money that can be robbed from the first `i` houses**.

This is a classic **Dynamic Programming** problem because the solution for the current house depends on solutions to previously processed houses.

The idea of considering whether to take or skip the current house is also discussed in the LeetCode solution:

[From Good to Great — How to Approach Most DP Problems](https://leetcode.com/problems/house-robber/solutions/156523/from-good-to-great-how-to-approach-most-ie2yi/)

---

## Approach

1. Create a `1D` DP array of size `nums.length + 1`.

   ```java
   int[] dp = new int[nums.length + 1];
   ```

   We use `n + 1` positions so that `dp[i]` can represent the answer for the first `i` houses.

2. Initialize the base cases:

   ```java
   dp[0] = 0;
   dp[1] = nums[0];
   ```

   * `dp[0] = 0` because there are no houses to rob.
   * `dp[1] = nums[0]` because with only one house, the best choice is to rob it.

3. Traverse the remaining houses starting from index `1`.

   ```java
   for (int i = 1; i < nums.length; i++)
   ```

4. For every house, calculate the two possible choices:

   **Rob the current house:**

   ```java
   dp[i - 1] + nums[i]
   ```

   We use `dp[i - 1]` because the previous house cannot be robbed.

   **Skip the current house:**

   ```java
   dp[i]
   ```

   We keep the best result obtained from the previous houses.

5. Take the maximum of the two choices:

   ```java
   dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
   ```

6. After processing all houses, `dp[nums.length]` contains the maximum amount of money that can be robbed.

---

## DP State Transition

The main recurrence used in this solution is:

```text
dp[i + 1] = max(dp[i - 1] + nums[i], dp[i])
```

Where:

* `dp[i + 1]` → maximum money from the first `i + 1` houses.
* `dp[i - 1]` → maximum money from houses before the previous house.
* `nums[i]` → money in the current house.
* `dp[i]` → maximum money if we skip the current house.

In simpler terms:

```text
Maximum = max(Rob Current House, Skip Current House)
```

This **take-or-skip** pattern appears frequently in Dynamic Programming problems.

---

## Why Do We Use `dp[i - 1]`?

Suppose we are currently at house `i`.

If we decide to rob it:

```text
dp[i - 1] + nums[i]
```

We cannot use `dp[i]` because `dp[i]` represents the maximum amount considering the previous `i` houses, which could include house `i - 1`.

Using `dp[i - 1]` ensures that the previous house is excluded.

For example:

```text
House:    0   1   2
Money:    2   7   9
```

When robbing house `2`:

```text
dp[1] + nums[2]
```

means:

```text
Best before house 1 + money from house 2
```

So house `1` is automatically skipped.

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* We iterate through every house exactly once.

**Space Complexity:** `O(n)`

* We use a `1D` DP array of size `n + 1`.

---

## Space Optimization

The current solution uses an entire DP array, but notice that each state only depends on the **previous two states**:

```text
dp[i - 1]
dp[i]
```

Therefore, we do not actually need to store the entire array.

We can maintain two variables instead:

```text
prev2 = dp[i - 1]
prev1 = dp[i]
```

The transition becomes:

```text
current = Math.max(prev2 + nums[i], prev1);
```

This reduces the space complexity from:

```text
O(n)
```

to:

```text
O(1)
```

The important observation is that the DP recurrence only requires the previous two results, rather than the entire DP table.

---

## Key Takeaway

The main idea behind this problem is:

> At every house, decide whether **robbing it** gives a better result than **skipping it**.

The recurrence is:

```text
dp[i + 1] = max(dp[i - 1] + nums[i], dp[i])
```

This simple **take vs. skip** decision is one of the most common patterns in Dynamic Programming.
