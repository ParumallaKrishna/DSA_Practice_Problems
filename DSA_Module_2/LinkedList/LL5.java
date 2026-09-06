package com.scaler.module_2.assignments.DSA_Module_2.LinkedList;
/*You are given the head of a linked list A and an integer B. You need to find the B-th element of the linked list and return its value.
Note : Follow 0-based indexing for the node numbering.
Problem Constraints
1 <= size of linked list <= 105
1 <= value of nodes <= 109
0 <= B < size of linked list
Input Format
The first argument A is the head of a linked list.
The second arguement B is an integer.
Output Format
Return an integer.
Example Input
Input 1: A = 1 -> 2 -> 3 B = 0
Input 2: A = 4 -> 3 -> 2 -> 1 B = 1
Example Output
Output 1: 1
Output 2: 3*/
public class LL5 {
    public int solve(ListNode A, int B) {
        ListNode current = A;
        for (int i = 0; i < B; i++) {
            current = current.next;
        }
        return current.val;
    }
}
