# [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

**Difficulty:** 🟡 Medium

## Problem

Given an array of positive integers `nums` and an integer `target`, find the **minimum length** of a contiguous subarray whose sum is greater than or equal to `target`.

If no such subarray exists, return:

```text
0
```

For example:

```text
target = 7
nums = [2, 3, 1, 2, 4, 3]
```

A valid subarray is:

```text
[4, 3]
```

Its sum is:

```text
4 + 3 = 7
```

So the minimum length is:

```text
2
```

---

## Algorithm

This solution uses a **Sliding Window** approach.

We maintain two pointers:

```text
l → Start of the window
r → End of the window
```

As `r` moves forward, we add elements to the current sum.

```text
sum += nums[r]
```

Once the sum becomes greater than or equal to the target:

```text
sum >= target
```

we try to shrink the window from the left to find a smaller valid subarray.

```text
Algorithm → Sliding Window
Pattern   → Variable Size Window
```

---

## Intuition

Consider:

```text
target = 7

nums = [2, 3, 1, 2, 4, 3]
```

Expand the window:

```text
[2, 3, 1, 2]
```

Sum:

```text
2 + 3 + 1 + 2 = 8
```

Since the sum is greater than or equal to `7`, we have a valid window.

Now try to shrink it from the left:

```text
[3, 1, 2, 4]
```

Continue shrinking while:

```text
sum >= target
```

This helps us find the smallest possible valid subarray.

---

## Approach

1. Initialize:

   ```java
   int minLength = Integer.MAX_VALUE;
   int l = 0;
   int sum = 0;
   ```

2. Move the right pointer through the array:

   ```java
   for(int r = 0; r < nums.length; r++)
   ```

3. Add the current element to the window:

   ```java
   sum += nums[r];
   ```

4. While the sum is greater than or equal to the target:

   ```java
   while(sum >= target)
   ```

5. Update the minimum length:

   ```java
   minLength = Math.min(minLength, r - l + 1);
   ```

6. Remove the left element and shrink the window:

   ```java
   sum -= nums[l++];
   ```

7. If no valid subarray is found, return `0`.

---

## Dry Run

Let's take:

```text
target = 7
nums = [2, 3, 1, 2, 4, 3]
```

Start expanding:

```text
[2, 3, 1, 2]
```

```text
sum = 8
```

Valid window:

```text
Length = 4
```

Shrink from the left:

```text
[3, 1, 2, 4]
```

Later:

```text
[4, 3]
```

Now:

```text
4 + 3 = 7
```

Length:

```text
2
```

This is the minimum valid subarray.

Final answer:

```text
2
```

---

## Why This Works

Since all numbers are **positive**, expanding the window always increases the sum, while shrinking the window decreases the sum.

Therefore:

```text
sum < target
    ↓
Expand the window

sum >= target
    ↓
Try shrinking the window
```

This allows us to check all possible valid windows efficiently without using nested loops.

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* The right pointer moves through the array once.
* The left pointer also moves through the array at most once.
* Therefore, each element is processed at most twice.

**Space Complexity:** `O(1)`

* Only a few variables are used.

---

## Key Takeaway

Use a **Variable Size Sliding Window** when you need to find a contiguous subarray satisfying a condition.

```text
Move r
  ↓
Expand Window
  ↓
sum >= target?
  ↓
Yes
  ↓
Shrink from l
  ↓
Update Minimum Length
```

```text
Algorithm → Sliding Window
Pattern   → Variable Size Window
Time      → O(n)
Space     → O(1)
```
