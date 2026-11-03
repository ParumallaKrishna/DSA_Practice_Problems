package com.scaler.module_2.assignments.DSA_Module_5.Trees_4;
/*Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
NOTE: Distance between two nodes is number of edges between them.
Problem Constraints
1 <= Number of nodes in binary tree <= 1000000
0 <= node values <= 109
Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.
Output Format
Return an integer denoting the distance between two nodes with given two keys B and C
Example Input
Input 1:
         5
       /   \
      2     8
     / \   / \
    1   4 6   11
 B = 2
 C = 11
Input 2:
         6
       /   \
      2     9
     / \   / \
    1   4 7   10
 B = 2
 C = 6
Example Output
Output 1: 3
Output 2: 1*/
public class Trees_6 {
    public int solve(TreeNode A, int B, int C) {
        TreeNode curr = A;
        // Find LCA
        while (curr != null) {
            if (B < curr.val && C < curr.val) {
                curr = curr.left;
            }
            else if (B > curr.val && C > curr.val) {
                curr = curr.right;
            }
            else {
                break;
            }
        }
        // Calculate distance from LCA to B and C
        int d1 = findDistance(curr, B);
        int d2 = findDistance(curr, C);
        return d1 + d2;
    }
    public int findDistance(TreeNode root, int target) {
        int distance = 0;
        while (root != null) {
            if (target < root.val) {
                root = root.left;
                distance++;
            }
            else if (target > root.val) {
                root = root.right;
                distance++;
            }
            else {
                return distance;
            }
        }
        return -1;
    }
}
