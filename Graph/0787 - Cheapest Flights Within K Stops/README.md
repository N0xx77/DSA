# [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)

**Difficulty:** 🟡 Medium

## Problem

There are `n` cities connected by flights.

Each flight is represented as:

```text
[u, v, w]
```

where `u` is the source city, `v` is the destination city, and `w` is the price.

Given `src`, `dst`, and `k`, find the **cheapest price** from `src` to `dst` using **at most `k` stops**.

If no valid route exists, return `-1`.

## Algorithm

**Bellman-Ford**

## Intuition

This problem is similar to Bellman-Ford, but we have an additional restriction: the route can use at most `k` stops.

Since `k` stops means at most `k + 1` flights, we perform exactly `k + 1` relaxation rounds.

A temporary array is used in every round so that updates from the **current round cannot be used again in the same round**.

## Approach

1. Initialize all distances to `Integer.MAX_VALUE`.
2. Set the source city distance to `0`.
3. Repeat the relaxation process `k + 1` times.
4. Create a copy of `distance` called `temp`.
5. For every flight `(u, v, w)`, check whether reaching `v` through `u` gives a cheaper price.
6. Store the updated price in `temp`.
7. After processing all flights, assign:

   ```text
   distance = temp
   ```
8. After `k + 1` rounds, return the distance to `dst`.
9. If `dst` is still unreachable, return `-1`.

## Why `temp` Is Used

The `temp` array is important because each iteration represents **one additional flight**.

Suppose:

```text
A → B → C
```

During one iteration, if we update:

```text
distance[B]
```

and then immediately use the updated value to update:

```text
distance[C]
```

we would effectively use **two flights in the same iteration**.

By using:

```text
temp = copy of distance
```

we always read from the distances available **before the current iteration** and write the new distances into `temp`.

This ensures that each iteration adds at most **one flight**.

## Dry Run

For:

```text
flights = [[0,1,100], [1,2,100], [0,2,500]]
src = 0
dst = 2
k = 1
```

We can use at most:

```text
k + 1 = 2 flights
```

### Initial

```text
distance = [0, ∞, ∞]
```

### Iteration 1

Using one flight:

```text
0 → 1 = 100
0 → 2 = 500
```

```text
distance = [0, 100, 500]
```

### Iteration 2

Using up to two flights:

```text
0 → 1 → 2
100 + 100 = 200
```

So:

```text
distance = [0, 100, 200]
```

Therefore:

```text
Answer = 200
```

## Why This Works

After each iteration, `distance[v]` represents the cheapest cost to reach `v` using at most the number of flights processed so far.

Since we perform `k + 1` iterations, routes containing more than `k + 1` flights are never considered.

The temporary array ensures that every iteration increases the maximum number of flights by exactly one.

## Complexity Analysis

Let `V` be the number of cities and `E` be the number of flights.

### Time Complexity

We process every flight `k + 1` times:

```text
O(k × E)
```

### Space Complexity

We store two distance arrays of size `n`:

```text
O(V)
```

## Key Takeaway

> **Bellman-Ford + Limited Relaxations → At most `k + 1` flights**

```text
Algorithm → Bellman-Ford
Pattern   → Bounded Shortest Path
Time      → O(k × E)
Space     → O(V)
```
