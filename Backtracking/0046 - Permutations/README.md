# [46. Permutations](https://leetcode.com/problems/permutations/)

**Difficulty:** 🟡 Medium

## Problem

Given an array `nums` containing **distinct integers**, return all possible permutations.

A permutation is an arrangement of all elements in a different order.

## Algorithm

**Backtracking**

## Intuition

For each position, we can choose any element that has **not been used yet**.

We keep track of used elements using a `boolean[]` array.

Once a permutation is complete, we add it to the result and backtrack to try another arrangement.

## Approach

1. Start with an empty `temp` list.
2. Use `used[i]` to track whether an element is already included.
3. Try every unused element.
4. Mark it as used and add it to `temp`.
5. Recursively build the next position.
6. Once `temp` contains all elements, add it to `res`.
7. Remove the last element and mark it unused to **backtrack**.

```text
nums = [1, 2, 3]

                []
          /      |      \
        [1]     [2]     [3]
       /  \     /  \     /  \
   [1,2] [1,3] [2,1] [2,3] [3,1] [3,2]
      |     |     |     |     |     |
 [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]
```

## Dry Run

For:

```text
nums = [1, 2, 3]
```

Start:

```text
temp = []
used = [false, false, false]
```

Choose `1`:

```text
temp = [1]
used = [true, false, false]
```

Choose `2`:

```text
temp = [1,2]
```

Choose `3`:

```text
temp = [1,2,3]
```

`temp.size() == nums.length`, so add it to the result.

Then backtrack:

```text
[1,2,3] → [1,2] → [1]
```

Now choose `3` instead of `2`:

```text
[1,3,2]
```

The process continues until all `3! = 6` permutations are generated.

## Why This Works

At each position, the algorithm tries every element that has not been used.

The `used` array prevents the same element from appearing more than once in a permutation.

Backtracking then restores the previous state so that other possible arrangements can be explored.

For `n` elements, the total number of permutations is:

```text
n!
```

## Complexity Analysis

### Time Complexity

There are `n!` permutations, and each permutation takes `O(n)` time to construct/copy.

```text
O(n × n!)
```

### Space Complexity

The recursion depth, `temp`, and `used` array require:

```text
O(n)
```

excluding the output.

## Key Takeaway

> **Backtracking → Choose an unused element → Explore → Undo**

```text
Algorithm → Backtracking
Pattern   → Permutation Generation
Time      → O(n × n!)
Space     → O(n)  [excluding output]
```
