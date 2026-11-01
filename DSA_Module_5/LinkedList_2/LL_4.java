package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_2;
/*Sort a linked list, A in O(n log n) time.
Problem Constraints
0 <= |A| = 105
Input Format
The first and the only arugment of input contains a pointer to the head of the linked list, A.
Output Format
Return a pointer to the head of the sorted linked list.
Example Input
Input 1: A = [3, 4, 2, 8]
Input 2: A = [1]
Example Output
Output 1: [2, 3, 4, 8]
Output 2: [1]*/
public class LL_4 {
    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        // Find middle node
        ListNode slow = A;
        ListNode fast = A;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Break the list into two halves
        prev.next = null;
        // Recursively sort both halves
        ListNode left = sortList(A);
        ListNode right = sortList(slow);
        // Merge both sorted halves
        return merge(left, right);
    }
    private ListNode merge(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (A != null && B != null) {
            if (A.val <= B.val) {
                tail.next = A;
                A = A.next;
            } else {
                tail.next = B;
                B = B.next;
            }
            tail = tail.next;
        }
        if (A != null) {
            tail.next = A;
        }
        if (B != null) {
            tail.next = B;
        }
        return dummy.next;
    }
}
