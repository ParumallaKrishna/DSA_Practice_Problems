package com.scaler.module_2.assignments.DSA_Module_5.Trees_2;
/*Given a root of binary tree A, determine if it is height-balanced.
A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Problem Constraints
1 <= size of tree <= 100000
Input Format
First and only argument is the root of the tree A.
Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
Example Input
Input 1:
    1
   / \
  2   3
Input 2:
       1
      /
     2
    /
   3
Example Output
Output 1: 1
Output 2:0*/
public class Trees_3 {
    public int isBalanced(TreeNode A) {
        return checkHeight(A) == -1 ? 0 : 1;
    }
    private int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Calculate left subtree height
        int left = checkHeight(root.left);
        if (left == -1) {
            return -1;
        }
        // Calculate right subtree height
        int right = checkHeight(root.right);
        if (right == -1) {
            return -1;
        }
        // Check balance condition
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        // Return current subtree height
        return Math.max(left, right) + 1;
    }
}
