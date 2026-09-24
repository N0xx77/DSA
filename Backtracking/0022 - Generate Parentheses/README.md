# [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

**Difficulty:** 🟡 Medium

## Problem

Given `n` pairs of parentheses, generate all combinations of **well-formed parentheses**.

For example, for `n = 3`:

```text
["((()))","(()())","(())()","()(())","()()()"]
```

## Algorithm

Use **Backtracking** to build the string one character at a time.

Keep track of:

* `idx1` → Number of opening parentheses used.
* `idx2` → Number of closing parentheses used.

At each step:

* Add `(` if `idx1 < n`.
* Add `)` only if `idx2 < idx1`, ensuring the string remains valid.

When the string length becomes `2 × n`, add it to the result.

## Approach

1. Start with an empty string.
2. If fewer than `n` opening parentheses have been used, add `(`.
3. If the number of closing parentheses is less than the number of opening parentheses, add `)`.
4. Recursively continue building the string.
5. When the length reaches `2n`, add the valid combination to `res`.
6. Backtracking naturally explores all possible valid combinations.

### Example

For `n = 2`:

```text
                    ""
                   /  \
                 "("
                /   \
             "(("   "()"
              |       |
            "(()"    "()("
              |        |
           "(())"    "()()"
```

Result:

```text
["(())", "()()"]
```

The condition:

```java
if(idx2 < idx1)
```

prevents adding a closing parenthesis when there is no unmatched opening parenthesis.

## Java Solution

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new String(), n, 0, 0);
        return res;

    }

    void backtrack(List<String> res, String temp, int n, int idx1, int idx2){
        if(temp.length() == n*2) {
            res.add(temp);
        }

        if(idx1 < n){
            backtrack(res, temp+"(", n, idx1+1, idx2);
        }
        if(idx2 < idx1){
            backtrack(res,temp+")", n, idx1, idx2+1);
        }
    }
}
```

## Complexity Analysis

There are **Catalan number** `Cₙ` valid combinations.

* **Time:** `O(Cₙ × n)` — Each valid combination contains `2n` characters.
* **Space:** `O(n)` — Recursion depth is at most `2n`, excluding the output.

## Key Takeaway

Backtracking works by trying both choices while maintaining a condition that guarantees validity.

```text
Algorithm → Backtracking
Pattern   → Choose "(" or ")" with Validity Condition
Time      → O(Cₙ × n)
Space     → O(n) excluding output
```
