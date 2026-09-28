# [980. Unique Paths III](https://leetcode.com/problems/unique-paths-iii/)

**Difficulty:** 🔴 Hard

## Problem

You are given a grid containing:

* `1` → Starting square
* `2` → Ending square
* `0` → Empty square
* `-1` → Obstacle

Return the number of paths from the starting square to the ending square such that **every empty square is visited exactly once**.

## Algorithm

**Backtracking + DFS**

## Intuition

At each cell, try moving in all **four possible directions**.

We keep track of how many empty squares (`0`) are still left to visit.

When visiting an empty square, decrease the count and mark the cell as visited.

When reaching the ending square (`2`), the path is valid only if **all empty squares have been visited**.

After exploring a path, restore the cell so it can be used in another path.

## Approach

1. Traverse the grid to find the starting position (`1`).
2. Count the number of empty squares (`0`).
3. Start DFS from the starting position.
4. If the current cell is outside the grid or already visited, return `0`.
5. If the current cell is `2`, return `1` only when `zeroes == 0`.
6. If the current cell is `0`, decrease `zeroes`.
7. Mark the current cell as visited by changing it to `-1`.
8. Recursively explore all four directions.
9. Restore the cell after exploring all directions.
10. Return the total number of valid paths.

```text
Grid:

1  0  0
0  0  0
0  0  2

Start:
(0,0)

Explore:
        ↓
        → 
        ↑
        ←

A path is counted only when:

Start → Visit every 0 → End
```

## Dry Run

For:

```text
grid =
[
    [1, 0, 0],
    [0, 0, 0],
    [0, 0, 2]
]
```

First, count the empty squares:

```text
zeroes = 6
```

Start at:

```text
x = 0
y = 0
```

When moving to an empty square:

```text
zeroes--
```

The visited cell is marked:

```text
grid[x][y] = -1
```

The algorithm explores all possible paths.

When it reaches `2`:

```text
if(zeroes == 0)
    return 1;
else
    return 0;
```

After exploring a path, the cell is restored:

```text
grid[x][y] = 0
```

This allows the same cell to be used in another possible path.

## Why This Works

The algorithm explores every possible path using **DFS and backtracking**.

A path is counted only when it reaches the ending square after visiting **every empty square exactly once**.

Marking cells as `-1` prevents revisiting cells during the current path.

Restoring the cell after exploration allows other paths to use it.

## Complexity Analysis

### Time Complexity

For each walkable cell, there can be up to **4 possible directions**.

If `V` is the number of walkable cells:

```text
O(4^V)
```

in the worst case.

### Space Complexity

The recursion can go as deep as the number of walkable cells:

```text
O(V)
```

excluding the input grid and output.

## Key Takeaway

> **Backtracking → Mark Visited → Explore 4 Directions → Restore**

```text
Algorithm → Backtracking + DFS
Pattern   → Grid Path Exploration
Time      → O(4^V)
Space     → O(V)  [excluding output]
```
