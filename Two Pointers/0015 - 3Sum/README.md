# [15. 3Sum](https://leetcode.com/problems/3sum/)

**Difficulty:** 🟡 Medium

## Problem

Given an integer array `nums`, return all unique triplets:

```text
[a, b, c]
```

such that:

```text
a + b + c = 0
```

The solution must not contain duplicate triplets.

For example:

```text
nums = [-1, 0, 1, 2, -1, -4]
```

The valid triplets are:

```text
[-1, -1, 2]
[-1, 0, 1]
```

---

## Algorithm

This solution uses **Sorting + Two Pointers**.

First, sort the array:

```text
[-4, -1, -1, 0, 1, 2]
```

For every element `nums[i]`, use two pointers:

```text
x → i + 1
y → End of the array
```

We calculate:

```text
nums[i] + nums[x] + nums[y]
```

```text
If sum == 0 → Store the triplet
If sum > 0  → Move y left
If sum < 0  → Move x right
```

```text
Algorithm → Sorting + Two Pointers
Pattern   → Array / Two Pointers
```

---

## Intuition

Consider:

```text
[-4, -1, -1, 0, 1, 2]
```

Take:

```text
i = 1
nums[i] = -1
```

Now:

```text
       x           y
       ↓           ↓
[-4, -1, -1, 0, 1, 2]
     -1
```

Calculate:

```text
-1 + (-1) + 2 = 0
```

So we add:

```text
[-1, -1, 2]
```

Move `x` forward and continue searching for other combinations.

---

## Approach

1. Sort the array:

   ```java
   Arrays.sort(nums);
   ```

2. Iterate through each element as the first number:

   ```java
   for(int i = 0; i < nums.length; i++)
   ```

3. Skip duplicate first elements:

   ```java
   if(i > 0 && nums[i] == nums[i-1]) continue;
   ```

4. Initialize two pointers:

   ```java
   int x = i + 1;
   int y = nums.length - 1;
   ```

5. Calculate the current sum:

   ```java
   int currentSum = nums[x] + nums[y] + z;
   ```

6. If the sum is `0`, add the triplet and move `x` forward.

7. If the sum is greater than `0`, move `y` left.

8. If the sum is less than `0`, move `x` right.

9. Skip duplicate values after finding a valid triplet.

---

## Dry Run

Let's take:

```text
nums = [-1, 0, 1, 2, -1, -4]
```

After sorting:

```text
[-4, -1, -1, 0, 1, 2]
```

For:

```text
i = 1
z = -1
```

Start:

```text
       x              y
       ↓              ↓
[-4, -1, -1, 0, 1, 2]
```

Calculate:

```text
-1 + (-1) + 2 = 0
```

Add:

```text
[-1, -1, 2]
```

Continue moving `x`:

```text
-1 + 0 + 2 = 1
```

Since:

```text
1 > 0
```

Move `y` left:

```text
-1 + 0 + 1 = 0
```

Add:

```text
[-1, 0, 1]
```

Final result:

```text
[[-1, -1, 2], [-1, 0, 1]]
```

---

## Handling Duplicates

Duplicates are skipped in two places.

For the first element:

```java
if(i > 0 && nums[i] == nums[i-1]) continue;
```

After finding a triplet:

```java
while(x < y && nums[x] == nums[x-1]){
    x++;
}
```

This ensures that the result contains only **unique triplets**.

---

## Complexity Analysis

**Time Complexity:** `O(n²)`

* Sorting takes `O(n log n)`.
* The two-pointer search takes `O(n²)`.
* Therefore, the overall complexity is `O(n²)`.

**Space Complexity:** `O(1)`

* Ignoring the output list, only a few variables are used.

---

## Key Takeaway

For **3Sum**, fix one element and use **two pointers** to find the remaining two.

```text
nums[i] + nums[x] + nums[y]
          ↓
       Compare
          ↓
sum > 0 → y--
sum < 0 → x++
sum = 0 → Store triplet
```

Always sort the array first to make the two-pointer approach and duplicate handling possible.

```text
Algorithm → Sorting + Two Pointers
Time      → O(n²)
Space     → O(1)
```
