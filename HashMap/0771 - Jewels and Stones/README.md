# [771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)

**Difficulty:** 🟢 Easy

## Problem

You're given two strings:

* `jewels` — characters that represent types of stones that are jewels.
* `stones` — characters representing the stones you have.

Each character in `stones` represents one stone.

Return the number of stones that are also **jewels**.

---

## Algorithm

This solution is based on **Hashing**, using a `HashMap`.

The main idea is to store all the characters from `jewels` in a `HashMap`. Then, while traversing `stones`, we check whether each character exists in the map.

```text
Algorithm → Hashing
Data Structure → HashMap
```

Since we only care whether a character exists in `jewels`, the values stored in the map are not actually used.

---

## Intuition

Suppose:

```text
jewels = "aA"
stones = "aAAbbbb"
```

The jewel characters are:

```text
a
A
```

We can store them in a `HashMap`:

```text
{
    'a' → 0,
    'A' → 0
}
```

Then we go through every stone:

```text
a → jewel → total++
A → jewel → total++
A → jewel → total++
b → not a jewel
b → not a jewel
b → not a jewel
b → not a jewel
```

Therefore:

```text
total = 3
```

---

## Approach

1. Create a `HashMap` to store all jewel characters:

   ```java
   HashMap<Character, Integer> map = new HashMap<>();
   ```

2. Traverse the `jewels` string and add every character to the map:

   ```java
   for(char c : jewels.toCharArray()){
       map.put(c, 0);
   }
   ```

   The value `0` is not important. We only use the map to check whether a character exists.

3. Traverse the `stones` string:

   ```java
   for(char c : stones.toCharArray()){
   ```

4. Check whether the current stone is a jewel:

   ```java
   if(map.containsKey(c)){
       total++;
   }
   ```

5. Return the total number of jewel stones:

   ```java
   return total;
   ```

---

## Dry Run

Let's take:

```text
jewels = "aA"
stones = "aAAbbbb"
```

### Step 1 — Store Jewels

After processing `jewels`:

```text
map = {
    'a' → 0,
    'A' → 0
}
```

---

### Step 2 — Process Stones

Start:

```text
total = 0
```

#### Stone = `a`

```text
'a' exists in map
```

So:

```text
total = 1
```

#### Stone = `A`

```text
'A' exists in map
```

So:

```text
total = 2
```

#### Stone = `A`

Again:

```text
total = 3
```

#### Stone = `b`

```text
'b' does not exist in map
```

No change.

The remaining `b` characters are also not jewels.

Final:

```text
total = 3
```

Therefore:

```text
Output = 3
```

---

## Why Use a HashMap?

We need to repeatedly check:

```text
Is this character a jewel?
```

A `HashMap` allows us to perform this lookup efficiently.

The important operation is:

```java
map.containsKey(c)
```

This gives an average-case lookup time of:

```text
O(1)
```

Therefore, we can process all the stones efficiently.

---

## Alternative: HashSet

Since we don't actually use the values stored in the `HashMap`, a `HashSet<Character>` would be more appropriate.

Instead of:

```java
HashMap<Character, Integer> map = new HashMap<>();
```

we could use:

```java
HashSet<Character> set = new HashSet<>();
```

Then:

```java
for(char c : jewels.toCharArray()){
    set.add(c);
}
```

and:

```java
for(char c : stones.toCharArray()){
    if(set.contains(c)){
        total++;
    }
}
```

The `HashSet` directly represents what we need: a collection of unique characters for fast membership checking.

---

## Complexity Analysis

Let:

* `J` = length of `jewels`
* `S` = length of `stones`

**Time Complexity:** `O(J + S)`

* We traverse `jewels` once.
* We traverse `stones` once.
* HashMap lookup takes `O(1)` average time.

**Space Complexity:** `O(J)`

* In the worst case, all characters in `jewels` are unique and need to be stored in the map.

---

## Key Takeaway

The main idea is to use **hashing for fast membership checking**.

```text
Store → jewel characters
Check → every stone against the stored characters
Count → matching characters
```

The core operation is:

```java
if(map.containsKey(c)){
    total++;
}
```

```text
Algorithm → Hashing
Data Structure → HashMap
Time → O(J + S)
Space → O(J)
```
