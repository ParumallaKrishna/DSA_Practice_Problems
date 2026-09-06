package com.scaler.module_2.assignments.DSA_Module_2.LinkedList;
/*Given heads of two linked lists A and B, check if they are identical i.e. each of their corresponding nodes should contain the same data. The two given linked lists may or may not be of the same length.
Problem Constraints
1 <= size of linked lists <= 105
1 <= value of each node <= 109
Input Format
You are given the head of two linked lists A and B.
Output Format
Return 1 if both the linked lists are identical and 0 otherwise
Example Input
Input 1:
A = 1 -> 2 -> 3
B = 1 -> 2 -> 3
Input 2:
A = 4 -> 3 -> 2 -> 1
B = 4 -> 2 -> 3 -> 1
Example Output
Output 1: 1
Output 2: 0*/
public class LL6 {
    public int solve(ListNode A, ListNode B) {
        ListNode p = A;
        ListNode q = B;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return 0;
            }
            p = p.next;
            q = q.next;
        }
        // Both lists must end at the same time
        if (p == null && q == null) {
            return 1;
        }
        return 0;
    }
}
