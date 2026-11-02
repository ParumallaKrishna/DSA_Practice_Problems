package com.scaler.module_2.assignments.DSA_Module_5.Trees_3;
/*Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
Problem Constraints
1 <= number of nodes <= 100000
Input Format
First and only argument is an integer array denoting the preorder traversal of binary tree.
Output Format
Return a string "YES" if true else "NO".
Example Input
Input 1: A : [4, 10, 5, 8]
Input 2: A : [1, 5, 6, 4]
Example Output
Output 1: "YES"
Output 2: "NO"*/
public class Trees_4 {
    public String solve(int[] A) {
        int n = A.length;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] < A[i + 1]) {
                // Moving to right subtree
                min = A[i];
            }
            else {
                // Moving to left subtree
                max = A[i];
            }
            if (A[i + 1] <= min || A[i + 1] >= max) {
                return "NO";
            }
        }
        return "YES";
    }
}
