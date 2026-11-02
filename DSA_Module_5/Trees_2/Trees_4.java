package com.scaler.module_2.assignments.DSA_Module_5.Trees_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Problem Constraints
1 <= number of nodes <= 105
Input Format
First and only argument is root node of the binary tree, A.
Output Format
Return a 2D integer array denoting the level order traversal of the given binary tree.
Example Input
Input 1:
    3
   / \
  9  20
    /  \
   15   7
Input 2:
   1
  / \
 6   2
    /
   3
Example Output
Output 1:
 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:
 [
   [1]
   [6, 2]
   [3]
 ]
*/
public class Trees_4 {
    public int[][] solve(TreeNode A) {
        if (A == null) {
            return new int[0][];
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                // Store current node value
                level.add(curr.val);
                // Add left child
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                // Add right child
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ans.add(level);
        }
        // Convert ArrayList to int[][]
        int[][] result = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = new int[ans.get(i).size()];
            for (int j = 0; j < ans.get(i).size(); j++) {
                result[i][j] = ans.get(i).get(j);
            }
        }
        return result;
    }
}
