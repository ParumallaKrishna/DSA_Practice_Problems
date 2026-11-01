package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_2;
/*Given a linked list A, swap every two adjacent nodes and return its head.
NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.
Problem Constraints
1 <= |A| <= 106
Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.
Output Format
Return a pointer to the head of the modified linked list.
Example Input
Input 1: A = 1 -> 2 -> 3 -> 4
Input 2: A = 7 -> 2 -> 1
Example Output
Output 1: 2 -> 1 -> 4 -> 3
Output 2: 2 -> 7 -> 1*/
public class LL_5 {
    public ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;
            // Swap the nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;
            // Move to the next pair
            prev = first;
        }
        return dummy.next;
    }
}
