# [448. Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

**Difficulty:** 🟡 Easy

## Problem

Given an array `nums` containing `n` integers where each integer is in the range `[1, n]`, find all the numbers in the range `[1, n]` that **do not appear** in `nums`.

The solution must run in `O(n)` time and use **constant extra space**, excluding the returned list.

## Algorithm

**Cyclic Sort**

## Intuition

Since every number belongs to the range:

```text
1 → n
```

each number has a **correct index**:

```text
number → number - 1
```

We can rearrange the array so that every number is placed at its correct position.

After sorting:

```text
index 0 → 1
index 1 → 2
index 2 → 3
...
```

If `nums[i] != i + 1`, then the number `i + 1` is missing.

## Approach

1. Start from index `0`.
2. Calculate the correct position of `nums[i]`:

   ```text
   correct_position = nums[i] - 1
   ```
3. If the number is not already at its correct position, swap it into place.
4. Otherwise, move to the next index.
5. After the array is rearranged, traverse it again.
6. If `nums[i] != i + 1`, add `i + 1` to the result.

## Dry Run

For:

```text
nums = [4,3,2,7,8,2,3,1]
```

After cyclic sorting:

```text
[1,2,3,4,3,2,7,8]
```

Now compare each index with its expected value:

```text
Index:    0  1  2  3  4  5  6  7
Expected: 1  2  3  4  5  6  7  8
Actual:   1  2  3  4  3  2  7  8
```

At index `4`:

```text
nums[4] != 5
```

so `5` is missing.

At index `5`:

```text
nums[5] != 6
```

so `6` is missing.

Therefore:

```text
[5,6]
```

## Why This Works

Every number `x` belongs at index `x - 1`.

Cyclic Sort places each number at its correct position whenever possible.

Because duplicates exist, some positions will remain occupied by another number. Those positions directly identify the missing numbers.

For example:

```text
nums[i] != i + 1
```

means the number `i + 1` never appeared in the array.

## Complexity Analysis

### Time Complexity

Each number is moved to its correct position at most once, and the final traversal takes `O(n)`:

```text
O(n)
```

### Space Complexity

No additional array is used. Only the result list is created:

```text
O(1)
```

excluding the output.

## Key Takeaway

> **Number `x` belongs at index `x - 1` → Place elements correctly → Find mismatched positions**

```text
Algorithm → Cyclic Sort
Pattern   → Index as Correct Position
Time      → O(n)
Space     → O(1)  [excluding output]
```
