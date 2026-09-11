/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode* fast = head;
        ListNode * slow = head;
        ListNode *prev = NULL, *temp;

        while(fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }

        while(slow){
            temp = slow->next;
            slow->next = prev;
            prev = slow;
            slow = temp;
        }
        
        fast = prev, slow = head;

        while(fast){
            if(slow->val != fast->val) return false;
            else slow = slow->next, fast = fast->next;
        }
        return true;
    }
};
