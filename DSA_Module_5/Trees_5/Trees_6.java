package com.scaler.module_2.assignments.DSA_Module_5.Trees_5;

import java.util.LinkedList;
import java.util.Queue;

/*Given two binary trees, check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
Problem Constraints
1 <= number of nodes <= 105
Input Format
The first argument is a root node of the first tree, A.
The second argument is a root node of the second tree, B.
Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
Example Input
Input 1:
   1       1
  / \     / \
 2   3   2   3
Input 2:
   1       1
  / \     / \
 2   3   3   3
Example Output
Output 1: 1
Output 2: 0*/
public class Trees_6 {
    public int isSameTree(TreeNode A, TreeNode B) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(A);
        q2.add(B);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            // Both nodes are null
            if (node1 == null && node2 == null) {
                continue;
            }
            // Only one node is null
            if (node1 == null || node2 == null) {
                return 0;
            }
            // Compare node values
            if (node1.val != node2.val) {
                return 0;
            }
            // Add left children
            q1.add(node1.left);
            q2.add(node2.left);
            // Add right children
            q1.add(node1.right);
            q2.add(node2.right);
        }
        return 1;
    }
}
