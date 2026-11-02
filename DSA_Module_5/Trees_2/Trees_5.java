package com.scaler.module_2.assignments.DSA_Module_5.Trees_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).
Problem Constraints
1 <= number of nodes <= 105
Input Format
First and only argument is root node of the binary tree, A.
Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
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
   [20, 9],
   [15, 7]
 ]
Output 2:
 [
   [1]
   [2, 6]
   [3]
 ]
*/
public class Trees_5 {
    public int[][] zigzagLevelOrder(TreeNode A) {
        if (A == null) {
            return new int[0][];
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // Reverse alternate levels
            if (!leftToRight) {
                Collections.reverse(level);
            }
            ans.add(level);
            // Change direction
            leftToRight = !leftToRight;
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
