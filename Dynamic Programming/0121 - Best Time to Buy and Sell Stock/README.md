# [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

**Difficulty:** 🟢 Easy

## Problem

You are given an array `prices` where `prices[i]` represents the price of a stock on the `i`-th day.

You can choose **one day to buy** one stock and choose a **different day in the future to sell** that stock.

Return the **maximum profit** you can achieve. If no profit is possible, return `0`.

---

## Intuition

To maximize profit, we want to:

* Buy the stock at the **lowest possible price**.
* Sell it later at the **highest possible price**.

As we traverse the array, we keep track of the minimum price seen so far using:

```java
minCost
```

For every price `p`, we calculate the profit we would get by selling on that day:

```java
int temp = p - minCost;
```

If this profit is greater than our current maximum profit, we update `profit`.

If the current price is lower than `minCost`, we update `minCost`.

Therefore, instead of trying every possible pair of buy and sell days, we can solve the problem in a **single pass** through the array.

---

## Algorithm

This problem can be solved using **Kadane's Algorithm** by viewing the change in stock prices as an array of daily gains/losses.

For example:

```text
prices = [7, 1, 5, 3, 6, 4]
```

The differences between consecutive days are:

```text
[-6, +4, -2, +3, -2]
```

Now the problem becomes finding the **maximum subarray sum** in this difference array.

```text
[-6, 4, -2, 3, -2]
     └───────┘
      4 - 2 + 3 = 5
```

The maximum subarray has a sum of `5`, which corresponds to:

```text
Buy at 1
Sell at 6

Profit = 6 - 1 = 5

```

This is exactly the idea behind **Kadane's Algorithm**, where we keep track of the best subarray ending at the current position and the maximum sum found so far.

### Relation to the Current Code

The given implementation does not explicitly create the difference array. Instead, it uses an equivalent **greedy formulation**:

```java
int minCost = prices[0];
int profit = 0;
```

For every price:

```java
int temp = p - minCost;
```

Here:

* `minCost` represents the best possible starting point for the current profit.
* `p - minCost` represents the profit of selling on the current day.
* `profit` stores the maximum profit found so far.

Therefore, the solution can be viewed as:

```text
Algorithmic Pattern: Kadane's Algorithm
Implementation: Greedy / Minimum-Price Tracking
Time Complexity: O(n)
Space Complexity: O(1)
```

The key connection is that both approaches find the **maximum possible accumulated gain between a buying point and a later selling point**.

---

## Approach

1. Initialize `minCost` with the price on the first day:

   ```java
   int minCost = prices[0];
   ```

   This represents the lowest buying price seen so far.

2. Initialize the maximum profit as `0`:

   ```java
   int profit = 0;
   ```

   If the stock prices only decrease, no profitable transaction is possible.

3. Traverse every price in the array:

   ```java
   for(int p : prices)
   ```

4. Calculate the profit if we sell at the current price:

   ```java
   int temp = p - minCost;
   ```

5. If this profit is greater than the current maximum profit, update it:

   ```java
   if(profit < temp)
       profit = temp;
   ```

6. Otherwise, if the current price is lower than the minimum buying price, update `minCost`:

   ```java
   else if(minCost > p)
       minCost = p;
   ```

7. After processing all prices, return the maximum profit:

   ```java
   return profit;
   ```

---

## Dry Run

Let's take:

```text
prices = [7, 1, 5, 3, 6, 4]
```

Initially:

```text
minCost = 7
profit = 0
```

### Price = 7

Calculate:

```text
temp = 7 - 7 = 0
```

No profit improvement and the price is not lower than `minCost`.

```text
minCost = 7
profit = 0
```

---

### Price = 1

Calculate:

```text
temp = 1 - 7 = -6
```

This is not better than the current profit.

Since `1 < 7`, update the minimum buying price:

```text
minCost = 1
profit = 0
```

---

### Price = 5

Calculate:

```text
temp = 5 - 1 = 4
```

Since `4 > 0`, update:

```text
profit = 4
```

```text
minCost = 1
profit = 4
```

---

### Price = 3

Calculate:

```text
temp = 3 - 1 = 2
```

`2` is less than the current maximum profit of `4`.

```text
minCost = 1
profit = 4
```

---

### Price = 6

Calculate:

```text
temp = 6 - 1 = 5
```

Since `5 > 4`, update:

```text
profit = 5
```

```text
minCost = 1
profit = 5
```

---

### Price = 4

Calculate:

```text
temp = 4 - 1 = 3
```

`3` is less than the current maximum profit.

```text
minCost = 1
profit = 5
```

Final result:

```text
profit = 5
```

The best transaction is:

```text
Buy  → 1
Sell → 6

Profit = 6 - 1 = 5
```

Therefore, the maximum profit is:

```text
5
```

---

## Key Idea

At every price, we ask two questions:

```text
1. What is the cheapest price I could have bought at?
2. How much profit would I make if I sold today?
```

The important variables are:

* `minCost` → lowest stock price encountered so far.
* `profit` → maximum profit found so far.

The main calculation is:

```java
profit = Math.max(profit, p - minCost);
```

This allows us to solve the problem without storing a DP array.

---

## Why Does This Work?

For every selling price, we only need the **lowest buying price that occurred before it**.

For example:

```text
prices = [7, 1, 5]
```

When we reach `5`, the cheapest price available before it was `1`.

Therefore:

```text
profit = 5 - 1 = 4
```

There is no need to remember every previous price because a higher previous buying price can never produce a better profit than the lowest one.

This gives us a **greedy one-pass solution** with constant extra space.

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* We traverse the `prices` array exactly once.

**Space Complexity:** `O(1)`

* Only two variables, `minCost` and `profit`, are used regardless of the input size.

---

## Key Takeaway

The main idea is to keep track of the **minimum buying price** and calculate the potential profit for every selling price.

```text
minCost = minimum price seen so far

profit = maximum(profit, current price - minCost)
```

This converts what could be an `O(n²)` brute-force problem into an efficient solution:

```text
Time  → O(n)
Space → O(1)
```
