# [886. Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)

**Difficulty:** 🟡 Medium

## Problem

Given `N` people and an array `dislikes`, where `dislikes[i] = [a, b]` means person `a` dislikes person `b`, divide everyone into **two groups** such that no two people who dislike each other belong to the same group.

Return `true` if such a division is possible; otherwise, return `false`.

## Algorithm

**Graph Coloring + Depth-First Search (DFS)**

## Intuition

We can represent the people as a **graph**, where each person is a vertex and each dislike relationship is an undirected edge.

To divide people into two groups, we assign each person one of two colors:

- `1` → Group 1
- `-1` → Group 2

Every pair of people connected by an edge must have **different colors**.

Using DFS, we assign the opposite color to each unvisited neighbor. If two connected people have the same color, a valid bipartition is impossible.

## Approach

1. Create an adjacency list of size `N + 1`.
2. Add each dislike relationship in both directions.
3. Create a `colours` array initialized with `null`, indicating unvisited people.
4. Iterate through every person from `1` to `N` to handle disconnected components.
5. If a person is unvisited, start DFS with color `1`.
6. During DFS:
   - Assign the current person their color.
   - Visit each neighbor.
   - If the neighbor is unvisited, recursively assign the opposite color using `currColour * -1`.
   - If the neighbor already has the same color, return `false`.
7. If every component can be colored successfully, return `true`.

## Example

```text
N = 4
dislikes = [[1,2], [1,3], [2,4]]

Graph:

    2 ----- 1 ----- 3
    |
    4

Possible groups:

Group 1: [1, 4]
Group 2: [2, 3]

Output: true
```

## Dry Run

For:

```text
N = 4
dislikes = [[1,2], [1,3], [2,4]]
```

Start DFS from person `1` with color `1`.

| Person | Assigned Color | Action |
| ------ | -------------- | ------ |
| 1 | `1` | Start DFS |
| 2 | `-1` | Opposite of person 1 |
| 4 | `1` | Opposite of person 2 |
| 3 | `-1` | Opposite of person 1 |

All dislike relationships connect people with different colors.

```text
Group 1: [1, 4]
Group 2: [2, 3]

Result: true
```

## Why This Works

Every dislike relationship is represented by an edge, and DFS ensures that connected people receive opposite colors.

If an edge connects two people with the same color, the graph cannot be divided into two valid groups.

Checking every unvisited person ensures that **all disconnected components** are considered.

Therefore, the algorithm correctly determines whether a valid bipartition exists.

## Complexity Analysis

Let `N` be the number of people and `E` be the number of dislike relationships.

### Time Complexity

Each person and each edge is processed at most a constant number of times.

```text
O(N + E)
```

### Space Complexity

The adjacency list, color array, and DFS recursion stack require:

```text
O(N + E)
```

## Key Takeaway

> **Graph Coloring → DFS → Assign Opposite Colors → Detect Conflicts**

```text
Algorithm → DFS + Graph Coloring
Pattern   → Bipartite Graph
Time      → O(N + E)
Space     → O(N + E)
```
