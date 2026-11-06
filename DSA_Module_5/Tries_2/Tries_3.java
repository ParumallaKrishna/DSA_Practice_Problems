package com.scaler.module_2.assignments.DSA_Module_5.Tries_2;

import java.util.Stack;

/*Given a binary tree A, flatten it to a linked list in-place using preorder traversal.
The left child of all nodes should be NULL.
Problem Constraints
1 <= size of tree <= 100000
Input Format
First and only argument is the head of tree A.
Output Format
Return the linked-list after flattening.
Example Input
Input 1:
     1
    / \
   2   3
Input 2:
         1
        / \
       2   5
      / \   \
     3   4   6
Example Output
Output 1:
1
 \
  2
   \
    3
Output 2:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/
public class Tries_3 {
    public TreeNode flatten(TreeNode a) {
        if (a == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(a);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            // Push right first
            if (curr.right != null) {
                stack.push(curr.right);
            }
            // Push left second
            if (curr.left != null) {
                stack.push(curr.left);
            }
            // Connect previous node to current node
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            prev = curr;
        }
        // Last node should not have children
        prev.left = null;
        prev.right = null;
        return a;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
