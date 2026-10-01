# [637. Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/)

**Difficulty:** 🟢 Easy

## Problem

Given the root of a binary tree, return the **average value of the nodes on each level** in the form of a list.

Each level should be processed from **left to right**, and the averages should be returned in top-to-bottom order.

## Algorithm

**Breadth-First Search (BFS) / Level Order Traversal**

## Intuition

Since we need the average of each **level separately**, we can use **level-order traversal** with a queue.

At the start of each iteration, the size of the queue represents the number of nodes in the current level.

We process exactly those nodes, calculate their sum, and add their children to the queue for the next level.

The average of the level is:

```text
average = sum / number of nodes
```

## Approach

1. Create a queue and add the root node.
2. Create a `res` list to store the averages.
3. While the queue is not empty:

   * Store the current queue size as `level`.
   * Set `sum = 0`.
   * Process exactly `level` nodes.
   * Add each node's value to `sum`.
   * Add its left and right children to the queue.
4. Calculate `sum / level` and add it to `res`.
5. Repeat until all levels are processed.
6. Return `res`.

For example:

```text
        3
       / \
      9   20
          / \
         15  7

Level 0:
[3]
Average = 3 / 1 = 3.0

Level 1:
[9, 20]
Average = 29 / 2 = 14.5

Level 2:
[15, 7]
Average = 22 / 2 = 11.0

Result:
[3.0, 14.5, 11.0]
```

## Dry Run

For:

```text
        3
       / \
      9   20
          / \
         15  7
```

Initial queue:

```text
[3]
```

### Level 1

```text
level = 1
sum = 3

Queue after processing:
[9, 20]

Average = 3 / 1 = 3.0
```

Result:

```text
[3.0]
```

### Level 2

```text
level = 2
sum = 9 + 20 = 29

Queue after processing:
[15, 7]

Average = 29 / 2 = 14.5
```

Result:

```text
[3.0, 14.5]
```

### Level 3

```text
level = 2
sum = 15 + 7 = 22

Queue after processing:
[]

Average = 22 / 2 = 11.0
```

Final result:

```text
[3.0, 14.5, 11.0]
```

## Why This Works

The queue always contains the nodes that need to be processed.

By storing the queue size before processing a level, we know **exactly how many nodes belong to the current level**.

After processing those nodes, their children are added to the queue, forming the next level.

Therefore, each level is processed independently and its average can be calculated correctly.

## Complexity Analysis

### Time Complexity

Every node is visited exactly once.

```text
O(n)
```

where `n` is the number of nodes in the tree.

### Space Complexity

The queue can contain nodes from the largest level of the tree.

```text
O(n)
```

in the worst case.

## Key Takeaway

> **BFS → Process One Level → Calculate Sum → Add Average → Continue**

```text
Algorithm → Breadth-First Search (BFS)
Pattern   → Level Order Traversal
Time      → O(n)
Space     → O(n)
```
