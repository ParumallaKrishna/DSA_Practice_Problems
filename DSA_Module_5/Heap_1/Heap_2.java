package com.scaler.module_2.assignments.DSA_Module_5.Heap_1;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.
Problem Constraints
1 <= total number of elements in given linked lists <= 100000
Input Format
The first and only argument is a list containing N head pointers.
Output Format
Return a pointer to the head of the sorted linked list after merging all the given linked lists.
Example Input
Input 1:
 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
Input 2:
 10 -> 12
 13
 5 -> 6
Example Output
Output 1: 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
Output 2: 5 -> 6 -> 10 -> 12 ->13*/
public class Heap_2 {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (x, y) -> Integer.compare(x.val, y.val)
        );
        // Add head nodes of all linked lists
        for (ListNode node : a) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            // Get smallest node
            ListNode curr = pq.poll();
            // Connect to merged list
            tail.next = curr;
            tail = tail.next;
            // Add next node from the same list
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        tail.next = null;
        return dummy.next;
    }
}
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
