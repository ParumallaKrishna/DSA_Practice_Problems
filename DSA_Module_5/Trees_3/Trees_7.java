package com.scaler.module_2.assignments.DSA_Module_5.Trees_3;
/*Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Problem Constraints
1 <= length of array <= 100000
Input Format
First argument is an integer array A.
Output Format
Return a root node of the Binary Search Tree.
Example Input
Input 1: A : [1, 2, 3]
Input 2: A : [1, 2, 3, 5, 10]
Example Output
Output 1:
      2
    /   \
   1     3
Output 2:
      3
    /   \
   2     5
  /       \
 1         10*/
public class Trees_7 {
    public TreeNode sortedArrayToBST(final int[] A) {
        return build(A, 0, A.length - 1);
    }
    private TreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        // Find middle element
        int mid = start + (end - start) / 2;
        // Create root node
        TreeNode root = new TreeNode(A[mid]);
        // Build left subtree
        root.left = build(A, start, mid - 1);
        // Build right subtree
        root.right = build(A, mid + 1, end);
        return root;
    }
}
