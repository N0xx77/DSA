# [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

**Difficulty:** 🟢 Easy

## Problem

You are given two sorted arrays `nums1` and `nums2`.

* `nums1` has enough space to hold all elements.
* The first `m` elements of `nums1` are valid.
* `nums2` contains `n` valid elements.

Merge `nums2` into `nums1` so that the final array is sorted.

## Algorithm

Use **three pointers** starting from the end:

* `i` → Last valid element in `nums1`
* `j` → Last element in `nums2`
* `k` → Last position in `nums1`

Compare `nums1[i]` and `nums2[j]` and place the larger element at `nums1[k]`.

Since we are filling from the back, existing elements in `nums1` are not overwritten.

## Approach

1. Set `i = m - 1`.
2. Set `j = n - 1`.
3. Set `k = m + n - 1`.
4. While `j >= 0`:

   * If `nums1[i] > nums2[j]`, place `nums1[i]` at `nums1[k]`.
   * Otherwise, place `nums2[j]` at `nums1[k]`.
   * Move the corresponding pointer backwards.
5. Continue until all elements from `nums2` have been placed.

### Example

```text
nums1 = [1,2,3,0,0,0]
nums2 = [2,5,6]
```

Start:

```text
i = 2, j = 2, k = 5

[1,2,3,0,0,0]
       ↑     ↑
       i     k

nums2:
      ↑
      j
```

Compare `3` and `6` → place `6`.

```text
[1,2,3,0,0,6]
```

Then compare `3` and `5` → place `5`.

```text
[1,2,3,0,5,6]
```

Then compare `3` and `2` → place `3`.

Continue until:

```text
[1,2,2,3,5,6]
```

## Java Solution

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = n+m-1;

        while(j >= 0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else nums1[k--] = nums2[j--];
        }
    }
}
```

## Complexity Analysis

* **Time:** `O(m + n)` — Each element is processed at most once.
* **Space:** `O(1)` — The merge is performed in-place.

## Key Takeaway

When merging into an array that already contains elements, **start from the end**. Placing the largest elements first prevents overwriting the unprocessed elements in `nums1`.

```text
Algorithm → Three Pointers
Pattern   → Two Pointers / In-Place Merge
Time      → O(m + n)
Space     → O(1)
```
