# [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)

**Difficulty:** 🟠 Medium

## Problem

Given an `m × n` grid where:

```text
'1' → Land
'0' → Water
```

an island is formed by connecting adjacent land cells **horizontally or vertically**.

Return the number of islands in the grid.

For example:

```text
1  1  0
1  0  0
0  0  1
```

There are `2` islands.

---

## Algorithm

This solution uses **Breadth-First Search (BFS)**.

Whenever we find an unvisited land cell:

```text
grid[i][j] == '1'
```

we have found a new island.

We increment the island count and use BFS to visit all connected land cells.

Visited cells are marked as:

```text
'2'
```

```text
Algorithm → Breadth-First Search (BFS)
Pattern   → Grid / Connected Components
```

---

## Intuition

Consider:

```text
1  1  0
1  0  0
0  0  1
```

Starting from the first `1`, BFS visits:

```text
1  1
1
```

and marks them as visited:

```text
2  2  0
2  0  0
0  0  1
```

When we later find the last `1`, it belongs to another island.

Therefore:

```text
islands = 2
```

The key idea is:

> Every unvisited `1` found during the grid traversal represents a new island.

---

## Approach

1. Initialize the island count:

   ```java
   int islands = 0;
   ```

2. Create a queue for BFS:

   ```java
   Queue<int[]> q = new ArrayDeque<>();
   ```

3. Traverse every cell in the grid.

4. If the current cell is land:

   ```java
   if(grid[i][j] == '1')
   ```

   increment the island count.

5. Mark the cell as visited:

   ```java
   grid[i][j] = '2';
   ```

6. Add it to the queue:

   ```java
   q.add(new int[]{i, j});
   ```

7. While the queue is not empty, check the four directions:

   ```text
   Down
   Right
   Up
   Left
   ```

8. If a neighboring cell contains `'1'`, mark it as `'2'` and add it to the queue.

9. Continue until all cells have been processed.

10. Return the island count.

---

## Dry Run

Consider:

```text
1  1  0
1  0  0
0  0  1
```

Initially:

```text
islands = 0
```

### Step 1 — First Island

Find:

```text
grid[0][0] = '1'
```

Increment:

```text
islands = 1
```

BFS visits all connected land:

```text
2  2  0
2  0  0
0  0  1
```

---

### Step 2 — Second Island

Continue scanning and find:

```text
grid[2][2] = '1'
```

Increment:

```text
islands = 2
```

Mark it as visited:

```text
2  2  0
2  0  0
0  0  2
```

Final answer:

```text
2
```

---

## Four Directions

For every cell `(x, y)`, we check:

```text
Down  → (x + 1, y)
Right → (x, y + 1)
Up    → (x - 1, y)
Left  → (x, y - 1)
```

Boundary conditions ensure that we don't access cells outside the grid.

---

## Why Mark Cells as `'2'`?

When a land cell is visited:

```java
grid[x][y] = '2';
```

This prevents it from being visited again.

It also means we don't need a separate:

```java
boolean[][] visited;
```

The grid itself stores the visited information.

---

## Complexity Analysis

**Time Complexity:** `O(m × n)`

* Every cell is visited at most once.

**Space Complexity:** `O(m × n)`

* The BFS queue can contain up to `m × n` cells in the worst case.

---

## Key Takeaway

The main pattern is:

```text
Find '1'
   ↓
islands++
   ↓
Start BFS
   ↓
Visit connected '1's
   ↓
Mark them as '2'
```

```text
Algorithm → BFS
Pattern   → Grid / Connected Components
Time      → O(m × n)
Space     → O(m × n)
```
