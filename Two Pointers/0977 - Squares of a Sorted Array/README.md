# [977. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

**Difficulty:** 🟢 Easy

## Problem

Given an integer array `nums` sorted in **non-decreasing order**, return an array containing the squares of each number, also sorted in non-decreasing order.

For example:

```text
nums = [-4, -1, 0, 3, 10]
```

The squared values are:

```text
[16, 1, 0, 9, 100]
```

After sorting:

```text
[0, 1, 9, 16, 100]
```

---

## Algorithm

This solution uses a **Two Pointer** approach.

Since the array is already sorted, the largest square will come from either:

```text
Leftmost negative number
OR
Rightmost positive number
```

We maintain two pointers:

```text
i → Start of the array
j → End of the array
```

We compare their absolute values and place the larger square at the **end** of the result array.

```text
Algorithm → Two Pointers
Pattern   → Sorted Array
```

---

## Intuition

Consider:

```text
-7  -3  2  3  11
 ↑              ↑
 i              j
```

Compare:

```text
abs(-7) = 7
abs(11) = 11
```

Since `11` has the larger absolute value:

```text
squares[k] = 121
```

Then move the right pointer:

```text
j--
```

We fill the result array from **right to left** because we always select the largest remaining square.

---

## Approach

1. Create an array to store the result:

   ```java
   int[] squares = new int[nums.length];
   ```

2. Initialize two pointers:

   ```java
   int i = 0;
   int j = nums.length - 1;
   ```

3. Start filling the result from the last position:

   ```java
   for(int k = nums.length - 1; k >= 0; k--)
   ```

4. Compare the absolute values at both pointers:

   ```java
   if(Math.abs(nums[i]) > Math.abs(nums[j]))
   ```

5. If the left value is larger, square it and move `i`:

   ```java
   squares[k] = nums[i] * nums[i];
   i++;
   ```

6. Otherwise, square the right value and move `j`:

   ```java
   squares[k] = nums[j] * nums[j];
   j--;
   ```

7. Continue until all positions are filled.

---

## Dry Run

Let's take:

```text
nums = [-4, -1, 0, 3, 10]
```

Initially:

```text
i = 0
j = 4
k = 4
```

Compare:

```text
abs(-4) = 4
abs(10) = 10
```

Take `10`:

```text
squares[4] = 100
j--
```

Next:

```text
-4  -1  0  3  10
 ↑           ↑
 i           j
```

Compare:

```text
abs(-4) = 4
abs(3) = 3
```

Take `-4`:

```text
squares[3] = 16
i++
```

Continue:

```text
squares = [0, 0, 0, 16, 100]
```

Eventually:

```text
squares = [0, 1, 9, 16, 100]
```

Final answer:

```text
[0, 1, 9, 16, 100]
```

---

## Why Fill From Right to Left?

The largest absolute value produces the largest square.

For example:

```text
[-7, -3, 2, 5]
```

The largest square must come from either:

```text
-7 → 49
5  → 25
```

So we place `49` at the last available position.

```text
squares[k] = 49
```

This allows us to construct the sorted result without using a sorting algorithm.

---

## Why This Works

Because `nums` is sorted:

```text
Negative values → Larger absolute values toward the left
Positive values → Larger values toward the right
```

Therefore, the largest remaining square is always at one of the two ends.

By comparing:

```java
Math.abs(nums[i])
Math.abs(nums[j])
```

we can select the largest square at every step.

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* Each element is processed exactly once.
* No sorting is required.

**Space Complexity:** `O(n)`

* The `squares` array stores the result.

---

## Key Takeaway

Use **two pointers** at both ends of the sorted array.

```text
        i               j
        ↓               ↓
[-4, -1, 0, 3, 10]
```

Compare absolute values:

```text
Larger absolute value
        ↓
Square it
        ↓
Place at the end
        ↓
Move that pointer
```

```text
Algorithm → Two Pointers
Pattern   → Sorted Array
Time      → O(n)
Space     → O(n)
```
