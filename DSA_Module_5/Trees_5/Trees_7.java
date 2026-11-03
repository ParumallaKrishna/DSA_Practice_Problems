package com.scaler.module_2.assignments.DSA_Module_5.Trees_5;
import java.util.HashMap;
import java.util.Stack;
/*Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
Problem Constraints
1 <= size of tree <= 100000
0 <= value of node <= 109
Input Format
First and only argument is head of tree A.
Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.
Example Input
Input 1:
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:
                1
               / \
              2   10
                  / \
                 20  2
Example Output
Output 1: 1
Output 2: 0*/
public class Trees_7 {
    public int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Long> map = new HashMap<>();
        stack.push(A);
        long totalSum = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr.left != null && !map.containsKey(curr.left)) {
                stack.push(curr.left);
            }
            else if (curr.right != null && !map.containsKey(curr.right)) {
                stack.push(curr.right);
            }
            else {
                stack.pop();
                long leftSum = (curr.left == null) ? 0 : map.get(curr.left);
                long rightSum = (curr.right == null) ? 0 : map.get(curr.right);
                long currSum = curr.val + leftSum + rightSum;
                map.put(curr, currSum);
            }
        }
        totalSum = map.get(A);
        if (totalSum % 2 != 0) {
            return 0;
        }
        long target = totalSum / 2;
        for (TreeNode node : map.keySet()) {
            // Root cannot be removed because exactly one edge is required
            if (node != A && map.get(node) == target) {
                return 1;
            }
        }
        return 0;
    }
}
