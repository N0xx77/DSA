# [219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)

**Difficulty:** 🟢 Easy

## Problem

Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices:

```text
i and j
```

such that:

```text
nums[i] == nums[j]
```

and:

```text
abs(i - j) <= k
```

Otherwise, return `false`.

For example:

```text
nums = [1, 2, 3, 1]
k = 3
```

The two `1`s are at indices:

```text
0 and 3
```

Their distance is:

```text
3 - 0 = 3
```

Since:

```text
3 <= k
```

the answer is:

```text
true
```

---

## Algorithm

This solution uses a **HashSet + Sliding Window** approach.

The `HashSet` stores only the elements within a window of size `k`.

```text
Set → Stores recent elements
Window → Contains at most k previous elements
```

For every element:

```text
If already in Set → Duplicate found
Otherwise → Add it to the Set
```

If the window becomes larger than `k`, remove the oldest element.

```text
Algorithm → HashSet + Sliding Window
Pattern   → Duplicate Detection
```

---

## Intuition

Consider:

```text
nums = [1, 2, 3, 1]
k = 3
```

Initially:

```text
Set = {}
```

Add `1`:

```text
Set = {1}
```

Add `2`:

```text
Set = {1, 2}
```

Add `3`:

```text
Set = {1, 2, 3}
```

Now we encounter `1` again.

Since `1` already exists in the set:

```text
Duplicate found
```

Therefore:

```text
true
```

---

## Approach

1. Create a `HashSet`:

   ```java
   Set<Integer> s = new HashSet<>();
   ```

2. Traverse the array.

3. If the window size exceeds `k`, remove the oldest element:

   ```java
   if(i > k){
       s.remove(nums[i - k - 1]);
   }
   ```

4. Try to add the current element:

   ```java
   if(!s.add(nums[i])){
       return true;
   }
   ```

5. If `add()` returns `false`, the element already exists in the current window.

6. If no valid duplicate is found, return:

   ```java
   false
   ```

---

## Dry Run

Let's take:

```text
nums = [1, 2, 3, 1]
k = 3
```

### i = 0

```text
Set = {}
```

Add `1`:

```text
Set = {1}
```

### i = 1

Add `2`:

```text
Set = {1, 2}
```

### i = 2

Add `3`:

```text
Set = {1, 2, 3}
```

### i = 3

Current number:

```text
1
```

Since `1` is already in the set:

```text
!s.add(1) → true
```

Therefore, return:

```text
true
```

---

## Why This Works

The `HashSet` contains only numbers whose indices are within distance `k` of the current index.

Before processing `nums[i]`, elements that are more than `k` positions behind are removed:

```text
i - k - 1
```

Therefore, if the current number already exists in the set, there must be another occurrence within distance `k`.

```text
Duplicate in current window
        ↓
Distance <= k
        ↓
Return true
```

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* Each element is added to the `HashSet` once.
* Each element is removed at most once.
* HashSet operations take `O(1)` on average.

**Space Complexity:** `O(k)`

* The `HashSet` stores at most `k + 1` elements.
* Therefore, the space used depends on the window size.

---

## Key Takeaway

Use a **HashSet** with a **Sliding Window** when you need to check for duplicates within a limited distance.

```text
Add current element
        ↓
Already exists?
    ↙       ↘
  Yes        No
   ↓          ↓
Return true  Continue
```

```text
Algorithm → HashSet + Sliding Window
Time      → O(n)
Space     → O(k)
```
