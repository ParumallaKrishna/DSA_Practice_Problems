package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_2;
/*You are given two linked lists, A and B, representing two non-negative numbers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return it as a linked list.
Problem Constraints
1 <= |A|, |B| <= 105
Input Format
The first argument of input contains a pointer to the head of linked list A.
The second argument of input contains a pointer to the head of linked list B.
Output Format
Return a pointer to the head of the required linked list.
Example Input
Input 1: A = [2, 4, 3] B = [5, 6, 4]
Input 2: A = [9, 9] B = [1]
Example Output
Output 1: [7, 0, 8]
Output 2: [0, 0, 1]*/
public class LL_7 {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (A != null || B != null || carry != 0) {
            int sum = carry;
            if (A != null) {
                sum += A.val;
                A = A.next;
            }
            if (B != null) {
                sum += B.val;
                B = B.next;
            }
            int digit = sum % 10;
            carry = sum / 10;
            tail.next = new ListNode(digit);
            tail = tail.next;
        }
        return dummy.next;
    }
}
