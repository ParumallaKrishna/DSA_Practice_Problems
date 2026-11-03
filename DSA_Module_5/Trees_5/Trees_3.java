package com.scaler.module_2.assignments.DSA_Module_5.Trees_5;

import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Problem Constraints
1 <= number of nodes <= 105
-100000 <= B, value of nodes <= 100000
Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B denoting the sum.
Output Format
Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.
Example Input
Input 1:
 Tree:    5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
 B = 22
Input 2:
 Tree:    5
         / \
        4   8
       /   / \
     -11 -13  4
 B = -1
Example Output
Output 1: 1
Output 2: 0*/
public class Trees_3 {
    public int hasPathSum(TreeNode A, int B) {
        if (A == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(A);
        sumQueue.add(A.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.poll();
            int sum = sumQueue.poll();
            // Check leaf node
            if (curr.left == null && curr.right == null) {
                if (sum == B) {
                    return 1;
                }
            }
            // Add left child
            if (curr.left != null) {
                nodeQueue.add(curr.left);
                sumQueue.add(sum + curr.left.val);
            }
            // Add right child
            if (curr.right != null) {
                nodeQueue.add(curr.right);
                sumQueue.add(sum + curr.right.val);
            }
        }
        return 0;
    }
}
