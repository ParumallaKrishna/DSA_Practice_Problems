package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_2;
/*Given a singly linked list A
 A: A0 → A1 → … → An-1 → An
reorder it to:
 A0 → An → A1 → An-1 → A2 → An-2 → …
You must do this in-place without altering the nodes' values.
Problem Constraints
1 <= |A| <= 106
Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.
Output Format
Return a pointer to the head of the modified linked list.
Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [1, 2, 3, 4]
Example Output
Output 1: [1, 5, 2, 4, 3]
Output 2: [1, 4, 2, 3]
*/
public class LL_6 {
    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        // Step 1: Find middle
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Split the list
        ListNode second = slow.next;
        slow.next = null;
        // Step 3: Reverse second half
        ListNode prev = null;
        ListNode curr = second;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        second = prev;
        // Step 4: Merge both halves alternately
        ListNode first = A;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
        return A;
    }
}
