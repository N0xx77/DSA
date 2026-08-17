# [1266. Minimum Time Visiting All Points](https://leetcode.com/problems/minimum-time-visiting-all-points/)

**Difficulty:** 🟢 Easy

## Problem

On a 2D plane, you are given an array of points where:

```text
points[i] = [xi, yi]
```

represents the coordinates of the `i`-th point.

Starting from the first point, you must visit all points **in the given order**.

In one second, you can move:

* Horizontally by 1 unit
* Vertically by 1 unit
* Diagonally by 1 unit

Return the **minimum time** required to visit all the points.

---

## Algorithm

This solution uses a **Greedy approach** based on **Chebyshev Distance**.

For two points:

```text
(x1, y1)
(x2, y2)
```

the minimum time required to travel between them is:

```text
max(|x2 - x1|, |y2 - y1|)
```

Therefore, we calculate the distance between every pair of consecutive points and add them together.

```text
Algorithm → Greedy
Distance  → Chebyshev Distance
```

---

## Intuition

Suppose we need to move from:

```text
(1, 1) → (4, 3)
```

The difference is:

```text
Δx = |4 - 1| = 3
Δy = |3 - 1| = 2
```

Since diagonal movement can increase both `x` and `y` at the same time, we can make:

```text
2 diagonal moves
1 horizontal move
```

So the total time is:

```text
2 + 1 = 3
```

This is equal to:

```text
max(3, 2) = 3
```

Therefore, the minimum time between two points is:

```text
max(|x2 - x1|, |y2 - y1|)
```

---

## Approach

1. Initialize the total time:

   ```java
   int time = 0;
   ```

2. Store the coordinates of the first point:

   ```java
   int prevX = points[0][0];
   int prevY = points[0][1];
   ```

3. Traverse the remaining points:

   ```java
   for (int i = 1; i < points.length; i++)
   ```

4. Get the current point:

   ```java
   int x = points[i][0];
   int y = points[i][1];
   ```

5. Calculate the horizontal and vertical distance:

   ```text
   |x - prevX|
   |y - prevY|
   ```

6. The minimum time between the two points is the larger of these two distances:

   ```java
   time += Math.max(
       Math.abs(x - prevX),
       Math.abs(y - prevY)
   );
   ```

7. Make the current point the previous point for the next iteration:

   ```java
   prevX = x;
   prevY = y;
   ```

8. Return the total time:

   ```java
   return time;
   ```

---

## Dry Run

Let's take:

```text
points = [[1,1], [3,4], [-1,0]]
```

Initially:

```text
time = 0

prevX = 1
prevY = 1
```

### Point 1 → Point 2

Move from:

```text
(1, 1) → (3, 4)
```

Calculate:

```text
Δx = |3 - 1| = 2
Δy = |4 - 1| = 3
```

Minimum time:

```text
max(2, 3) = 3
```

So:

```text
time = 3
```

Update:

```text
prevX = 3
prevY = 4
```

---

### Point 2 → Point 3

Move from:

```text
(3, 4) → (-1, 0)
```

Calculate:

```text
Δx = |-1 - 3| = 4
Δy = |0 - 4| = 4
```

Minimum time:

```text
max(4, 4) = 4
```

So:

```text
time = 3 + 4 = 7
```

Final result:

```text
7
```

Therefore, the minimum time required to visit all points is:

```text
7
```

---

## Why `Math.max()`?

The key observation is that **diagonal movement can cover one unit in both directions simultaneously**.

For example:

```text
Δx = 5
Δy = 3
```

We can make:

```text
3 diagonal moves → covers 3 in x and 3 in y
2 horizontal moves → covers remaining 2 in x
```

Total:

```text
3 + 2 = 5
```

Which is:

```text
max(5, 3) = 5
```

Similarly, if:

```text
Δx = 2
Δy = 6
```

we need:

```text
2 diagonal moves
4 vertical moves
```

Total:

```text
6
```

Again:

```text
max(2, 6) = 6
```

Therefore:

```text
Minimum Time = max(Δx, Δy)
```

---

## Why Is This Greedy?

For each pair of consecutive points, we immediately choose the most efficient movement:

1. Move diagonally while both coordinates still need to change.
2. Move horizontally or vertically for the remaining distance.

There is no reason to take a longer route because the points must be visited in a fixed order.

Therefore, finding the minimum distance between each consecutive pair independently gives the global minimum.

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* We visit each point exactly once.

**Space Complexity:** `O(1)`

* We only store the coordinates of the previous point and the total time.
* No additional array or data structure is required.

---

## Key Takeaway

The important formula is:

```text
Distance between two points
= max(|x2 - x1|, |y2 - y1|)
```

Because diagonal movement can change both coordinates simultaneously, the larger coordinate difference determines the minimum number of moves.

```text
Algorithm → Greedy
Distance  → Chebyshev Distance
Time      → O(n)
Space     → O(1)
```
