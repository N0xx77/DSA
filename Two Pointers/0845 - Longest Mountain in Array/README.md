# [845. Longest Mountain in Array](https://leetcode.com/problems/longest-mountain-in-array/)

**Difficulty:** 🟡 Medium

## Problem

Given an integer array `arr`, find the length of the longest **mountain**.

A mountain must have:

```text
Strictly increasing values
        ↑
       Peak
        ↓
Strictly decreasing values
```

For example:

```text
arr = [2, 1, 4, 7, 3, 2, 5]
```

The longest mountain is:

```text
[1, 4, 7, 3, 2]
```

So the answer is:

```text
5
```

---

## Algorithm

This solution checks every element to see if it can be the **peak of a mountain**.

A valid peak must satisfy:

```java
arr[i] > arr[i - 1] && arr[i] > arr[i + 1]
```

Once a peak is found:

```text
Move left  → Find where the increasing sequence starts
Move right → Find where the decreasing sequence ends
```

The mountain length is then:

```text
right - left + 1
```

```text
Algorithm → Peak Detection + Expansion
Pattern   → Array Traversal
```

---

## Intuition

Consider:

```text
2   1   4   7   3   2   5
        ↑
        Peak
```

At:

```text
arr[i] = 7
```

We expand to the left while the sequence is increasing:

```text
1 < 4 < 7
```

Then expand to the right while the sequence is decreasing:

```text
7 > 3 > 2
```

This gives the mountain:

```text
[1, 4, 7, 3, 2]
```

---

## Approach

1. If the array has fewer than `3` elements, return `0`.

   ```java
   if(arr.length < 3) return 0;
   ```

2. Traverse the array and check for a valid peak:

   ```java
   if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
   ```

3. If a peak is found, expand left:

   ```java
   while(left > 0 && arr[left] > arr[left-1]){
       left--;
   }
   ```

4. Expand right:

   ```java
   while(right < arr.length-1 && arr[right] > arr[right+1]){
       right++;
   }
   ```

5. Calculate the mountain length:

   ```java
   tempCount = right - left + 1;
   ```

6. Update the longest mountain found.

---

## Dry Run

Let's take:

```text
arr = [2, 1, 4, 7, 3, 2, 5]
```

The peak is:

```text
2   1   4   7   3   2   5
            ↑
            i
```

Expand left:

```text
1 < 4 < 7
↑
left
```

Expand right:

```text
7 > 3 > 2
        ↑
      right
```

The mountain is:

```text
[1, 4, 7, 3, 2]
```

Calculate:

```text
right - left + 1

5 - 1 + 1 = 5
```

Final answer:

```text
5
```

---

## Why This Works

A mountain must have exactly:

```text
Increasing → Peak → Decreasing
```

By checking every possible peak and expanding in both directions, we can find the complete mountain containing that peak.

The longest valid mountain is stored in:

```java
mountain
```

---

## Complexity Analysis

**Time Complexity:** `O(n²)`

* In the worst case, expanding left and right for multiple peaks can revisit elements.
* Therefore, the worst-case time complexity is `O(n²)`.

**Space Complexity:** `O(1)`

* Only a few variables are used.
* No additional data structures are required.

---

## Key Takeaway

Find a valid **peak**, then expand in both directions.

```text
Increasing
    ↓
Find Peak
    ↓
Expand Left and Right
    ↓
Calculate Mountain Length
    ↓
Store Maximum
```

```text
Algorithm → Peak Detection + Expansion
Time      → O(n²)
Space     → O(1)
```
