# [72. Edit Distance](https://leetcode.com/problems/edit-distance/)

**Difficulty:** 🟠 Medium

## Problem

Given two strings `word1` and `word2`, return the **minimum number of operations** required to convert `word1` into `word2`.

You can perform three operations:

* **Insert** a character
* **Delete** a character
* **Replace** a character

---

## Algorithm

This problem is based on **Dynamic Programming**.

More specifically, it uses **Bottom-Up Dynamic Programming** with a **2D DP table**.

The problem has **optimal substructure** because the minimum edit distance between two strings can be constructed from the minimum edit distances of their smaller prefixes.

The main recurrence is:

```text
dp[i][j] = min(
    dp[i-1][j-1],  // Replace
    dp[i-1][j],    // Delete
    dp[i][j-1]     // Insert
) + 1
```

If the current characters are already equal, no operation is needed:

```text
dp[i][j] = dp[i-1][j-1]
```

---

## Intuition

Instead of comparing the complete strings at once, we compare their prefixes.

Here:

```text
dp[i][j]
```

represents the **minimum number of operations required to convert the first `i` characters of `word1` into the first `j` characters of `word2`**.

For every pair of characters, there are two possibilities.

### Characters are equal

If:

```java
word1.charAt(i - 1) == word2.charAt(j - 1)
```

then no operation is required.

```text
dp[i][j] = dp[i-1][j-1]
```

### Characters are different

We can perform one of three operations:

```text
Replace → dp[i-1][j-1]
Delete  → dp[i-1][j]
Insert  → dp[i][j-1]
```

We choose the operation that requires the fewest additional operations.

```text
dp[i][j] = min(replace, delete, insert) + 1
```

---

## Approach

1. Get the lengths of both strings:

   ```java
   int n = word1.length();
   int m = word2.length();
   ```

2. Handle empty strings.

   If `word1` is empty, we need `m` insertions:

   ```java
   if(n == 0) return m;
   ```

   If `word2` is empty, we need `n` deletions:

   ```java
   if(m == 0) return n;
   ```

3. Create a `2D` DP table:

   ```java
   int[][] dp = new int[n + 1][m + 1];
   ```

4. Initialize the first column:

   ```java
   for(int i = 1; i <= n; i++){
       dp[i][0] = i;
   }
   ```

   Converting a string of length `i` into an empty string requires `i` deletions.

5. Initialize the first row:

   ```java
   for(int i = 1; i <= m; i++){
       dp[0][i] = i;
   }
   ```

   Converting an empty string into a string of length `i` requires `i` insertions.

6. Traverse both strings:

   ```java
   for(int i = 1; i < n + 1; i++){
       for(int j = 1; j < m + 1; j++){
   ```

7. If the current characters are equal:

   ```java
   if(word1.charAt(i-1) == word2.charAt(j-1))
       dp[i][j] = dp[i-1][j-1];
   ```

8. Otherwise, consider all three operations:

   ```java
   dp[i][j] =
       Math.min(
           dp[i-1][j-1],
           Math.min(dp[i-1][j], dp[i][j-1])
       ) + 1;
   ```

9. Return:

   ```java
   return dp[n][m];
   ```

   This represents the minimum number of operations needed to convert the complete `word1` into `word2`.

---

## Dry Run

Let's take:

```text
word1 = "horse"
word2 = "ros"
```

The DP table starts with the empty-string cases:

```text
      ""  r  o  s
""     0  1  2  3
h      1
o      2
r      3
s      4
e      5
```

The first row represents inserting characters.

The first column represents deleting characters.

After processing both strings, the table becomes:

```text
      ""  r  o  s
""     0  1  2  3
h      1  1  2  2
o      2  2  1  2
r      3  2  2  2
s      4  3  3  2
e      5  4  4  3
```

Therefore:

```text
dp[5][3] = 3
```

So the minimum edit distance is:

```text
3
```

One possible sequence is:

```text
horse
 ↓
rorse   → replace 'h' with 'r'
 ↓
rose    → delete 'r'
 ↓
ros     → delete 'e'
```

Thus, only **3 operations** are required.

---

## DP State Transition

The key transition is:

```text
If characters are equal:

dp[i][j] = dp[i-1][j-1]
```

Otherwise:

```text
dp[i][j] =
    min(
        dp[i-1][j-1],  // Replace
        dp[i-1][j],    // Delete
        dp[i][j-1]     // Insert
    ) + 1
```

### Replace

```text
dp[i-1][j-1] + 1
```

Replace the current character in `word1`.

### Delete

```text
dp[i-1][j] + 1
```

Delete the current character from `word1`.

### Insert

```text
dp[i][j-1] + 1
```

Insert the required character into `word1`.

---

## Why Do We Use `i - 1` and `j - 1`?

The DP table has an extra row and column representing empty strings.

Therefore:

```text
dp[i][j]
```

corresponds to:

```text
word1[0 ... i-1]
word2[0 ... j-1]
```

So the actual characters being compared are:

```java
word1.charAt(i - 1)
word2.charAt(j - 1)
```

For example, when:

```text
i = 3
j = 2
```

we compare:

```text
word1.charAt(2)
word2.charAt(1)
```

---

## Why Does This Work?

The edit distance for a larger pair of strings can be built from smaller prefixes.

For example, if the current characters are different, we only need to consider the three possible operations:

```text
Replace → solve both previous prefixes
Delete  → solve word1 without its current character
Insert  → solve word2 without its current character
```

Each of these smaller problems has already been calculated in the DP table.

Therefore, we can select the minimum and add `1` for the operation performed.

This avoids repeatedly solving the same subproblems.

---

## Complexity Analysis

**Time Complexity:** `O(n × m)`

* Every cell in the `n × m` DP table is calculated exactly once.

**Space Complexity:** `O(n × m)`

* We store the results for all pairs of prefixes in a `2D` DP table.

Where:

* `n` = length of `word1`
* `m` = length of `word2`

---

## Key Takeaway

The main idea is to break the problem into smaller prefix-conversion problems.

For every pair of characters:

```text
Same character
    ↓
No operation

Different character
    ↓
Choose the minimum of:
    Replace
    Delete
    Insert
```

The core recurrence is:

```text
dp[i][j] = min(
    dp[i-1][j-1],
    dp[i-1][j],
    dp[i][j-1]
) + 1
```

This is a classic **2D Dynamic Programming** problem.

```text
Algorithm → Dynamic Programming
Approach  → Bottom-Up DP
Time      → O(n × m)
Space     → O(n × m)
```
