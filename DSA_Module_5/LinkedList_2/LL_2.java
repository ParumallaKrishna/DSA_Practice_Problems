package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_2;
/*Given a linked list of integers, find and return the middle element of the linked list.
NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
Problem Constraints
1 <= length of the linked list <= 100000
1 <= Node value <= 109
Input Format
The only argument given head pointer of linked list.
Output Format
Return the middle element of the linked list.
Example Input
Input 1: 1 -> 2 -> 3 -> 4 -> 5
Input 2: 1 -> 5 -> 6 -> 2 -> 3 -> 4
Example Output
Output 1: 3
Output 2: 2*/
public class LL_2 {
    public int solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
}
