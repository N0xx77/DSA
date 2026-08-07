# [118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)

**Difficulty:** 🟢 Easy

## Problem

Given an integer `numRows`, return the first `numRows` of Pascal's Triangle.

In Pascal's Triangle:

- The first and last element of every row is always `1`.
- Every interior element is the sum of the two elements directly above it.

---

## Intuition

Each row of Pascal's Triangle can be constructed using the row immediately before it.

- The **first** and **last** elements of every row are always `1`.
- Every **middle** element is obtained by adding the two adjacent elements from the previous row.

Since each row depends only on the previously computed row, we can build the triangle **row by row** and store every row in a list.

Here, `res` stores all the rows generated so far, while `temp` represents the current row being constructed.

---

## Approach

1. Create an empty list `res` to store all the rows of Pascal's Triangle.

2. Iterate through each row from `0` to `numRows - 1`.

3. For every row, create a temporary list `temp`.

4. Traverse every position `j` in the current row.

   - If the current position is the **first** or **last** element of the row, add `1`.
   - Otherwise, compute the value using:
     ```java
     res.get(i - 1).get(j - 1) + res.get(i - 1).get(j)
     ```
   - Here:
     - `res.get(i - 1).get(j - 1)` is the element diagonally above-left.
     - `res.get(i - 1).get(j)` is the element directly above.
     - Their sum gives the current element.

5. After completing the row, add it to `res`.

6. Once all rows are generated, return `res`.

---

## Dry Run

Let's take:

```text
numRows = 5
```

Initially,

```text
res = []
```

### Row 0 (`i = 0`)

Only one position exists.

```text
temp = [1]

res =
[
 [1]
]
```

---

### Row 1 (`i = 1`)

Both positions are boundary elements.

```text
temp = [1, 1]

res =
[
 [1],
 [1,1]
]
```

---

### Row 2 (`i = 2`)

Previous row:

```text
[1,1]
```

Middle element:

```text
1 + 1 = 2
```

```text
temp = [1,2,1]

res =
[
 [1],
 [1,1],
 [1,2,1]
]
```

---

### Row 3 (`i = 3`)

Previous row:

```text
[1,2,1]
```

Middle elements:

```text
1 + 2 = 3
2 + 1 = 3
```

```text
temp = [1,3,3,1]

res =
[
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1]
]
```

---

### Row 4 (`i = 4`)

Previous row:

```text
[1,3,3,1]
```

Middle elements:

```text
1 + 3 = 4
3 + 3 = 6
3 + 1 = 4
```

```text
temp = [1,4,6,4,1]

res =
[
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
]
```

The final answer is:

```text
[
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
]
```

Thus, the first **5 rows** of Pascal's Triangle are generated successfully.

---

## Complexity Analysis

**Time Complexity:** `O(numRows²)`

- The first row has `1` element, the second has `2`, the third has `3`, and so on.
- The total number of elements generated is:

  ```text
  1 + 2 + 3 + ... + numRows
  ```

  which is `O(numRows²)`.

**Space Complexity:** `O(numRows²)`

- We store every element of Pascal's Triangle in the result list.
- Therefore, the total extra space required is proportional to the total number of generated elements.

---
