# [213. House Robber II](https://leetcode.com/problems/house-robber-ii/)

**Difficulty:** 🟠 Medium

## Problem

You are a professional robber planning to rob houses along a street.

Each house has a certain amount of money. However, the houses are arranged in a **circle**, meaning the first house and the last house are adjacent.

You cannot rob two adjacent houses.

Given an integer array `nums`, where `nums[i]` represents the amount of money in the `i`th house, return the maximum amount of money you can rob without alerting the police.

---

## Intuition

In the original **House Robber** problem, houses are arranged in a straight line.

Here, the houses form a **circle**, so the first and last houses cannot both be robbed.

Therefore, there are only two possible cases:

1. **Exclude the last house** and consider houses from index `0` to `n - 2`.
2. **Exclude the first house** and consider houses from index `1` to `n - 1`.

We calculate the maximum amount for both cases and return the larger value.

For each linear range, we use two variables:

* `prev1` → maximum amount that can be robbed up to the previous house.
* `prev2` → maximum amount that can be robbed up to the house before the previous house.

For every house, we have two choices:

* **Rob the current house:** `prev2 + nums[i]`
* **Skip the current house:** `prev1`

Therefore:

```java
Math.max(prev2 + nums[i], prev1)
```

Since we only need the previous two results, we can solve the problem using **constant extra space**.

---

## Approach

1. If there is only one house, return its value directly.

   ```java
   if(nums.length == 1) return nums[0];
   ```

2. Consider the first case where we **exclude the last house**.

   Traverse from index `0` to `nums.length - 2`.

   ```java
   for(int i = 0; i < nums.length - 1; i++)
   ```

3. For each house, calculate the maximum amount:

   ```java
   int temp = Math.max(prev2 + nums[i], prev1);
   ```

   Then update the previous values:

   ```java
   prev2 = prev1;
   prev1 = temp;
   ```

4. Store the result of the first case in `max`.

5. Reset `prev1` and `prev2`, then consider the second case where we **exclude the first house**.

   Traverse from index `1` to `nums.length - 1`.

   ```java
   for(int i = 1; i < nums.length; i++)
   ```

6. Calculate the maximum amount using the same recurrence.

7. Finally, return the larger result from the two cases:

   ```java
   return max > prev1 ? max : prev1;
   ```

---

## Dry Run

Let's take:

```text
nums = [2, 3, 2]
```

Since the houses are arranged in a circle, we cannot rob both the first and last houses.

### Case 1: Exclude the last house

Consider:

```text
[2, 3]
```

Initially:

```text
prev2 = 0
prev1 = 0
```

#### House 0

```text
temp = max(0 + 2, 0)
      = 2
```

Update:

```text
prev2 = 0
prev1 = 2
```

#### House 1

```text
temp = max(0 + 3, 2)
      = 3
```

Update:

```text
prev2 = 2
prev1 = 3
```

So:

```text
max = 3
```

---

### Case 2: Exclude the first house

Consider:

```text
[3, 2]
```

Reset:

```text
prev2 = 0
prev1 = 0
```

#### House 1

```text
temp = max(0 + 3, 0)
      = 3
```

Update:

```text
prev2 = 0
prev1 = 3
```

#### House 2

```text
temp = max(0 + 2, 3)
      = 3
```

Update:

```text
prev2 = 3
prev1 = 3
```

So:

```text
prev1 = 3
```

Finally:

```text
max(3, 3) = 3
```

Therefore, the maximum amount that can be robbed is:

```text
3
```

---

Let's take another example:

```text
nums = [1, 2, 3, 1]
```

### Case 1: Exclude the last house

```text
[1, 2, 3]
```

Maximum amount:

```text
4
```

We can rob:

```text
1 + 3 = 4
```

### Case 2: Exclude the first house

```text
[2, 3, 1]
```

Maximum amount:

```text
3
```

We can rob:

```text
2 + 1 = 3
```

Therefore:

```text
max(4, 3) = 4
```

The answer is:

```text
4
```

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* We traverse the array twice.
* Each traversal takes `O(n)`.
* Therefore, the total time complexity is `O(n)`.

**Space Complexity:** `O(1)`

* We only use a few variables (`prev1`, `prev2`, `temp`, and `max`).
* No additional DP array is required.
