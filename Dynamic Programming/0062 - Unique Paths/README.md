# 62. [Unique Paths](https://leetcode.com/problems/unique-paths/)

**Difficulty:** 🟠 Medium

## Problem

There is a robot initially located at the top-left corner of an `m × n` grid.

The robot can only move either **right** or **down**.

Return the number of possible unique paths from the top-left to the bottom-right corner.

---

## Intuition

To reach any cell `(i, j)`, the robot can only come from:

- The cell directly **above** `(i - 1, j)`, or
- The cell directly **left** `(i, j - 1)`.

Therefore, the number of unique paths to a cell is simply the sum of the paths from these two directions.

Instead of using a `2D` DP table to store the number of paths for every cell, we can optimize the space by using a single `1D` array. Since the grid is processed **row by row**, we only need to keep track of one value for each column.

Here, `dp[j]` represents the number of unique paths to the **current row's cell** in column `j`.

---

## Approach

1. Create a `1D` DP array `dp` of size `n`, where `dp[j]` stores the number of unique paths to the current row's cell in column `j`.

2. Initialize `dp[0] = 1` since there is only one way to reach the starting cell.

3. Traverse the grid **row by row**.
   - For each row, iterate through the columns starting from `1`.
   - Update each column using:
     ```java
     dp[j] += dp[j - 1];
     ```
   - Here:
     - `dp[j]` (before updating) stores the number of paths from the **cell above**.
     - `dp[j - 1]` stores the number of paths from the **cell to the left**, as it has already been updated for the current row.
     - Their sum gives the number of unique paths to the current cell.

4. After all rows have been processed, `dp[n - 1]` contains the number of unique paths to the bottom-right cell.

---

## Dry Run

Let's take:

```text
m = 3, n = 4
```

Initially,

```text
dp = [1, 0, 0, 0]
```

`dp[0] = 1` because there is only one way to reach the starting cell.

### Row 0

- `dp[1] = 0 + 1 = 1`
- `dp[2] = 0 + 1 = 1`
- `dp[3] = 0 + 1 = 1`

```text
dp = [1, 1, 1, 1]
```

Each cell in the first row can only be reached by moving **right**, so every value becomes `1`.

### Row 1

Before updating, `dp[j]` stores the number of paths from the **cell above**, while `dp[j - 1]` stores the number of paths from the **cell to the left**.

- `dp[1] = 1 + 1 = 2`
- `dp[2] = 1 + 2 = 3`
- `dp[3] = 1 + 3 = 4`

```text
dp = [1, 2, 3, 4]
```

After processing this row, `dp[j]` now represents the number of unique paths to the current row's cell in column `j`.

### Row 2

Again, each cell is computed as:

```text
Current Cell = Above + Left
```

- `dp[1] = 2 + 1 = 3`
- `dp[2] = 3 + 3 = 6`
- `dp[3] = 4 + 6 = 10`

```text
dp = [1, 3, 6, 10]
```

The final answer is:

```text
dp[n - 1] = dp[3] = 10
```

Thus, there are **10 unique paths** from the top-left to the bottom-right corner.

---

## Complexity Analysis

**Time Complexity:** `O(m × n)`

- We visit each cell in the grid exactly once.

**Space Complexity:** `O(n)`

- We only maintain a single DP array of size `n`, instead of a full `m × n` DP table.

---
