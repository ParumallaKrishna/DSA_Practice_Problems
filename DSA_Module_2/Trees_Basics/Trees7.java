package com.scaler.module_2.assignments.DSA_Module_2.Trees_Basics;
/*Given a binary tree, find and return the sum of node value of all left leaves in it.
Problem Constraints
1 <= number of nodes <= 5 * 105
1 <= node value <= 105
Input Format
First and only argument is a pointer to the root node of the Binary Tree, A.
Output Format
Return an integer denoting the sum of node value of all left leaves in it.
Example Input
Input 1:
    3
   / \
  9  20
    /  \
   15   7
Input 2:
   1
  / \
 6   2
    /
   3
Example Output
Output 1:
 24
Output 2:
 9*/
public class Trees7 {
    public int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int sum = 0;
        if (A.left != null) {
            if (A.left.left == null && A.left.right == null) {
                sum += A.left.val;
            } else {
                sum += solve(A.left);
            }
        }
        sum += solve(A.right);
        return sum;
    }
}
