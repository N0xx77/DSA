# [322. Coin Change](https://leetcode.com/problems/coin-change/)

**Difficulty:** 🟠 Medium

## Problem

You are given an integer array `coins` representing different denominations of coins and an integer `amount` representing a total amount of money.

Return the **fewest number of coins** needed to make up that amount.

You may use each coin denomination **unlimited times**.

If the amount cannot be made using the given coins, return `-1`.

---

## Algorithm

This problem is based on **Dynamic Programming (DP)**.

More specifically, it uses **Bottom-Up Dynamic Programming** with a **1D DP array**.

The problem has two important properties:

* **Overlapping Subproblems:** The same smaller amounts are solved multiple times.
* **Optimal Substructure:** The minimum number of coins for an amount can be built from the minimum number of coins needed for smaller amounts.

The main recurrence is:

```text
minCoins[i] = min(minCoins[i], 1 + minCoins[i - coin])
```

This means:

> If we use a coin, the number of coins required is `1` plus the minimum number of coins required to make the remaining amount.

---

## Intuition

Suppose we want to find the minimum number of coins needed to make an amount `i`.

For every available coin, we ask:

```text
Can I use this coin?
```

If the coin value is smaller than or equal to `i`, then we can use it.

For example, if:

```text
coins = [1, 2, 5]
amount = 11
```

To make `11` using a `5` coin:

```text
11 - 5 = 6
```

So the solution becomes:

```text
1 coin + minimum coins needed to make 6
```

Therefore:

```text
minCoins[11] = 1 + minCoins[6]
```

We try every possible coin and choose the one that gives the **minimum total number of coins**.

---

## Approach

1. Create a `1D` DP array of size `amount + 1`:

   ```java
   int[] minCoins = new int[amount + 1];
   ```

   Here:

   ```text
   minCoins[i]
   ```

   represents the **minimum number of coins required to make amount `i`**.

2. Initialize every value to `amount + 1`:

   ```java
   Arrays.fill(minCoins, amount + 1);
   ```

   `amount + 1` acts as a value representing **infinity** because it is impossible to need more than `amount` coins when a coin of value `1` exists.

3. Initialize the base case:

   ```java
   minCoins[0] = 0;
   ```

   Zero coins are required to make an amount of `0`.

4. Traverse every amount from `1` to `amount`:

   ```java
   for(int i = 1; i < amount + 1; i++)
   ```

5. For every amount, try every available coin:

   ```java
   for(int j = 0; j < coins.length; j++)
   ```

6. Check whether the current coin can be used:

   ```java
   if(i - coins[j] >= 0)
   ```

7. If the coin can be used, update the minimum:

   ```java
   minCoins[i] =
       Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
   ```

8. Finally, check whether the target amount is possible:

   ```java
   return minCoins[amount] == amount + 1
       ? -1
       : minCoins[amount];
   ```

   If the value is still `amount + 1`, no combination of coins can create the target amount, so we return `-1`.

---

## Dry Run

Let's take:

```text
coins = [1, 2, 5]
amount = 11
```

Initially:

```text
minCoins = [∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞]
```

where `∞` is represented by:

```text
amount + 1 = 12
```

Set the base case:

```text
minCoins[0] = 0
```

So:

```text
minCoins = [0, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞]
```

### Amount = 1

Try coin `1`:

```text
1 - 1 = 0

minCoins[1] = 1 + minCoins[0]
            = 1 + 0
            = 1
```

```text
minCoins = [0, 1, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞]
```

---

### Amount = 2

Try coin `1`:

```text
1 + minCoins[1]
= 1 + 1
= 2
```

Try coin `2`:

```text
1 + minCoins[0]
= 1 + 0
= 1
```

Choose the minimum:

```text
minCoins[2] = 1
```

```text
minCoins = [0, 1, 1, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞]
```

---

### Amount = 3

Try the available coins:

```text
Using 1:
1 + minCoins[2] = 2

Using 2:
1 + minCoins[1] = 2
```

Therefore:

```text
minCoins[3] = 2
```

---

### Amount = 4

```text
Using 1:
1 + minCoins[3] = 3

Using 2:
1 + minCoins[2] = 2
```

Therefore:

```text
minCoins[4] = 2
```

---

### Amount = 5

Using coin `5`:

```text
1 + minCoins[0]
= 1
```

Therefore:

```text
minCoins[5] = 1
```

---

Continuing this process gives:

```text
Amount:     0  1  2  3  4  5  6  7  8  9  10  11
minCoins:   0  1  1  2  2  1  2  2  3  3   2   3
```

Therefore:

```text
minCoins[11] = 3
```

The optimal combination is:

```text
5 + 5 + 1 = 11
```

So the answer is:

```text
3
```

---

## DP State Transition

The key recurrence is:

```text
minCoins[i] = min(
    minCoins[i],
    1 + minCoins[i - coins[j]]
)
```

For example, when calculating `minCoins[11]` using coin `5`:

```text
minCoins[11]
= 1 + minCoins[6]
```

Since:

```text
minCoins[6] = 2
```

we get:

```text
minCoins[11] = 1 + 2 = 3
```

This represents:

```text
One 5-coin + the best way to make 6
```

---

## Why Do We Initialize with `amount + 1`?

We need an initial value that is larger than any possible valid answer.

In the worst case, if coin `1` exists, we could make the amount using exactly `amount` coins:

```text
amount = 5

1 + 1 + 1 + 1 + 1
```

Therefore, `amount + 1` is guaranteed to be larger than any valid answer.

For example:

```java
Arrays.fill(minCoins, amount + 1);
```

allows us to safely use:

```java
Math.min()
```

when calculating the DP values.

It also allows us to detect an impossible amount at the end:

```java
minCoins[amount] == amount + 1
```

---

## Why Does This Work?

The important observation is that the minimum solution for a larger amount can be constructed from the minimum solutions of smaller amounts.

For example:

```text
Amount = 11
Coin = 5
```

After using the coin:

```text
11 - 5 = 6
```

So:

```text
Minimum coins for 11
=
1 + minimum coins for 6
```

Since we calculate smaller amounts first, `minCoins[6]` is already known when we calculate `minCoins[11]`.

This is the **bottom-up** approach to Dynamic Programming.

---

## Complexity Analysis

**Time Complexity:** `O(amount × n)`

Where:

* `amount` is the target amount.
* `n` is the number of coin denominations.

For every amount, we try every coin.

**Space Complexity:** `O(amount)`

* We use a single DP array of size `amount + 1`.

---

## Key Takeaway

The main idea is:

> For every amount, try using every available coin and choose the option that results in the fewest total coins.

The recurrence is:

```text
minCoins[i] = min(minCoins[i], 1 + minCoins[i - coin])
```

This is a **Bottom-Up Dynamic Programming** solution using a **1D DP array**.

```text
Algorithm  → Dynamic Programming
Approach   → Bottom-Up DP
Time       → O(amount × number of coins)
Space      → O(amount)
```
