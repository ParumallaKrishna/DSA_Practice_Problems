package com.scaler.module_2.assignments.DSA_Module_5.Trees_5;

import java.util.HashMap;
import java.util.Stack;

/*Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
Problem Constraints
0 <= N <= 105
Input Format
First and only Argument represents the root of binary tree A.
Output Format
Return an single integer denoting the diameter of the tree.
Example Input
Input 1:
           1
         /   \
        2     3
       / \
      4   5
Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6
Example Output
Output 1: 3
Output 2: 4*/
public class Trees_4 {
    public int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Integer> height = new HashMap<>();
        stack.push(A);
        int diameter = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            // Visit left subtree
            if (curr.left != null && !height.containsKey(curr.left)) {
                stack.push(curr.left);
            }
            // Visit right subtree
            else if (curr.right != null && !height.containsKey(curr.right)) {
                stack.push(curr.right);
            }
            else {
                stack.pop();
                int leftHeight = (curr.left == null) ? 0 : height.get(curr.left);
                int rightHeight = (curr.right == null) ? 0 : height.get(curr.right);
                // Calculate height of current node
                height.put(curr, 1 + Math.max(leftHeight, rightHeight));
                // Calculate diameter through current node
                diameter = Math.max(diameter, leftHeight + rightHeight);
            }
        }
        return diameter;
    }
}
