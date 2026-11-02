package com.scaler.module_2.assignments.DSA_Module_5.Trees_3;
/*Given a binary search tree of integers. You are given a range B and C.
Return the count of the number of nodes that lie in the given range.
Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= B < = C <= 109
Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.
Output Format
Return the count of the number of nodes that lies in the given range.
Example Input
Input 1:
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8
     B = 12
     C = 20
Input 2:
            8
           / \
          6  21
         / \
        1   7
     B = 2
     C = 20
Example Output
Output 1: 5
Output 2: 3*/
public class Trees_5 {
    public int solve(TreeNode A, int B, int C) {
        if (A == null) {
            return 0;
        }
        int count = 0;
        // Check if current node lies in range
        if (A.val >= B && A.val <= C) {
            count++;
        }
        // Search left subtree only if needed
        if (A.val > B) {
            count += solve(A.left, B, C);
        }
        // Search right subtree only if needed
        if (A.val < C) {
            count += solve(A.right, B, C);
        }
        return count;
    }
}
