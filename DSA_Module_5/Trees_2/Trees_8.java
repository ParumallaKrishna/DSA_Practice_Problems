package com.scaler.module_2.assignments.DSA_Module_5.Trees_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
Return the nodes in any order.
Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9
Input Format
First and only argument is head of the binary tree A.
Output Format
Return an array, representing the top view of the binary tree.
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
Output 1: [1, 2, 4, 8, 3, 7]
Output 2: [1, 2, 3]*/
public class Trees_8 {
    public int[] solve(TreeNode A) {
        if (A == null) {
            return new int[0];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(A, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int hd = p.hd;
            // Store only the first node at this horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }
        int[] ans = new int[map.size()];
        int i = 0;
        for (int val : map.values()) {
            ans[i++] = val;
        }
        return ans;
    }
    class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
