# [1200. Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference/)

**Difficulty:** 🟢 Easy

## Problem

Given an array of distinct integers `arr`, find all pairs of elements with the **minimum absolute difference**.

Return the pairs in ascending order.

For example:

```text
arr = [4, 2, 1, 3]
```

The minimum absolute difference is:

```text
1
```

The pairs are:

```text
[1, 2]
[2, 3]
[3, 4]
```

---

## Algorithm

This solution uses a **Sorting** approach.

First, sort the array:

```text
[1, 2, 3, 4]
```

After sorting, the minimum difference will always be found between **adjacent elements**.

We make two passes:

```text
First Pass  → Find the minimum difference
Second Pass → Collect all pairs with that difference
```

```text
Algorithm → Sorting + Array Traversal
Pattern   → Adjacent Elements
```

---

## Intuition

Consider:

```text
arr = [4, 2, 1, 3]
```

After sorting:

```text
1   2   3   4
↑   ↑
```

Calculate the differences between adjacent elements:

```text
2 - 1 = 1
3 - 2 = 1
4 - 3 = 1
```

The minimum difference is:

```text
1
```

Therefore, all adjacent pairs with difference `1` are added to the result.

---

## Approach

1. Sort the array:

   ```java
   Arrays.sort(arr);
   ```

2. Initialize the minimum difference:

   ```java
   int minDiff = Integer.MAX_VALUE;
   ```

3. Traverse the sorted array and find the minimum difference:

   ```java
   for(int i = 1; i < arr.length; i++){
       int currDiff = Math.abs(arr[i] - arr[i-1]);
       minDiff = Math.min(minDiff, currDiff);
   }
   ```

4. Traverse the array again.

5. If the current difference equals `minDiff`, add the pair:

   ```java
   if(currDiff == minDiff){
       res.add(List.of(arr[i-1], arr[i]));
   }
   ```

6. Return the result.

---

## Dry Run

Let's take:

```text
arr = [4, 2, 1, 3]
```

After sorting:

```text
arr = [1, 2, 3, 4]
```

### First Pass

```text
2 - 1 = 1
3 - 2 = 1
4 - 3 = 1
```

So:

```text
minDiff = 1
```

### Second Pass

All adjacent pairs with difference `1` are added:

```text
[1, 2]
[2, 3]
[3, 4]
```

Final answer:

```text
[[1, 2], [2, 3], [3, 4]]
```

---

## Why This Works

After sorting:

```text
a ≤ b ≤ c ≤ d
```

The closest values must be next to each other.

For example:

```text
a -------- c
```

Any element between them will have a difference that is smaller than or equal to the difference between `a` and `c`.

Therefore, checking only adjacent elements is enough to find the minimum absolute difference.

---

## Complexity Analysis

**Time Complexity:** `O(n log n)`

* Sorting takes `O(n log n)`.
* The two array traversals take `O(n)`.
* Sorting dominates the overall complexity.

**Space Complexity:** `O(1)`

* Ignoring the output list, only a few variables are used.
* The space complexity depends on the sorting implementation.

---

## Key Takeaway

Sort the array and compare only **adjacent elements**.

```text
Sort Array
    ↓
Find Minimum Difference
    ↓
Check Adjacent Pairs
    ↓
Store Matching Pairs
```

```text
Algorithm → Sorting + Array Traversal
Pattern   → Adjacent Elements
Time      → O(n log n)
Space     → O(1)
```
