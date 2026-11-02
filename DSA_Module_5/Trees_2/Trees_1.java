package com.scaler.module_2.assignments.DSA_Module_5.Trees_2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9
Input Format
First and only argument is head of the binary tree A.
Output Format
Return an array, representing the right view of the binary tree.
Example Input
Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5
Example Output
Output 1: [1, 3, 7, 8]
Output 2: [1, 3, 4, 5]*/
public class Trees_1 {
    public int[] solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();

                // Last node at this level
                if (i == size - 1) {
                    ans.add(curr.val);
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
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
