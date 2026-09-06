package com.scaler.module_2.assignments.DSA_Module_2.Trees_Basics;
/*You are given the root node of a binary tree A. You have to find the height of the given tree.
A binary tree's height is the number of nodes along the longest path from the root node down to the farthest leaf node.
Problem Constraints
1 <= Number of nodes in the tree <= 105
0 <= Value of each node <= 109
Input Format
The first and only argument is a tree node A.
Output Format
Return an integer denoting the height of the tree.
Example Input
Input 1:
 Values =  1
          / \
         4   3
Input 2:
 Values =  1
          / \
         4   3
        /
       2
Example Output
Output 1: 2
Output 2: 3 */
public class Trees4 {
    public int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int leftHeight = solve(A.left);
        int rightHeight = solve(A.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
