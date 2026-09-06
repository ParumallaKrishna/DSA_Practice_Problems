package com.scaler.module_2.assignments.DSA_Module_2.Trees_Basics;

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
Output 1:
 [1, 2, 3]
Output 2:
 [1, 6, 2, 3]*/
public class Trees2 {
    public int[] preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (A != null) {
            stack.push(A);
        }
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);
            // Push right first so left is processed first
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
