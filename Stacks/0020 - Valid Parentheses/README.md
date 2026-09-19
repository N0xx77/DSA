# [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

**Difficulty:** 🟢 Easy

## Problem

Given a string `s` containing only the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`, determine if the input string is valid.

A string is valid if:

* Every opening bracket has a corresponding closing bracket.
* Brackets are closed in the correct order.
* Every closing bracket matches the most recent opening bracket.

## Algorithm

Use a **Stack** to keep track of opening brackets.

A `HashMap` is used to store the matching opening bracket for every closing bracket:

```text
')' → '('
']' → '['
'}' → '{'
```

For every character:

* If it is a closing bracket and matches the top of the stack, pop the stack.
* Otherwise, push the character onto the stack.

At the end, the string is valid only if the stack is empty.

## Approach

1. Create a `HashMap` containing closing brackets and their corresponding opening brackets.
2. Create a stack to store brackets.
3. Traverse the string character by character.
4. If the stack is not empty and the current closing bracket matches `st.peek()`, pop the stack.
5. Otherwise, push the current character onto the stack.
6. After processing the entire string:

   * Empty stack → valid.
   * Non-empty stack → invalid.

### Example

For:

```text
s = "({[]})"
```

The stack changes as follows:

```text
(       → [(]
{       → [(, {]
[       → [(, {, []
]       → [(, {]
}       → [(]
)       → []
```

The stack is empty, so the string is **valid**.

For:

```text
s = "([)]"
```

When `)` is encountered, the top of the stack is `[` instead of `(`, so the brackets do not match.

## Java Solution

```java
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && map.get(c) == st.peek()){
                st.pop();
            }
            else{
                st.push(c);
            }
        }

        return st.size() > 0 ? false : true;
    }
}
```

## Complexity Analysis

* **Time:** `O(n)` — Each character is processed once.
* **Space:** `O(n)` — The stack and hashmap store brackets.

## Key Takeaway

Use a **Stack** because brackets must be matched in **LIFO order**. The most recently opened bracket must always be the first one closed.

```text
Algorithm → Stack + HashMap
Pattern   → LIFO / Matching Brackets
Time      → O(n)
Space     → O(n)
```
