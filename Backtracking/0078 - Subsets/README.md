# [78. Subsets](https://leetcode.com/problems/subsets/)

**Difficulty:** 🟡 Medium

## Problem

Given an integer array `nums` containing **unique elements**, return all possible **subsets** (the power set).

The solution set must not contain duplicate subsets.

## Algorithm

**Backtracking**

## Intuition

For every element, we have two choices:

* **Include** the element in the current subset.
* **Skip** the element and move to the next one.

The backtracking approach explores all possible combinations while using `temp` to maintain the current subset.

## Approach

1. Start with an empty subset.
2. Add the current `temp` subset to the answer.
3. Iterate through the remaining elements.
4. Add an element to `temp`.
5. Recursively generate subsets starting from the next index.
6. Remove the last element to **backtrack** and try the next possibility.

```text
                    []
          /          |          \
        [1]         [2]         [3]
       /   \          |
    [1,2] [1,3]     [2,3]
      |
   [1,2,3]
```

Since every element can either be included or excluded, an array of `n` elements has:

```text
2^n subsets
```

## Dry Run

For:

```text
nums = [1, 2, 3]
```

The recursion generates:

```text
[]
[1]
[1,2]
[1,2,3]
[1,3]
[2]
[2,3]
[3]
```

These are all `2³ = 8` possible subsets.

## Why This Works

At every recursive call, the current subset is added to the result.

The loop then tries including each remaining element, recursively explores that choice, and removes it afterward to restore the previous state.

This ensures that **every possible combination is generated exactly once**.

## Complexity Analysis

### Time Complexity

There are `2^n` subsets, and each subset can contain up to `n` elements.

```text
O(n × 2^n)
```

### Space Complexity

The recursion depth and temporary subset require:

```text
O(n)
```

excluding the space required to store the output.

## Key Takeaway

> **Backtracking → Choose an element → Explore → Undo the choice**

```text
Algorithm → Backtracking
Pattern   → Subset / Combination Generation
Time      → O(n × 2^n)
Space     → O(n)  [excluding output]
```
