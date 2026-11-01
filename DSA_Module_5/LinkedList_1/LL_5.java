package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_1;
/*You are given the head of a singly linked list A and an integer B.
Reverse the nodes of A in groups of B consecutive nodes, traversing the list from beginning to end. Each group is reversed independently, and the relative order of the groups themselves stays the same. Return the head of the resulting list.
Problem Constraints
1 <= |A| <= 103
1 <= B <= |A|
B always divides |A| (the length of the list).
1 <= value of any node <= 109
Input Format
The first argument is a pointer to the head of the linked list A.
The second argument is the integer B.
Output Format
Return a pointer to the head of the modified linked list.
Example Input
Input 1: A = 1 -> 2 -> 3 -> 4 -> 5 -> 6 B = 2
Input 2: A = 1 -> 2 -> 3 -> 4 -> 5 -> 6 B = 3
Example Output
Output 1: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Output 2: 3 -> 2 -> 1 -> 6 -> 5 -> 4*/
public class LL_5 {
    public ListNode reverseList(ListNode A, int B) {
        if (A == null || B == 1) {
            return A;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode groupPrev = dummy;
        while (groupPrev.next != null) {
            ListNode groupStart = groupPrev.next;
            ListNode prev = null;
            ListNode curr = groupStart;
            // Reverse B nodes
            for (int i = 0; i < B; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            // Connect the reversed group
            groupPrev.next = prev;
            // Original first node becomes the last node
            groupStart.next = curr;
            // Move to the previous node of the next group
            groupPrev = groupStart;
        }
        return dummy.next;
    }
}
