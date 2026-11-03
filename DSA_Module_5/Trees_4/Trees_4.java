package com.scaler.module_2.assignments.DSA_Module_5.Trees_4;
/*Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9
Input Format
First and only argument is head of the binary tree A.
Output Format
Return an integer, representing the Bth element.
Example Input
Input 1:
            2
          /   \
         1    3
B = 2
Input 2:
            3
           /
          2
         /
        1
B = 1
Example Output
Output 1: 2
Output 2: 1*/
public class Trees_4 {
    public int kthsmallest(TreeNode A, int B) {
        TreeNode curr = A;
        int count = 0;
        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == B) {
                    return curr.val;
                }
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                // Find inorder predecessor
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    count++;
                    if (count == B) {
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}
