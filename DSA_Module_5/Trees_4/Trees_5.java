package com.scaler.module_2.assignments.DSA_Module_5.Trees_4;

import java.util.Stack;

/*Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
In case there is no common node, return 0.
NOTE:
Try to do it one pass through the trees.
Problem Constraints
1 <= Number of nodes in the tree A and B <= 105
1 <= Node values <= 106
Input Format
First argument represents the root of BST A.
Second argument represents the root of BST B.
Output Format
Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .
Example Input
Input 1:
 Tree A:
    5
   / \
  2   8
   \   \
    3   15
        /
        9
 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11
Input 2:
  Tree A:
    7
   / \
  1   10
   \   \
    2   15
        /
       11
 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11
Example Output
Output 1: 17
Output 2: 46*/
public class Trees_5 {
    public int solve(TreeNode A, TreeNode B) {
        final int MOD = 1000000007;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        long sum = 0;
        while (A != null || B != null ||
                !s1.isEmpty() || !s2.isEmpty()) {
            // Push left nodes of Tree A
            while (A != null) {
                s1.push(A);
                A = A.left;
            }
            // Push left nodes of Tree B
            while (B != null) {
                s2.push(B);
                B = B.left;
            }
            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }
            TreeNode node1 = s1.peek();
            TreeNode node2 = s2.peek();
            if (node1.val == node2.val) {
                sum = (sum + node1.val) % MOD;
                A = s1.pop().right;
                B = s2.pop().right;
            } else if (node1.val < node2.val) {
                A = s1.pop().right;
            } else {
                B = s2.pop().right;
            }
        }
        return (int) sum;
    }
}
