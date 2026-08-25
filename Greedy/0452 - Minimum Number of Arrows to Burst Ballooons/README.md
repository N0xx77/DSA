# [452. Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)

**Difficulty:** 🟡 Medium

## Problem

Given an array of balloon intervals `points`, where:

```text
[start, end]
```

represents the horizontal range of a balloon, find the **minimum number of arrows** required to burst all balloons.

An arrow shot at position `x` can burst every balloon where:

```text
start <= x <= end
```

For example:

```text
points = [[10,16], [2,8], [1,6], [7,12]]
```

One possible solution is:

```text
Arrow 1 → x = 6
Arrow 2 → x = 12
```

Therefore:

```text
2
```

---

## Algorithm

This solution uses a **Greedy** approach.

First, sort all balloons according to their **ending position**:

```java
Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
```

Shoot the first arrow at the end of the first balloon:

```text
x = points[0][1]
```

For every remaining balloon:

```text
If start <= x → Current arrow can burst it
If start > x  → Need a new arrow
```

```text
Algorithm → Greedy
Pattern   → Interval Scheduling
```

---

## Intuition

Consider:

```text
[1,6]   [2,8]   [7,12]   [10,16]
```

Shoot the first arrow at:

```text
x = 6
```

This bursts:

```text
[1,6]
[2,8]
```

The next balloon starts at:

```text
7
```

Since:

```text
7 > 6
```

the current arrow cannot burst it.

So we shoot another arrow at:

```text
x = 12
```

This arrow bursts:

```text
[7,12]
[10,16]
```

Therefore:

```text
Minimum arrows = 2
```

---

## Approach

1. Sort the balloons by their ending position:

   ```java
   Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
   ```

2. Initialize the number of arrows:

   ```java
   int res = 1;
   ```

3. Store the position of the first arrow:

   ```java
   int x = points[0][1];
   ```

4. Traverse the remaining balloons.

5. If the current balloon starts after the arrow position:

   ```java
   if(points[i][0] > x)
   ```

   a new arrow is needed:

   ```java
   x = points[i][1];
   res++;
   ```

6. Otherwise, the current arrow already bursts the balloon.

7. Return the total number of arrows.

---

## Dry Run

Let's take:

```text
points = [[10,16], [2,8], [1,6], [7,12]]
```

After sorting:

```text
[[1,6], [2,8], [7,12], [10,16]]
```

Initially:

```text
Arrow = 1
x = 6
```

### [2,8]

```text
2 <= 6
```

The arrow at `6` bursts this balloon.

### [7,12]

```text
7 > 6
```

A new arrow is needed:

```text
x = 12
Arrow = 2
```

### [10,16]

```text
10 <= 12
```

The arrow at `12` also bursts this balloon.

Final answer:

```text
2
```

---

## Why Sort by End Position?

Choosing the earliest ending position allows one arrow to potentially burst the maximum number of overlapping balloons.

For example:

```text
[1,6]   [2,8]
```

Shooting at:

```text
x = 6
```

bursts both balloons.

By always choosing the earliest possible ending position, we leave the maximum range for future balloons.

---

## Complexity Analysis

**Time Complexity:** `O(n log n)`

* Sorting takes `O(n log n)`.
* Traversing the array takes `O(n)`.
* Sorting dominates the overall complexity.

**Space Complexity:** `O(1)`

* Ignoring the space used by the sorting algorithm, only a few variables are used.

---

## Key Takeaway

Sort the intervals by their **ending position** and greedily place an arrow at the earliest possible end.

```text
Sort by End
     ↓
Shoot Arrow
     ↓
Check Next Balloon
     ↓
Overlap → Same Arrow
No Overlap → New Arrow
```

```text
Algorithm → Greedy
Pattern   → Interval Scheduling
Time      → O(n log n)
Space     → O(1)
```
