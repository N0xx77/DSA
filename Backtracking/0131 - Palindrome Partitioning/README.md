# [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

**Difficulty:** 🟡 Medium

## Problem

Given a string `s`, partition it such that **every substring in the partition is a palindrome**.

Return all possible palindrome partitionings of `s`.

## Algorithm

**Backtracking**

## Intuition

At each position, we try every possible substring starting from that position.

If the substring is a **palindrome**, we add it to the current partition and recursively partition the remaining string.

After exploring that choice, we remove the substring and try the next possibility.

## Approach

1. Start from `index = 0` with an empty `temp` list.
2. Try every substring from `index` to `i`.
3. Check whether the substring is a palindrome.
4. If it is, add it to `temp`.
5. Recursively partition the remaining string starting at `i + 1`.
6. Remove the last substring to **backtrack**.
7. When `index` reaches the end of the string, add the partition to `res`.

```text
s = "aab"

                 ""
              /   |   \
            "a"  "aa"  "aab"
           /       \
         "a"       "b"
         |
        "b"

Result:
["a","a","b"]
["aa","b"]
```

## Dry Run

For:

```text
s = "aab"
```

Start with:

```text
temp = []
index = 0
```

Choose `"a"`:

```text
temp = ["a"]
```

Choose another `"a"`:

```text
temp = ["a","a"]
```

Then choose `"b"`:

```text
temp = ["a","a","b"]
```

We reached the end, so add the partition.

Backtrack and try `"aa"` instead:

```text
temp = ["aa"]
```

Then choose `"b"`:

```text
temp = ["aa","b"]
```

Final result:

```text
[
    ["a","a","b"],
    ["aa","b"]
]
```

## Why This Works

The algorithm only adds a substring when `isPalindrome()` confirms that it is a palindrome.

Backtracking allows every possible valid partition to be explored without keeping invalid choices.

When the index reaches the end of the string, every substring in `temp` is guaranteed to be a palindrome.

## Complexity Analysis

### Time Complexity

There can be up to `2^(n-1)` possible partitions, and checking whether substrings are palindromes can take `O(n)`.

```text
O(n × 2^n)
```

### Space Complexity

The recursion depth and current partition require:

```text
O(n)
```

excluding the output.

## Key Takeaway

> **Backtracking → Choose a substring → Check palindrome → Explore → Undo**

```text
Algorithm → Backtracking
Pattern   → Palindrome Partitioning
Time      → O(n × 2^n)
Space     → O(n)  [excluding output]
```
