# [77. Combinations](https://leetcode.com/problems/combinations/)

**Difficulty:** 🟡 Medium

## Problem

Given two integers `n` and `k`, return all possible combinations of `k` numbers chosen from the range:

```text
[1, n]
```

The combinations can be returned in any order.

## Algorithm

**Backtracking**

## Intuition

We need to choose exactly `k` numbers from `1` to `n`.

At every step, we choose one number and recursively choose the remaining numbers from the elements **after it**.

After exploring a choice, we remove it from the current combination and try the next number.

## Approach

1. Start with an empty `temp` list and `index = 1`.
2. If `k == 0`, a complete combination has been formed, so add it to `res`.
3. Iterate from `index` to `n`.
4. Add the current number to `temp`.
5. Recursively choose the remaining `k - 1` elements starting from `i + 1`.
6. Remove the last element to **backtrack**.
7. Continue until all possible combinations are generated.

```text
For n = 4, k = 2

                []
        /        |        |        \
      [1]       [2]      [3]       [4]
     / | \       / \       |
  [1,2][1,3][1,4] [2,3][2,4] [3,4]
```

The result is:

```text
[1,2]
[1,3]
[1,4]
[2,3]
[2,4]
[3,4]
```

## Dry Run

For:

```text
n = 4
k = 2
```

Starting with:

```text
temp = []
index = 1
```

Choose `1`:

```text
temp = [1]
```

Choose `2`:

```text
temp = [1,2]
```

`k == 0`, so add `[1,2]`.

Backtrack:

```text
temp = [1]
```

Then try `3` and `4`:

```text
[1,3]
[1,4]
```

Backtrack to the empty list and repeat with `2`, `3`, and `4`.

Final result:

```text
[[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]]
```

## Why This Works

The recursive call uses `i + 1`, so once a number is selected, it cannot be selected again.

This also ensures that combinations like:

```text
[1,2]
[2,1]
```

are not generated separately.

Backtracking explores every possible choice while maintaining only the current combination in `temp`.

## Complexity Analysis

There are:

```text
C(n, k)
```

possible combinations, and copying each combination takes `O(k)` time.

### Time Complexity

```text
O(C(n, k) × k)
```

### Space Complexity

The recursion depth and temporary combination require:

```text
O(k)
```

excluding the output.

## Key Takeaway

> **Backtracking → Choose → Explore → Undo**

```text
Algorithm → Backtracking
Pattern   → Combination Generation
Time      → O(C(n, k) × k)
Space     → O(k)  [excluding output]
```
