package com.scaler.module_2.assignments.DSA_Module_5.Trees_1;
import java.util.ArrayList;
import java.util.Stack;
/*Given a binary tree, return the Postorder traversal of its nodes values.
Problem Constraints
1 <= number of nodes <= 105
Input Format
First and only argument is root node of the binary tree, A.
Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.
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
Output 1: [3, 2, 1]
Output 2: [6, 3, 2, 1]*/
public class Trees_5 {
    public int[] postorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) {
            return new int[0];
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(A);
        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }
        // Process nodes in postorder
        while (!stack2.isEmpty()) {
            ans.add(stack2.pop().val);
        }
        // Convert ArrayList to int[]
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
