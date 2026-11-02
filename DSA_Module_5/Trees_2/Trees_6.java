package com.scaler.module_2.assignments.DSA_Module_5.Trees_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
NOTE:
In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.
Problem Constraints
1 <= number of nodes <= 105
Input Format
Only argument is a A denoting the root node of a Binary Tree.
Output Format
Return an integer array denoting the Level Order Traversal of the given Binary Tree.
Example Input
Input 1:
           1
         /   \
        2     3
       / \
      4   5
Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6
Example Output
Output 1: [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Output 2: [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]*/
public class Trees_6 {
    public int[] solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                ans.add(-1);
            } else {
                ans.add(curr.val);
                // Add both children, even if they are null
                queue.offer(curr.left);
                queue.offer(curr.right);
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
