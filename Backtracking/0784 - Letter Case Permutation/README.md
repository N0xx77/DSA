# [784. Letter Case Permutation](https://leetcode.com/problems/letter-case-permutation/)

**Difficulty:** 🟡 Medium

## Problem

Given a string `s`, return all possible strings that can be formed by changing the **case of its letters**.

Digits remain unchanged.

For example:

```text
s = "a1b2"
```

The possible permutations are:

```text
["a1b2", "a1B2", "A1b2", "A1B2"]
```

---

## Algorithm

This solution uses **Backtracking**.

At each character, we have two choices:

```text
Letter → Uppercase OR Lowercase
Digit  → Keep unchanged
```

We recursively explore both possibilities for every letter.

```text
Algorithm → Backtracking
Pattern   → Decision Tree
```

---

## Intuition

Consider:

```text
s = "a1b"
```

For `a`, we have two choices:

```text
       a
      / \
     A   a
```

The digit `1` has only one choice:

```text
       1
       |
       1
```

For `b`, we again have two choices:

```text
        b
       / \
      B   b
```

This produces:

```text
A1B
A1b
a1B
a1b
```

---

## Approach

1. Convert the string into a character array:

   ```java
   s.toCharArray();
   ```

2. Start the backtracking process from index `0`:

   ```java
   backtrack(ans, 0, s.toCharArray());
   ```

3. If the current character is a digit, move to the next character:

   ```java
   if(Character.isDigit(S[i])){
       backtrack(ans, i + 1, S);
   }
   ```

4. If it is a letter, try uppercase:

   ```java
   S[i] = Character.toUpperCase(S[i]);
   backtrack(ans, i + 1, S);
   ```

5. Then try lowercase:

   ```java
   S[i] = Character.toLowerCase(S[i]);
   backtrack(ans, i + 1, S);
   ```

6. When all characters have been processed, add the current string to the result:

   ```java
   if(i == S.length)
       ans.add(new String(S));
   ```

---

## Dry Run

Let's take:

```text
s = "a1b"
```

The decision tree is:

```text
          a
        /   \
       A     a
       |     |
       1     1
      / \   / \
     B   b B   b
```

The results are:

```text
["A1B", "A1b", "a1B", "a1b"]
```

Final answer:

```text
["A1B", "A1b", "a1B", "a1b"]
```

---

## Why This Works

Every letter has exactly two possible states:

```text
Uppercase
Lowercase
```

Backtracking explores both choices.

Digits do not have multiple choices, so they are simply skipped.

For a string containing `k` letters, there are:

```text
2^k
```

possible permutations.

---

## Complexity Analysis

**Time Complexity:** `O(n × 2^n)`

* There can be up to `2^n` permutations.
* Creating each string takes `O(n)`.

**Space Complexity:** `O(n)`

* `O(n)` recursion depth.
* Ignoring the output list.

---

## Key Takeaway

Use **Backtracking** when each element has multiple choices and you need to generate **all possible combinations**.

```text
Character
    ↓
Is it a digit?
    ↓
Yes → Keep it unchanged
    ↓
No
    ↓
Uppercase ──→ Backtrack
Lowercase ──→ Backtrack
```

```text
Algorithm → Backtracking
Pattern   → Decision Tree
Time      → O(n × 2^n)
Space     → O(n)
```
