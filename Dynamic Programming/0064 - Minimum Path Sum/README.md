# [64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)

**Difficulty:** 🟠 Medium

## Problem

Given an `m × n` grid filled with **non-negative integers**, find a path from the **top-left corner** to the **bottom-right corner**.

The path can only move either **right** or **down** at each step.

Return the **minimum path sum** of any possible path.

---

## Intuition

To reach any cell `(i, j)`, we can only come from:

* The cell directly **above** `(i - 1, j)`, or
* The cell directly **left** `(i, j - 1)`.

Therefore, the minimum path sum to the current cell is:

```java
grid[i][j] + Math.min(above, left)
```

A straightforward solution would use a `2D` DP table where `dp[i][j]` stores the minimum path sum to cell `(i, j)`.

However, we can optimize the space by using a single `1D` array.

Here, `dp[j]` represents the minimum path sum to the **current row's cell** in column `j`.

While processing a new row:

* `dp[j]` contains the value from the **cell above** before updating.
* `dp[j - 1]` contains the value from the **cell to the left** because it has already been updated for the current row.

Therefore:

```java
dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
```

---

## Approach

1. Create a `1D` DP array `dp` of size `m`, where `dp[j]` stores the minimum path sum to the current row's cell in column `j`.

2. Initialize the starting cell:

   ```java
   dp[0] = grid[0][0];
   ```

3. Process the **first row** separately.

   Since the first row can only be reached by moving **right**, each value is calculated using the previous cell:

   ```java
   dp[j] = dp[j - 1] + grid[0][j];
   ```

4. Traverse the remaining rows.

   For the first column, there is only one possible path: moving **down**.

   ```java
   dp[0] += grid[i][0];
   ```

5. For every remaining cell, choose the smaller path between **above** and **left**:

   ```java
   dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
   ```

   Here:

   * `dp[j]` → minimum path sum from the **cell above**.
   * `dp[j - 1]` → minimum path sum from the **cell to the left**.
   * `grid[i][j]` → value of the current cell.

6. After processing the entire grid, `dp[m - 1]` contains the minimum path sum to the bottom-right corner.

---

## Dry Run

Let's take:

```text
grid = [
    [1, 3, 1],
    [1, 5, 1],
    [4, 2, 1]
]
```

Initially:

```text
dp = [1, 0, 0]
```

`dp[0] = 1` because the starting cell contains `1`.

### First Row

The first row can only be reached by moving **right**.

```text
dp[1] = 1 + 3 = 4
dp[2] = 4 + 1 = 5
```

```text
dp = [1, 4, 5]
```

---

### Row 1

Before updating each cell:

* `dp[j]` represents the value from **above**.
* `dp[j - 1]` represents the value from **left**.

First column:

```text
dp[0] = 1 + 1 = 2
```

Now process the remaining cells:

```text
dp[1] = 5 + min(4, 2)
      = 5 + 2
      = 7

dp[2] = 1 + min(5, 7)
      = 1 + 5
      = 6
```

So:

```text
dp = [2, 7, 6]
```

---

### Row 2

First column:

```text
dp[0] = 2 + 4 = 6
```

Next:

```text
dp[1] = 2 + min(7, 6)
      = 2 + 6
      = 8

dp[2] = 1 + min(6, 8)
      = 1 + 6
      = 7
```

Final:

```text
dp = [6, 8, 7]
```

Therefore:

```text
dp[m - 1] = dp[2] = 7
```

The minimum path sum is:

```text
7
```

One possible minimum path is:

```text
1 → 3 → 1 → 1 → 1
```

with sum:

```text
1 + 3 + 1 + 1 + 1 = 7
```

---

## Complexity Analysis

**Time Complexity:** `O(m × n)`

* We visit every cell in the grid exactly once.

**Space Complexity:** `O(n)`

* We only maintain a single `1D` DP array of size `n`.
* This improves the space complexity from `O(m × n)` in the `2D` DP approach to `O(n)`.

---

## Key Idea

The main optimization is that we don't need to store the entire DP table.

For every cell, we only need:

```text
       Above
         ↓
Left → Current
```

Using a `1D` array, the **above value** is still stored in `dp[j]`, while the **left value** is stored in `dp[j - 1]`.

Therefore, we can solve the problem in:

```text
Time:  O(m × n)
Space: O(n)
```
