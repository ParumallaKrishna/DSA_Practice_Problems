package com.scaler.module_2.assignments.DSA_Module_5.Trees_4;

import java.util.ArrayList;

/*Given a binary tree, return the inorder traversal of its nodes' values.
NOTE: Using recursion and stack are not allowed.
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
public class Trees_2 {
    public int[] solve(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = A;
        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                // Find inorder predecessor
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    // Create temporary link
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    // Remove temporary link
                    temp.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        // Convert ArrayList<Integer> to int[]
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
