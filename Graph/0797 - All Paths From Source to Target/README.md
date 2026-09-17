# [797. All Paths From Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/)

**Difficulty:** 🟡 Medium

## Problem

Given a directed acyclic graph (`DAG`), where `graph[i]` contains the nodes that can be reached from node `i`, return **all possible paths** from node `0` to node `n - 1`.

Each path should start at node `0` and end at node `n - 1`.

## Algorithm

**Backtracking + DFS**

## Intuition

Starting from node `0`, we explore every possible neighbor.

For each node:

* Add the node to the current path.
* Recursively explore its neighbors.
* Once the target node is reached, store the current path.
* Remove the node to **backtrack** and explore another path.

Since the graph is a DAG, there are no cycles, so we do not need a `visited` array.

## Approach

1. Initialize `temp` with node `0`.
2. Start DFS from node `0`.
3. If the current node is `n - 1`, add the current path to `res`.
4. Otherwise, iterate through every neighbor of the current node.
5. Add the neighbor to `temp`.
6. Recursively explore that neighbor.
7. Remove the last node to **backtrack**.
8. Continue until all possible paths are generated.

## Dry Run

For:

```text
graph = [[1,2], [3], [3], []]
```

The graph can be represented as:

```text
        0
       / \
      1   2
       \ /
        3
```

Starting from `0`:

```text
temp = [0]
```

Choose `1`:

```text
[0,1]
```

Then choose `3`:

```text
[0,1,3]
```

Since `3` is the target, add the path.

Backtrack:

```text
[0,1,3] → [0,1] → [0]
```

Now choose `2`:

```text
[0,2,3]
```

Final result:

```text
[
    [0,1,3],
    [0,2,3]
]
```

## Why This Works

The DFS explores every possible outgoing edge from each node.

The `temp` list stores the current path, while backtracking removes the last node after its path has been completely explored.

Whenever the target node is reached, the current path is a valid path from source to target and is added to the result.

Because the graph is a **DAG**, the traversal cannot get stuck in a cycle.

## Complexity Analysis

Let `P` be the number of paths from node `0` to node `n - 1`.

### Time Complexity

Every valid path is generated and copied into the result. The total work depends on the number and length of paths:

```text
O(P × V)
```

where `V` is the number of nodes.

### Space Complexity

The recursion stack and current path can contain up to `V` nodes:

```text
O(V)
```

excluding the output.

## Key Takeaway

> **DFS → Choose a neighbor → Explore → Backtrack → Store when target is reached**

```text
Algorithm → Backtracking + DFS
Pattern   → Path Generation
Time      → O(P × V)
Space     → O(V)  [excluding output]
```
