# [167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

**Difficulty:** 🟡 Medium

## Problem

Given an integer array `numbers` sorted in **non-decreasing order**, find two numbers that add up to a given `target`.

Return their **1-indexed positions**.

For example:

```text
numbers = [2, 7, 11, 15]
target = 9
```

The two numbers are:

```text
2 + 7 = 9
```

Since the answer must be **1-indexed**:

```text
[1, 2]
```

---

## Algorithm

This solution uses a **Two Pointer** approach.

Since the array is already sorted, we maintain two pointers:

```text
i → Start of the array
j → End of the array
```

We compare their sum with the target.

```text
If sum == target → Found the answer
If sum > target  → Move j left
If sum < target  → Move i right
```

```text
Algorithm → Two Pointers
Pattern   → Sorted Array
```

---

## Intuition

Consider:

```text
2   7   11   15
↑             ↑
i             j
```

Target:

```text
9
```

First:

```text
2 + 15 = 17
```

Since `17 > 9`, we need a smaller value:

```text
j--
```

Now:

```text
2   7   11   15
↑         ↑
i         j
```

Again:

```text
2 + 11 = 13
```

So:

```text
j--
```

Now:

```text
2   7   11   15
↑     ↑
i     j
```

```text
2 + 7 = 9
```

We found the answer.

---

## Approach

1. Create an array to store the result:

   ```java
   int[] res = new int[2];
   ```

2. Initialize two pointers:

   ```java
   int i = 0;
   int j = numbers.length - 1;
   ```

3. Compare the sum of the values at both pointers with the target.

4. If the sum equals the target, store the **1-indexed** positions:

   ```java
   res[0] = i + 1;
   res[1] = j + 1;
   ```

5. If the sum is greater than the target, move `j` left:

   ```java
   j--;
   ```

6. If the sum is smaller than the target, move `i` right:

   ```java
   i++;
   ```

7. Return the result.

---

## Dry Run

Let's take:

```text
numbers = [2, 7, 11, 15]
target = 9
```

Initially:

```text
i = 0
j = 3
```

Compare:

```text
2 + 15 = 17
```

Since:

```text
17 > 9
```

Move `j`:

```text
j--
```

Next:

```text
2 + 11 = 13
```

Again:

```text
13 > 9
```

Move `j`:

```text
j--
```

Now:

```text
2 + 7 = 9
```

Therefore:

```text
res[0] = 0 + 1 = 1
res[1] = 1 + 1 = 2
```

Final answer:

```text
[1, 2]
```

---

## Why This Works

Because the array is sorted:

```text
Smaller values ←────────→ Larger values
```

If the sum is too large, moving `j` left decreases the sum.

If the sum is too small, moving `i` right increases the sum.

Therefore, we can find the answer without checking every pair.

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* Each pointer moves through the array at most once.
* No sorting is required.

**Space Complexity:** `O(1)`

* Only two pointers are used.
* The result array contains only two elements.

---

## Key Takeaway

Use **two pointers** when working with a sorted array.

```text
        i             j
        ↓             ↓
[2, 7, 11, 15]
```

Compare the sum:

```text
sum > target
    ↓
j--

sum < target
    ↓
i++

sum == target
    ↓
Answer found
```

```text
Algorithm → Two Pointers
Pattern   → Sorted Array
Time      → O(n)
Space     → O(1)
```
