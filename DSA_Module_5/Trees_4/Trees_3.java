package com.scaler.module_2.assignments.DSA_Module_5.Trees_4;
/*Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.
Note 1 :- It is guaranteed that the nodes B and C exist.
Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.
Problem Constraints
1 <= Number of nodes in binary tree <= 105
1 <= B , C <= 105
Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.
Output Format
Return the LCA of the two nodes
Example Input
Input 1:
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8
     B = 8
     C = 20
Input 2:
            8
           / \
          6  21
         / \
        1   7
     B = 7
     C = 1
Example Output
Output 1: 15
Output 2: 6*/
public class Trees_3 {
    public int solve(TreeNode A, int B, int C) {
        TreeNode curr = A;
        while (curr != null) {
            // Both nodes are in the left subtree
            if (B < curr.val && C < curr.val) {
                curr = curr.left;

            }
            // Both nodes are in the right subtree
            else if (B > curr.val && C > curr.val) {
                curr = curr.right;

            }
            // Split point: current node is LCA
            else {
                return curr.val;
            }
        }
        return -1;
    }
}
