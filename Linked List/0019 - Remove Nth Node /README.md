# [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

**Difficulty:** 🟠 Medium

## Problem

Given the head of a linked list, remove the `n`th node from the end of the list and return its head.

The list contains at least one node.

---

## Intuition

We need to remove a node based on its position **from the end** of the linked list.

Instead of calculating the length of the list first, we can use the **two-pointer technique** with `slow` and `fast` pointers.

The idea is to maintain a gap of `n` nodes between `slow` and `fast`.

Once `fast` reaches the end of the list, `slow` will be positioned **just before the node that needs to be removed**.

A **dummy node** is used before the head to make removing the first node easier.

---

## Approach

1. Create a `dummy` node and point it to `head`.

   ```cpp
   ListNode* dummy = new ListNode(0, head);
   ```

   This allows us to handle cases where the node being removed is the first node.

2. Initialize two pointers:

   ```cpp
   ListNode* slow = dummy;
   ListNode* fast = dummy;
   ```

3. Move `fast` forward by `n` nodes.

   ```cpp
   for(int i = 0; i < n; i++){
       fast = fast->next;
   }
   ```

   This creates a gap of `n` nodes between `slow` and `fast`.

4. Move both pointers together until `fast` reaches the last node.

   ```cpp
   while(fast->next != NULL){
       slow = slow->next;
       fast = fast->next;
   }
   ```

   At this point, `slow` is positioned immediately before the node that needs to be removed.

5. Remove the node by skipping it:

   ```cpp
   slow->next = slow->next->next;
   ```

6. Return `dummy->next`, which is the new head of the linked list.

---

## Dry Run

Let's take:

```text
head = [1, 2, 3, 4, 5]
n = 2
```

We need to remove the **2nd node from the end**, which is `4`.

Initially:

```text
dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> NULL
  ↑
slow, fast
```

### Step 1: Move `fast` by `n = 2` nodes

After moving `fast` twice:

```text
dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> NULL
  ↑          ↑
 slow       fast
```

There is now a gap of `2` nodes between `slow` and `fast`.

### Step 2: Move both pointers

Move both pointers until `fast->next == NULL`.

First movement:

```text
dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> NULL
             ↑          ↑
            slow       fast
```

Second movement:

```text
dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> NULL
                  ↑          ↑
                 slow       fast
```

Now `fast` is at the last node (`5`), so we stop.

`slow` is at node `3`, which is exactly the node **before `4`**.

### Step 3: Remove node `4`

Currently:

```text
slow -> 4 -> 5
```

We execute:

```cpp
slow->next = slow->next->next;
```

So `3` now points directly to `5`.

```text
dummy -> 1 -> 2 -> 3 -> 5 -> NULL
```

The final answer is:

```text
[1, 2, 3, 5]
```

---

## Complexity Analysis

**Time Complexity:** `O(n)`

* The `fast` pointer moves `n` steps initially.
* Both pointers then traverse the remaining portion of the list.
* Overall, the linked list is traversed only once.

**Space Complexity:** `O(1)`

* Only the `slow`, `fast`, and `dummy` pointers are used.
* No additional data structure is required.
