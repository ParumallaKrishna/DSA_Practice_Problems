package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_1;
/*Given a sorted linked list, delete all duplicates such that each element appears only once.
Problem Constraints
0 <= length of linked list <= 106
Input Format
First argument is the head pointer of the linked list.
Output Format
Return the head pointer of the linked list after removing all duplicates.
Example Input
Input 1: 1->1->2
Input 2: 1->1->2->3->3
Example Output
Output 1: 1->2
Output 2: 1->2->3*/
public class LL_4 {
    public ListNode deleteDuplicates(ListNode A) {
        if (A == null) {
            return null;
        }
        ListNode curr = A;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // Remove duplicate node
                curr.next = curr.next.next;
            } else {
                // Move to next distinct node
                curr = curr.next;
            }
        }
        return A;
    }
}
