# [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/)

**Difficulty:** 🟡 Medium

## Problem

You are given a directed, weighted graph representing a network.

Each `times[i] = [u, v, w]` means a signal takes `w` units of time to travel from node `u` to node `v`.

Starting from node `k`, return the **minimum time required for all nodes to receive the signal**.

If some node cannot be reached, return `-1`.

## Algorithm

**Bellman-Ford**

## Intuition

We need to find the **shortest distance from `k` to every other node**.

Bellman-Ford works by repeatedly relaxing every edge.

For an edge:

```text
u → v with weight w
```

if reaching `u` and then travelling to `v` is shorter:

```text
distance[u] + w < distance[v]
```

we update `distance[v]`.

After calculating all shortest distances, the answer is the **maximum distance**, because the signal must reach the farthest node.

## Approach

1. Initialize all distances to `Integer.MAX_VALUE`.
2. Set the source node `k` distance to `0`.
3. Relax every edge `n - 1` times.
4. For each edge `(u, v, w)`, update:

   ```text
   distance[v] = min(distance[v], distance[u] + w)
   ```
5. If any node is still unreachable, return `-1`.
6. Otherwise, return the maximum shortest distance.

## Dry Run

For:

```text
times = [[2,1,1], [2,3,1], [3,4,1]]
n = 4
k = 2
```

Initial distances:

```text
Node:      1    2    3    4
Distance: ∞    0    ∞    ∞
```

After relaxing the edges:

```text
2 → 1 = 1
2 → 3 = 1
3 → 4 = 2
```

Final distances:

```text
Node:      1    2    3    4
Distance: 1    0    1    2
```

The farthest node takes `2` units of time.

```text
Answer = 2
```

## Why This Works

Each relaxation attempts to improve the shortest known distance to a node.

Bellman-Ford performs `n - 1` complete passes over all edges. After these passes, the shortest paths containing up to `n - 1` edges have been considered.

Since a shortest simple path can contain at most `n - 1` edges, all shortest distances are correctly calculated.

The maximum distance represents the time required for the signal to reach **every node**.

## Complexity Analysis

### Time Complexity

There are `n - 1` iterations, and every iteration checks all `E` edges.

```text
O(V × E)
```

### Space Complexity

The algorithm only stores the distance array:

```text
O(V)
```

## Key Takeaway

> **Relax every edge `V - 1` times → Find shortest distances → Take the maximum**

```text
Algorithm → Bellman-Ford
Pattern   → Repeated Edge Relaxation
Time      → O(V × E)
Space     → O(V)
```
