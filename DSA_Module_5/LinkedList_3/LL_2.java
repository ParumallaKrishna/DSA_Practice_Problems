package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_3;
import java.util.HashMap;
/*You are given a linked list A
Each node in the linked list contains two pointers: a next pointer and a random pointer
The next pointer points to the next node in the list
The random pointer can point to any node in the list, or it can be NULL
Your task is to create a deep copy of the linked list A
The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
You should create a new linked list B, where each node in B has the same value as the corresponding node in A
The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)
Problem Constraints
0 <= |A| <= 106
Input Format
The first argument of input contains a pointer to the head of linked list A.
Output Format
Return a pointer to the head of the required linked list.
Example Input
Given list  1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
Example Output   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  */
public class LL_2 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        // Step 1: Create copies of all nodes
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            map.put(curr, copy);
            curr = curr.next;
        }
        // Step 2: Connect next and random pointers
        curr = head;
        while (curr != null) {
            RandomListNode copy = map.get(curr);
            if (curr.next != null) {
                copy.next = map.get(curr.next);
            }
            if (curr.random != null) {
                copy.random = map.get(curr.random);
            }
            curr = curr.next;
        }
        // Step 3: Return copied head
        return map.get(head);
    }
}
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
