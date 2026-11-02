package com.scaler.module_2.assignments.DSA_Module_5.Trees_3;
/*You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
Assume a BST is defined as follows:
1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.
Problem Constraints
1 <= Number of nodes in binary tree <= 105
0 <= node values <= 232-1
Input Format
First and only argument is head of the binary tree A.
Output Format
Return 0 if false and 1 if true.
Example Input
Input 1:
    1
   / \
  2   3
Input 2:
  2
 / \
1   3
Example Output
Output 1: 0
Output 2: 1
*/
public class Trees_1 {
    public int isValidBST(TreeNode A) {
        return check(A, Long.MIN_VALUE, Long.MAX_VALUE) ? 1 : 0;
    }
    private boolean check(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return check(root.left, min, root.val) &&
                check(root.right, root.val, max);
    }
}
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }