package com.scaler.module_2.assignments.DSA_Module_5.Trees_1;

import java.util.ArrayList;
import java.util.Stack;

/*Given a binary tree, return the preorder traversal of its nodes values.
Problem Constraints
1 <= number of nodes <= 105
Input Format
First and only argument is root node of the binary tree, A.
Output Format
Return an integer array denoting the preorder traversal of the given binary tree.
Example Input
Input 1:
   1
    \
     2
    /
   3
Input 2:
   1
  / \
 6   2
    /
   3
Example Output
Output 1: [1, 2, 3]
Output 2: [1, 6, 2, 3]*/
public class Trees_3 {
    public int[] preorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) {
            return new int[0];
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            // Visit root
            ans.add(curr.val);
            // Push right first
            if (curr.right != null) {
                stack.push(curr.right);
            }
            // Push left second
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        // Convert ArrayList to int[]
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
