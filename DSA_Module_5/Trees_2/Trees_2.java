package com.scaler.module_2.assignments.DSA_Module_5.Trees_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
Problem Constraints
0 <= number of nodes <= 105
Input Format
First and only arument is a pointer to the root node of binary tree, A.
Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.
Example Input
Input 1:
      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:
      1
    /   \
   3     7
  /       \
 2         9
Example Output
Output 1:
 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:
 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]
*/
public class Trees_2 {
    public int[][] verticalOrderTraversal(TreeNode A) {
        if (A == null) {
            return new int[0][];
        }
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.offer(A);
        colQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.poll();
            int col = colQueue.poll();
            // Add current node to its column
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(curr.val);
            // Process left child
            if (curr.left != null) {
                nodeQueue.offer(curr.left);
                colQueue.offer(col - 1);
            }
            // Process right child
            if (curr.right != null) {
                nodeQueue.offer(curr.right);
                colQueue.offer(col + 1);
            }
        }
        // Convert TreeMap into 2D array
        int[][] result = new int[map.size()][];
        int index = 0;
        for (ArrayList<Integer> list : map.values()) {
            result[index] = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[index][i] = list.get(i);
            }
            index++;
        }
        return result;
    }
}
