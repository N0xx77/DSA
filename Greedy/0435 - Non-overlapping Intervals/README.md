# [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)

**Difficulty:** 🟡 Medium

## Problem

Given an array of intervals, find the minimum number of intervals that need to be removed so that the remaining intervals do not overlap.

For example:

```text
intervals = [[1,2], [2,3], [3,4], [1,3]]
```

The interval:

```text
[1,3]
```

overlaps with other intervals, so we remove it.

The remaining intervals are:

```text
[[1,2], [2,3], [3,4]]
```

Therefore, the answer is:

```text
1
```

---

## Algorithm

This solution uses a **Greedy** approach.

First, sort the intervals according to their **ending time**:

```java
Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
```

Then keep track of the end time of the last selected interval.

```text
If current start >= previous end → Keep interval
If current start < previous end  → Overlap → Remove interval
```

```text
Algorithm → Greedy
Pattern   → Interval Scheduling
```

---

## Intuition

Consider:

```text
[1,2]   [2,3]   [3,4]   [1,3]
```

After sorting by end time:

```text
[1,2]   [2,3]   [1,3]   [3,4]
```

Start with:

```text
time = -∞
remove = 0
```

### [1,2]

```text
1 >= -∞
```

No overlap, so keep it:

```text
time = 2
```

### [2,3]

```text
2 >= 2
```

No overlap, so keep it:

```text
time = 3
```

### [1,3]

```text
1 < 3
```

It overlaps, so remove it:

```text
remove++
```

### [3,4]

```text
3 >= 3
```

No overlap, so keep it:

```text
time = 4
```

Final answer:

```text
1
```

---

## Approach

1. Sort the intervals by their ending time:

   ```java
   Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
   ```

2. Initialize:

   ```java
   int remove = 0;
   int time = Integer.MIN_VALUE;
   ```

3. Traverse all intervals.

4. If the current interval does not overlap:

   ```java
   intervals[i][0] >= time
   ```

   Keep the interval and update:

   ```java
   time = intervals[i][1];
   ```

5. Otherwise, the interval overlaps:

   ```java
   remove++;
   ```

6. Return the number of removed intervals.

---

## Why Sort by End Time?

Choosing the interval that finishes earliest leaves the maximum space for future intervals.

For example:

```text
[1,2]   [1,5]
```

Choosing:

```text
[1,2]
```

is better because it finishes earlier and allows more intervals to be selected afterward.

This is why sorting by ending time gives the optimal greedy solution.

---

## Complexity Analysis

**Time Complexity:** `O(n log n)`

* Sorting the intervals takes `O(n log n)`.
* Traversing the intervals takes `O(n)`.
* Sorting dominates the overall complexity.

**Space Complexity:** `O(1)`

* Ignoring the space used by the sorting algorithm, only a few variables are used.

---

## Key Takeaway

For interval overlap problems, sort intervals by their **ending time**.

```text
Sort by End Time
       ↓
Check for Overlap
       ↓
No Overlap → Keep
Overlap    → Remove
```

```text
Algorithm → Greedy
Pattern   → Interval Scheduling
Time      → O(n log n)
Space     → O(1)
```
