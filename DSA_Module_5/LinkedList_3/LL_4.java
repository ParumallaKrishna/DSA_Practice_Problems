package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_3;
/*Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
NOTE:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
The custom input to be given is different than the one explained in the examples. Please be careful.
Problem Constraints
0 <= |A|, |B| <= 106
Input Format
The first argument of input contains a pointer to the head of the linked list A.
The second argument of input contains a pointer to the head of the linked list B.
Output Format
Return a pointer to the node after which the linked list is intersecting.
Example Input
Input 1: A = [1, 2, 3, 4, 5] B = [6, 3, 4, 5]
Input 2: A = [1, 2, 3] B = [4, 5]
Example Output
Output 1: [3, 4, 5]
Output 2: []
*/
public class LL_4 {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if (A == null || B == null) {
            return null;
        }
        ListNode p1 = A;
        ListNode p2 = B;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = B;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = A;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
