package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_1;
/*Given a linked list A, remove the B-th node from the end of the list and return its head.
For example, given linked list: 1->2->3->4->5, and B = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
NOTE: If B is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.
Problem Constraints
1 <= |A| <= 106
Input Format
The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.
Output Format
Return the head of the linked list after deleting the B-th element from the end.
Example Input
Input 1: A = 1->2->3->4->5 B = 2
Input 2: A = 1 B = 1
Example Output
Output 1:
1->2->3->5
Output 2:
  */
public class LL_3 {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        // Dummy node handles deletion of head
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // Move fast B steps ahead
        for (int i = 0; i < B; i++) {
            fast = fast.next;
            // B is greater than list size
            if (fast == null) {
                return A.next;
            }
        }
        // Move both pointers until fast reaches last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Delete B-th node from end
        slow.next = slow.next.next;
        return dummy.next;
    }
}
