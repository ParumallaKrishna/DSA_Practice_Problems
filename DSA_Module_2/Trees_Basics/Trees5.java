package com.scaler.module_2.assignments.DSA_Module_2.Trees_Basics;
/*You are given the root node of a binary tree A. You have to find the number of nodes in this tree.
Problem Constraints
1 <= Number of nodes in the tree <= 105
0 <= Value of each node <= 107
Input Format
The first and only argument is a tree node A.
Output Format
Return an integer denoting the number of nodes of the tree.
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
Output 1:
 3
Output 2:
 4 */
public class Trees5 {
    public int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return 1 + solve(A.left) + solve(A.right);
    }
}
