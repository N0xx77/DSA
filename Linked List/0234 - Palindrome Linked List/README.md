# [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

**Difficulty:** 🟢 Easy

## Problem

Given the head of a singly linked list, determine whether the linked list is a **palindrome**.

A palindrome reads the same forward and backward.

## Algorithm

**Two Pointers + Linked List Reversal**

## Intuition

A linked list cannot be traversed backward directly.

So we:

1. Use **fast and slow pointers** to find the middle of the list.
2. Reverse the second half of the linked list.
3. Compare the first half with the reversed second half.

If every corresponding value is equal, the linked list is a palindrome.

## Approach

### 1. Find the Middle

Use two pointers:

* `slow` moves one step at a time.
* `fast` moves two steps at a time.

When `fast` reaches the end, `slow` is at the middle.

```text
1 → 2 → 3 → 2 → 1
        ↑
       slow
```

### 2. Reverse the Second Half

Starting from `slow`, reverse the remaining part of the list.

```text
Before:
1 → 2 → 3 ← 2 ← 1

After:
1 → 2 → 3    1 → 2
             ↑
            prev
```

### 3. Compare Both Halves

Set:

```text
fast = prev
slow = head
```

Then compare the values of both lists.

If any values differ, return `false`.

Otherwise, return `true`.

## Dry Run

For:

```text
1 → 2 → 3 → 2 → 1
```

### Find Middle

After the first loop:

```text
slow → 3
```

### Reverse Second Half

The second half:

```text
3 → 2 → 1
```

becomes:

```text
1 → 2 → 3
```

### Compare

```text
Original:  1 → 2 → 3
Reversed:  1 → 2 → 3
           ↑   ↑   ↑
          same
```

All values match, so:

```text
return true
```

## Why This Works

The first half is compared with the **reversed second half**.

For a palindrome, both halves must contain the same values in the same order after reversing the second half.

The fast and slow pointers find the middle in `O(n)` time, while reversing and comparing also take `O(n)` time.

## Complexity Analysis

### Time Complexity

Finding the middle, reversing the list, and comparing the halves each take `O(n)`:

```text
O(n)
```

### Space Complexity

Only a few pointers are used, without creating another list:

```text
O(1)
```

## Key Takeaway

> **Find Middle → Reverse Second Half → Compare Both Halves**

```text
Algorithm → Two Pointers + Linked List Reversal
Pattern   → Fast & Slow Pointers
Time      → O(n)
Space     → O(1)
```
