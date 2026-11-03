package com.scaler.module_2.assignments.DSA_Module_5.Trees_5;

import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree A, invert the binary tree and return it.
Inverting refers to making the left child the right child and vice versa.
Problem Constraints
1 <= size of tree <= 100000
Input Format
First and only argument is the head of the tree A.
Output Format
Return the head of the inverted tree.
Example Input
Input 1:
     1
   /   \
  2     3
Input 2:
     1
   /   \
  2     3
 / \   / \
4   5 6   7
Example Output
Output 1:
     1
   /   \
  3     2
Output 2:
     1
   /   \
  3     2
 / \   / \
7   6 5   4
*/
public class Trees_1 {
    public TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            // Swap left and right children
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            // Add children to queue
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return A;
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
