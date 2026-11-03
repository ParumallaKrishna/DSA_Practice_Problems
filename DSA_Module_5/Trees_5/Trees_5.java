package com.scaler.module_2.assignments.DSA_Module_5.Trees_5;

import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Problem Constraints
1 <= number of nodes <= 105
Input Format
First and only argument is the root node of the binary tree.
Output Format
Return 0 / 1 ( 0 for false, 1 for true ).
Example Input
Input 1:
    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:
    1
   / \
  2   2
   \   \
   3    3
Example Output
Output 1: 1
Output 2: 0*/
public class Trees_5 {
    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A.left);
        queue.add(A.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // Both nodes are null
            if (left == null && right == null) {
                continue;
            }
            // Only one node is null
            if (left == null || right == null) {
                return 0;
            }
            // Values are different
            if (left.val != right.val) {
                return 0;
            }
            // Compare mirror positions
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return 1;
    }
}
