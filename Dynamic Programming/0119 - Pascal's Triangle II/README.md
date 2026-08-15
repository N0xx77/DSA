# [119. Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)

**Difficulty:** 🟢 Easy

## Problem

Given an integer `rowIndex`, return the `rowIndex`-th row of **Pascal's Triangle**.

In Pascal's Triangle:

* The first and last elements of every row are `1`.
* Every element between them is the sum of the two elements directly above it.

For example:

```text
        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1
```

Given:

```text
rowIndex = 3
```

Return:

```text
[1, 3, 3, 1]
```

---

## Algorithm

This solution uses **Dynamic Programming** with **in-place 1D array/list optimization**.

Instead of constructing the entire Pascal's Triangle, we only maintain the row that we are currently building.

The important part of the algorithm is iterating **backwards** through the list:

```java
for(int j = i - 1; j >= 1; j--){
    pascal.set(j, pascal.get(j) + pascal.get(j - 1));
}
```

This allows us to update the current row **in-place** without overwriting values that are still needed.

```text
Algorithm → Dynamic Programming
Approach  → Bottom-Up DP + In-Place 1D Optimization
Time      → O(rowIndex²)
Space     → O(rowIndex)
```

---

## Intuition

Each value in Pascal's Triangle is calculated using the two values above it:

```text
       1
      / \
     1   1

       2
      / \
     1   1
```

For example:

```text
1 3 3 1
```

The middle values are calculated as:

```text
3 = 1 + 2
3 = 2 + 1
```

Instead of storing every previous row, we can build the required row using a single list.

The key observation is that when calculating a new row, we only need the values from the previous row.

---

## Approach

1. Start with the first row:

   ```java
   List<Integer> pascal = new ArrayList<>();
   pascal.add(1);
   ```

   Initially:

   ```text
   pascal = [1]
   ```

2. Build each row from `1` to `rowIndex`:

   ```java
   for(int i = 1; i <= rowIndex; i++)
   ```

3. Update the existing values **from right to left**:

   ```java
   for(int j = i - 1; j >= 1; j--){
       pascal.set(j, pascal.get(j) + pascal.get(j - 1));
   }
   ```

4. Add the final `1` for the new row:

   ```java
   pascal.add(1);
   ```

5. After reaching `rowIndex`, return the list.

---

## Why Do We Iterate Backwards?

This is the most important part of the solution.

Suppose we have:

```text
pascal = [1, 3, 3, 1]
```

and want to generate the next row:

```text
[1, 4, 6, 4, 1]
```

We need:

```text
4 = 1 + 3
6 = 3 + 3
4 = 3 + 1
```

If we update from **left to right**, we would overwrite a value before it is used.

For example:

```text
[1, 3, 3, 1]
```

If we update index `1` first:

```text
pascal[1] = pascal[1] + pascal[0]
          = 3 + 1
          = 4
```

Now the list is:

```text
[1, 4, 3, 1]
```

If we then calculate index `2`, we would use:

```text
pascal[1] = 4
```

instead of the original value `3`.

That would give:

```text
4 + 3 = 7
```

which is incorrect.

Therefore, we update **from right to left**.

This ensures that `pascal[j - 1]` still contains its value from the previous row.

---

## Dry Run

Let's take:

```text
rowIndex = 4
```

We want:

```text
[1, 4, 6, 4, 1]
```

### Initial State

```text
pascal = [1]
```

---

### Row 1

There are no middle elements to update.

Add `1`:

```text
pascal = [1, 1]
```

---

### Row 2

Before updating:

```text
pascal = [1, 1]
```

The loop starts with:

```text
j = 1
```

Calculate:

```text
pascal[1] = pascal[1] + pascal[0]
          = 1 + 1
          = 2
```

Then add `1`:

```text
pascal = [1, 2, 1]
```

---

### Row 3

Before updating:

```text
pascal = [1, 2, 1]
```

Start from the right:

```text
j = 2
```

Calculate:

```text
pascal[2] = pascal[2] + pascal[1]
          = 1 + 2
          = 3
```

Now:

```text
[1, 2, 3]
```

Next:

```text
j = 1
```

Calculate:

```text
pascal[1] = pascal[1] + pascal[0]
          = 2 + 1
          = 3
```

Then add `1`:

```text
pascal = [1, 3, 3, 1]
```

---

### Row 4

Before updating:

```text
pascal = [1, 3, 3, 1]
```

Start from the right:

```text
j = 3
```

```text
pascal[3] = 1 + 3 = 4
```

```text
[1, 3, 3, 4]
```

Next:

```text
j = 2
```

```text
pascal[2] = 3 + 3 = 6
```

```text
[1, 3, 6, 4]
```

Next:

```text
j = 1
```

```text
pascal[1] = 3 + 1 = 4
```

```text
[1, 4, 6, 4]
```

Finally, add `1`:

```text
pascal = [1, 4, 6, 4, 1]
```

Therefore:

```text
[1, 4, 6, 4, 1]
```

is returned.

---

## DP State Transition

The core transition is:

```text
pascal[j] = pascal[j] + pascal[j - 1]
```

This is equivalent to the Pascal's Triangle formula:

```text
Current Value = Above Left + Above Right
```

Because we are using a 1D list, the two values are represented by:

```text
pascal[j]     → value directly above
pascal[j - 1] → value above-left
```

The update must happen from **right to left** so that both values still belong to the previous row when they are needed.

---

## Why Add `1` After the Inner Loop?

Every row of Pascal's Triangle starts and ends with `1`.

For example:

```text
[1]
[1, 1]
[1, 2, 1]
[1, 3, 3, 1]
```

The inner loop only calculates the **middle elements**.

Therefore, after updating those elements, we add the final `1`:

```java
pascal.add(1);
```

The first `1` is already present at index `0`.

---

## Complexity Analysis

**Time Complexity:** `O(rowIndex²)`

* For every row, we may update every element in that row.
* The total number of operations is approximately:

```text
1 + 2 + 3 + ... + rowIndex
```

which is `O(rowIndex²)`.

**Space Complexity:** `O(rowIndex)`

* We only store the current row.
* The list contains at most `rowIndex + 1` elements.

This is more space-efficient than constructing the entire Pascal's Triangle, which would require `O(rowIndex²)` space.

---

## Key Takeaway

The important idea is to build Pascal's Triangle **in-place using a 1D list**.

The transition is:

```java
pascal.set(j, pascal.get(j) + pascal.get(j - 1));
```

and the crucial detail is:

```java
for(int j = i - 1; j >= 1; j--)
```

We iterate **backwards** so that values from the previous row are not overwritten before they are used.

```text
Algorithm → Dynamic Programming
Pattern   → In-Place 1D DP
Time      → O(rowIndex²)
Space     → O(rowIndex)
```
