package com.scaler.module_2.assignments.DSA_Module_5.Trees_1;

import java.util.ArrayList;
import java.util.Stack;

/*Given a binary tree, return the inorder traversal of its nodes' values.
Problem Constraints
1 <= number of nodes <= 105
Input Format
First and only argument is root node of the binary tree, A.
Output Format
Return an integer array denoting the inorder traversal of the given binary tree.
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
Output 1: [1, 3, 2]
Output 2: [6, 1, 3, 2]*/
public class Trees_1 {
    public int[] inorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = A;
        while (curr != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Process the current node
            curr = stack.pop();
            ans.add(curr.val);
            // Visit the right subtree
            curr = curr.right;
        }
        // Convert ArrayList to int[]
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
     }
