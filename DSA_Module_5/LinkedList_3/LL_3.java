package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_3;
/*Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
You should preserve the original relative order of the nodes in each of the two partitions.
Problem Constraints
1 <= |A| <= 106
1 <= A[i], B <= 109
Input Format
The first argument of input contains a pointer to the head to the given linked list.
The second argument of input contains an integer, B.
Output Format
Return a pointer to the head of the modified linked list.
Example Input
Input 1: A = [1, 4, 3, 2, 5, 2] B = 3
Input 2: A = [1, 2, 3, 1, 3] B = 2
Example Output
Output 1: [1, 2, 2, 4, 3, 5]
Output 2: [1, 1, 2, 3, 3]
*/
public class LL_3 {
    public ListNode partition(ListNode A, int B) {
        ListNode lessDummy = new ListNode(-1);
        ListNode greaterDummy = new ListNode(-1);
        ListNode less = lessDummy;
        ListNode greater = greaterDummy;
        while (A != null) {
            if (A.val < B) {
                less.next = A;
                less = less.next;
            } else {
                greater.next = A;
                greater = greater.next;
            }
            A = A.next;
        }
        greater.next = null;
        less.next = greaterDummy.next;
        return lessDummy.next;
    }
}
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
