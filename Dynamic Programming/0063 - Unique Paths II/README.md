# [63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)

**Difficulty:** 🟠 Medium

## Problem

You are given an `m × n` grid where:

* `0` represents an **empty cell**.
* `1` represents an **obstacle**.

A robot starts at the **top-left corner** and wants to reach the **bottom-right corner**.

The robot can only move either **right** or **down**.

Return the number of possible unique paths from the top-left to the bottom-right corner.

If there is an obstacle in the starting cell, return `0`.

---

## Intuition

This problem is similar to **Unique Paths**, but now some cells contain obstacles.

For an empty cell `(i, j)`, the robot can reach it from:

* The cell directly **above** `(i - 1, j)`, or
* The cell directly **left** `(i, j - 1)`.

Therefore:

```java
dp[j] += dp[j - 1];
```

Here:

* `dp[j]` stores the number of paths from the **cell above**.
* `dp[j - 1]` stores the number of paths from the **cell to the left**.

However, if the current cell is an obstacle:

```java
if (obstacleGrid[i][j] == 1)
    dp[j] = 0;
```

This is important because an obstacle cannot be part of any valid path.

By setting `dp[j] = 0`, we effectively remove all paths that would pass through that obstacle.

Instead of using a `2D` DP table, we use a single `1D` array to reduce the space complexity.

---

## Approach

1. Check if the grid is `null` or if the starting cell contains an obstacle.

   ```java
   if (obstacleGrid == null || obstacleGrid[0][0] == 1)
       return 0;
   ```

   If the starting cell is blocked, there is no possible path.

2. Create a `1D` DP array of size `c`:

   ```java
   int[] dp = new int[c];
   ```

   Here, `dp[j]` represents the number of unique paths to the current row's cell in column `j`.

3. Initialize:

   ```java
   dp[0] = 1;
   ```

   There is one way to reach the starting cell if it is not blocked.

4. Traverse the grid row by row and column by column.

5. If the current cell is an obstacle:

   ```java
   dp[j] = 0;
   ```

   No valid path can pass through this cell.

6. If the current cell is not an obstacle and `j > 0`, update:

   ```java
   dp[j] += dp[j - 1];
   ```

   Here:

   * `dp[j]` → paths coming from **above**.
   * `dp[j - 1]` → paths coming from the **left**.

7. After processing the entire grid, `dp[c - 1]` contains the number of unique paths to the bottom-right corner.

---

## Complexity Analysis

**Time Complexity:** `O(r × c)`

* We visit every cell in the grid exactly once.

**Space Complexity:** `O(c)`

* We use a single `1D` DP array of size `c`.
* This improves the space complexity from `O(r × c)` with a `2D` DP table to `O(c)`.

---

## Key Idea

For every cell:

```text
       Above
         ↓
Left → Current
```

For an empty cell:

```java
dp[j] += dp[j - 1];
```

For an obstacle:

```java
dp[j] = 0;
```

So the entire solution can be summarized as:

```java
if (obstacleGrid[i][j] == 1)
    dp[j] = 0;
else if (j > 0)
    dp[j] += dp[j - 1];
```

The obstacle simply **kills all paths through that cell**, while the normal DP transition combines the paths from **above and left**.

Final complexity:

```text
Time:  O(r × c)
Space: O(c)
```
