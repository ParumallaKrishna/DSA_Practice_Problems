package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_1;
/*Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
Problem Constraints
1 <= |A| <= 105
Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.
Output Format
Return 0, if the linked list is not a palindrome.
Return 1, if the linked list is a palindrome.
Example Input
Input 1: A = [1, 2, 2, 1]
Input 2: A = [1, 3, 2]
Example Output
Output 1: 1
Output 2: 0 */
public class LL_2 {
    public int lPalin(ListNode A) {
        if (A == null || A.next == null) {
            return 1;
        }
        // Step 1: Find the middle using slow and fast pointers
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Reverse the second half
        ListNode secondHalf = reverse(slow.next);
        // Step 3: Compare both halves
        ListNode first = A;
        ListNode second = secondHalf;
        while (second != null) {
            if (first.val != second.val) {
                return 0;
            }

            first = first.next;
            second = second.next;
        }
        return 1;
    }
    // Reverse linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
