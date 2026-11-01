package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_2;
/*Merge two sorted linked lists, A and B, and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
Problem Constraints
0 <= |A|, |B| <= 105
Input Format
The first argument of input contains a pointer to the head of linked list A.
The second argument of input contains a pointer to the head of linked list B.
Output Format
Return a pointer to the head of the merged linked list.
Example Input
Input 1: A = 5 -> 8 -> 20 B = 4 -> 11 -> 15
Input 2: A = 1 -> 2 -> 3 B = Null
Example Output
Output 1: 4 -> 5 -> 8 -> 11 -> 15 -> 20
Output 2: 1 -> 2 -> 3*/
public class LL_3 {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
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
