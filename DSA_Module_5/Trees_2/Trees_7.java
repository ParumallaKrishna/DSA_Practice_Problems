package com.scaler.module_2.assignments.DSA_Module_5.Trees_2;

import java.util.LinkedList;
import java.util.Queue;

/*You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
NOTE:
In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.
Problem Constraints
1 <= number of nodes <= 105
-1 <= A[i] <= 105
Input Format
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
Output Format
Return the root node of the Binary Tree.
Example Input
Input 1: A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2: A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
Example Output
Output 1:
           1
         /   \
        2     3
       / \
      4   5
Output 2:
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6*/
public class Trees_7 {
    public TreeNode solve(int[] A) {
        if (A == null || A.length == 0 || A[0] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(A[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < A.length) {
            TreeNode curr = queue.poll();
            // Left child
            if (i < A.length && A[i] != -1) {
                curr.left = new TreeNode(A[i]);
                queue.offer(curr.left);
            }
            i++;
            // Right child
            if (i < A.length && A[i] != -1) {
                curr.right = new TreeNode(A[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
