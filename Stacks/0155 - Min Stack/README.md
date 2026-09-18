# Min Stack

**Problem:** [155. Min Stack](https://leetcode.com/problems/min-stack/)

**Difficulty:** 🟡 Medium

## Problem

Design a stack that supports the following operations in **`O(1)`** time:

* `push(value)` — Push an element onto the stack.
* `pop()` — Remove the top element.
* `top()` — Return the top element.
* `getMin()` — Return the minimum element in the stack.

## Algorithm

Use a **Linked List** where every node stores:

* `val` → Value of the node.
* `min` → Minimum value from this node to the bottom of the stack.
* `next` → Reference to the next node.

When pushing a new value:

```text
min = min(value, current minimum)
```

This allows `getMin()` to directly return the minimum stored in the top node.

## Approach

1. If the stack is empty, create the first node with `min = value`.
2. Otherwise, create a new node at the top.
3. Store the minimum of the new value and the previous minimum:

   ```text
   Math.min(value, head.min)
   ```
4. For `pop()`, simply move `head` to `head.next`.
5. `top()` returns `head.val`.
6. `getMin()` returns `head.min`.

### Example

For:

```text
push(5)
push(3)
push(7)
push(2)
```

The stack becomes:

```text
Value     Min
  2        2
  7        2
  3        3
  5        5
```

So:

```text
top()    → 2
getMin() → 2
```

After `pop()`:

```text
Value     Min
  7        2
  3        3
  5        5
```

Now:

```text
top()    → 7
getMin() → 3
```

## Java Solution

```java
class MinStack {
    private Node head;

    public void push(int value) {
        if(head == null){
            head = new Node(value, value, null);
        }
        else head = new Node(value, Math.min(value, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min; 
    }

    private class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
```

## Complexity Analysis

| Operation  | Time   | Space  |
| ---------- | ------ | ------ |
| `push()`   | `O(1)` | `O(1)` |
| `pop()`    | `O(1)` | `O(1)` |
| `top()`    | `O(1)` | `O(1)` |
| `getMin()` | `O(1)` | `O(1)` |

Overall space complexity: **`O(n)`** for `n` elements in the stack.

## Key Takeaway

Instead of searching for the minimum every time, **store the minimum at each node**. This allows `getMin()` to return the answer directly in **`O(1)`** time.

```text
Algorithm → Stack using Linked List + Stored Minimum
Pattern   → Stack
Time      → O(1) per operation
Space     → O(n)
```
