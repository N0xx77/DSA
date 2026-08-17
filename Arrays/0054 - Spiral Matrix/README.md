# [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)

**Difficulty:** 🟠 Medium

## Problem

Given an `m × n` matrix, return all elements of the matrix in **spiral order**.

Starting from the top-left corner, traverse the matrix in the following order:

```text
Right → Down → Left → Up
```

Continue this process until every element has been visited.

For example:

```text
1  2  3
4  5  6
7  8  9
```

The spiral order is:

```text
[1, 2, 3, 6, 9, 8, 7, 4, 5]
```

---

## Algorithm

This solution uses a **Boundary Traversal** approach.

Instead of maintaining a `visited` matrix, we keep track of four boundaries:

```text
rowStart
rowEnd
columnStart
columnEnd
```

These boundaries represent the portion of the matrix that has **not yet been visited**.

At every step, we traverse four directions:

```text
1. Left → Right   : Top row
2. Top → Bottom   : Right column
3. Right → Left   : Bottom row
4. Bottom → Top    : Left column
```

After traversing each boundary, we move it inward.

```text
Algorithm → Boundary Traversal
Pattern   → Matrix / Simulation
```

---

## Intuition

Consider the matrix:

```text
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16
```

Initially, the boundaries are:

```text
rowStart    = 0
rowEnd      = 3
columnStart = 0
columnEnd   = 3
```

We first traverse the top row:

```text
1 → 2 → 3 → 4
```

Then move the top boundary down:

```text
rowStart++
```

Now the remaining unvisited region is:

```text
5  6  7  8
9  10 11 12
13 14 15 16
```

Next, traverse the right column:

```text
8 → 12 → 16
```

Then move the right boundary left:

```text
columnEnd--
```

We continue this process until the boundaries cross.

---

## Approach

1. Create a list to store the spiral order:

   ```java
   List<Integer> spiral = new ArrayList<>();
   ```

2. Initialize the four boundaries:

   ```java
   int rowStart = 0;
   int rowEnd = matrix.length - 1;

   int columnStart = 0;
   int columnEnd = matrix[0].length - 1;
   ```

3. Continue while there are still unvisited rows and columns:

   ```java
   while(rowStart <= rowEnd && columnStart <= columnEnd)
   ```

4. Traverse the **top row** from left to right:

   ```java
   for(int i = columnStart; i <= columnEnd; i++){
       spiral.add(matrix[rowStart][i]);
   }
   ```

   Then move the top boundary down:

   ```java
   rowStart++;
   ```

5. Traverse the **right column** from top to bottom:

   ```java
   for(int i = rowStart; i <= rowEnd; i++){
       spiral.add(matrix[i][columnEnd]);
   }
   ```

   Then move the right boundary left:

   ```java
   columnEnd--;
   ```

6. Before traversing the bottom row, check that there is still an unvisited row:

   ```java
   if(rowStart <= rowEnd)
   ```

   Traverse from right to left:

   ```java
   for(int i = columnEnd; i >= columnStart; i--){
       spiral.add(matrix[rowEnd][i]);
   }
   ```

   Then move the bottom boundary up:

   ```java
   rowEnd--;
   ```

7. Before traversing the left column, check that there is still an unvisited column:

   ```java
   if(columnStart <= columnEnd)
   ```

   Traverse from bottom to top:

   ```java
   for(int i = rowEnd; i >= rowStart; i--){
       spiral.add(matrix[i][columnStart]);
   }
   ```

   Then move the left boundary right:

   ```java
   columnStart++;
   ```

8. Once the boundaries cross, all elements have been visited.

---

## Dry Run

Let's take:

```text
matrix =
[
    [1,  2,  3],
    [4,  5,  6],
    [7,  8,  9]
]
```

Initially:

```text
rowStart = 0
rowEnd = 2

columnStart = 0
columnEnd = 2
```

### Step 1 — Top Row

Traverse from left to right:

```text
1 → 2 → 3
```

```text
spiral = [1, 2, 3]
```

Move the top boundary:

```text
rowStart = 1
```

---

### Step 2 — Right Column

Traverse from top to bottom:

```text
6
9
```

```text
spiral = [1, 2, 3, 6, 9]
```

Move the right boundary:

```text
columnEnd = 1
```

---

### Step 3 — Bottom Row

There is still an unvisited row:

```text
rowStart <= rowEnd
```

Traverse from right to left:

```text
8 → 7
```

```text
spiral = [1, 2, 3, 6, 9, 8, 7]
```

Move the bottom boundary:

```text
rowEnd = 1
```

---

### Step 4 — Left Column

There is still an unvisited column:

```text
columnStart <= columnEnd
```

Traverse from bottom to top:

```text
4
```

```text
spiral = [1, 2, 3, 6, 9, 8, 7, 4]
```

Move the left boundary:

```text
columnStart = 1
```

---

### Step 5 — Inner Matrix

The remaining unvisited portion is:

```text
5
```

The boundaries are now:

```text
rowStart = 1
rowEnd = 1

columnStart = 1
columnEnd = 1
```

Traverse the top row:

```text
5
```

```text
spiral = [1, 2, 3, 6, 9, 8, 7, 4, 5]
```

After moving the boundaries, they cross and the loop terminates.

Final answer:

```text
[1, 2, 3, 6, 9, 8, 7, 4, 5]
```

---

## Why Are the `if` Conditions Necessary?

The following checks are important:

```java
if(rowStart <= rowEnd)
```

and:

```java
if(columnStart <= columnEnd)
```

Without these conditions, we could visit the same elements more than once when the matrix has an odd number of rows or columns.

For example, consider:

```text
1  2  3
4  5  6
```

After processing the top row and right column, there may be no bottom row left to process.

The condition:

```java
if(rowStart <= rowEnd)
```

prevents us from traversing an already-visited row.

Similarly, the second condition prevents duplicate traversal of an already-visited column.

---

## Boundary Movement

The four boundaries move inward after each traversal:

```text
Top row:
rowStart++

Right column:
columnEnd--

Bottom row:
rowEnd--

Left column:
columnStart++
```

Visually:

```text
          columnStart →
        ┌───────────────┐
        │               │
rowStart│   unvisited   │
   ↓    │    region     │
        │               │
        └───────────────┘
                 ↑
               rowEnd
```

Each boundary removes one layer of the matrix from further consideration.

---

## Why This Works

Every iteration processes one complete **layer** of the matrix.

For each layer, we visit:

```text
Top    → Left to Right
Right  → Top to Bottom
Bottom → Right to Left
Left   → Bottom to Top
```

After that, all four boundaries move inward.

Because every boundary only moves inward and never moves backward, every matrix element is visited exactly once.

---

## Complexity Analysis

**Time Complexity:** `O(m × n)`

* Every element in the matrix is visited exactly once.

**Space Complexity:** `O(1)` auxiliary space.

* We only use four boundary variables.
* The returned `spiral` list requires `O(m × n)` space to store the answer, but this is considered **output space**.

Therefore:

```text
Auxiliary Space → O(1)
Output Space    → O(m × n)
```

---

## Key Takeaway

The main idea is to avoid a separate `visited` matrix by maintaining four boundaries:

```text
rowStart
rowEnd
columnStart
columnEnd
```

Then repeatedly traverse:

```text
→ Right
↓ Down
← Left
↑ Up
```

while moving the boundaries inward.

```text
Algorithm → Boundary Traversal
Pattern   → Matrix Simulation
Time      → O(m × n)
Space     → O(1) auxiliary
```
