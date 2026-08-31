# [303. Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)

**Difficulty:** 🟢 Easy

## Problem

Given an integer array `nums`, calculate the sum of elements between indices `left` and `right` **inclusive**.

For example:

```text
nums = [-2, 0, 3, -5, 2, -1]

left = 0
right = 2
```

The range sum is:

```text
-2 + 0 + 3 = 1
```

Therefore:

```text
1
```

---

## Algorithm

This solution uses **Prefix Sum**.

We create a `sums` array where:

```text
sums[i] = sum of the first i elements
```

For example:

```text
nums = [-2, 0, 3, -5, 2, -1]

sums = [0, -2, -2, 1, -4, -2, -3]
```

To find the sum from `left` to `right`:

```text
sums[right + 1] - sums[left]
```

```text
Algorithm → Prefix Sum
Pattern   → Range Sum
```

---

## Intuition

Consider:

```text
nums = [-2, 0, 3, -5, 2, -1]
```

For:

```text
left = 1
right = 4
```

We need:

```text
0 + 3 + (-5) + 2 = 0
```

Using prefix sums:

```text
sums[right + 1] - sums[left]
= sums[5] - sums[1]
= -2 - (-2)
= 0
```

The prefix sum before `left` is subtracted, leaving only the required range.

---

## Approach

1. Create a prefix sum array of size `nums.length + 1`:

   ```java
   sums = new int[nums.length + 1];
   ```

2. Build the prefix sums:

   ```java
   for(int i = 1; i <= nums.length; i++){
       sums[i] = nums[i-1] + sums[i-1];
   }
   ```

3. For every range query, calculate:

   ```java
   return sums[right + 1] - sums[left];
   ```

4. This allows each `sumRange` query to be answered in constant time.

---

## Dry Run

Let's take:

```text
nums = [1, 2, 3, 4]
```

Prefix sum array:

```text
sums = [0, 1, 3, 6, 10]
```

Query:

```text
left = 1
right = 3
```

Using:

```text
sums[right + 1] - sums[left]
```

We get:

```text
sums[4] - sums[1]
= 10 - 1
= 9
```

Which is:

```text
2 + 3 + 4 = 9
```

---

## Why This Works

The prefix sum array stores the cumulative sum up to every position.

```text
sums[right + 1]
```

contains:

```text
nums[0] + ... + nums[right]
```

while:

```text
sums[left]
```

contains:

```text
nums[0] + ... + nums[left - 1]
```

Subtracting them removes the elements before `left`:

```text
sums[right + 1] - sums[left]
        ↓
   sum(left → right)
```

---

## Complexity Analysis

**Time Complexity:**

```text
Constructor → O(n)
sumRange()  → O(1)
```

**Space Complexity:** `O(n)`

* The `sums` array stores the prefix sums.

---

## Key Takeaway

Use **Prefix Sum** when an array has multiple range-sum queries.

```text
Build Prefix Sum
       ↓
sumRange(left, right)
       ↓
sums[right + 1] - sums[left]
       ↓
       O(1)
```

```text
Algorithm → Prefix Sum
Time      → O(n) preprocessing, O(1) per query
Space     → O(n)
```
