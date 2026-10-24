# [1584. Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/)

**Difficulty:** 🟡 Medium

## Problem

You are given an array `points`, where `points[i] = [xᵢ, yᵢ]` represents the coordinates of a point on a 2D plane.

The cost of connecting two points is their **Manhattan distance**:

```text
distance = |x1 - x2| + |y1 - y2|
```

Return the **minimum total cost** required to connect all points, such that there exists exactly one simple path between every pair of points.

## Algorithm

**Prim's Algorithm + Minimum Spanning Tree (MST)**

## Intuition

We can represent every point as a vertex in a weighted, undirected graph. The edge weight between two points is their Manhattan distance.

Since every point must be connected with the minimum total cost, we need to find a **Minimum Spanning Tree (MST)**.

Prim's algorithm builds the MST by repeatedly selecting the unvisited vertex with the smallest connection cost.

- `key[i]` stores the minimum cost required to connect point `i` to the current MST.
- `mst[i]` indicates whether point `i` has been included in the MST.
- `minKey()` finds the unvisited point with the smallest `key` value.

Once a point is included, we update the minimum connection costs of its unvisited neighbors.

## Approach

1. Create an adjacency list for all points.
2. For every pair of points, calculate their Manhattan distance.
3. Add an undirected, weighted edge between each pair.
4. Initialize the `key` array with `Integer.MAX_VALUE` and the `mst` array with `false`.
5. Set `key[0] = 0` to start Prim's algorithm from point `0`.
6. Repeat for each vertex:
   - Use `minKey()` to find the unvisited vertex with the smallest key.
   - Mark the selected vertex as included in the MST.
   - Visit its neighbors and update their keys if a cheaper connection is found.
7. Sum the minimum connection costs stored in `key`.
8. Return the total minimum cost.

## Example

```text
points = [[0,0], [2,2], [3,10], [5,2], [7,0]]

Manhattan distances are used as edge weights.

One possible MST:

(0,0) ---- 4 ---- (2,2) ---- 3 ---- (5,2) ---- 2 ---- (7,0)
                   |
                   9
                   |
                (3,10)

Total cost = 4 + 3 + 2 + 9 = 18

Output: 20
```

## Dry Run

For:

```text
points = [[0,0], [2,2], [3,10], [5,2], [7,0]]
```

Start with point `0`.

```text
key = [0, ∞, ∞, ∞, ∞]
mst = [false, false, false, false, false]
sum = 0
```

Prim's algorithm selects the unvisited point with the smallest key and updates the keys of its neighbors.

| Selected Point | Key Value | Updated Minimum Costs |
| -------------- | --------- | --------------------- |
| 0 | 0 | Point 1: 4, Point 2: 13, Point 3: 7, Point 4: 7 |
| 1 | 4 | Point 2: 12, Point 3: 3, Point 4: 7 |
| 3 | 3 | Point 2: 12, Point 4: 2 |
| 4 | 2 | Point 2: 12 |
| 2 | 12 | All points connected |

The minimum connection costs are:

```text
key = [0, 4, 12, 3, 2]

Total cost = 0 + 4 + 12 + 3 + 2
           = 21
```

## Why This Works

Prim's algorithm always selects the unvisited vertex with the smallest available connection cost.

For each selected vertex, it updates the keys of neighboring vertices whenever a cheaper connection is found.

This ensures that every selected edge contributes to a minimum spanning tree. Once all vertices are included, summing the key values gives the minimum total cost.

## Complexity Analysis

Let `N` be the number of points.

### Time Complexity

Constructing the complete graph requires examining every pair of points, taking `O(N²)` time.

Prim's algorithm uses `minKey()` to scan all vertices in each iteration, also taking `O(N²)` time. Updating all adjacency lists takes `O(N²)` time overall.

```text
O(N²)
```

### Space Complexity

The complete graph contains an edge between every pair of points, requiring `O(N²)` space. The `key` and `mst` arrays require `O(N)` space.

```text
O(N²)
```

## Key Takeaway

> **Prim's Algorithm → Select Minimum Key → Update Neighbors → Build MST**

```text
Algorithm → Prim's Algorithm
Pattern   → Minimum Spanning Tree (MST)
Time      → O(N²)
Space     → O(N²)
```
