package com.scaler.module_2.assignments.DSA_Module_5.Trees_1;

import java.util.HashMap;

/*Given the inorder and postorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.
Problem Constraints
1 <= number of nodes <= 105
Input Format
First argument is an integer array A denoting the inorder traversal of the tree.
Second argument is an integer array B denoting the postorder traversal of the tree.
Output Format
Return the root node of the binary tree.
Example Input
Input 1: A = [2, 1, 3] B = [2, 3, 1]
Input 2: A = [6, 1, 3, 2] B = [6, 3, 2, 1]
Example Output
Output 1:
   1
  / \
 2   3
Output 2:
   1
  / \
 6   2
    /
   3*/
public class Trees_2 {
    public TreeNode buildTree(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Store inorder element and its index
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        return construct(A, B, map, 0, A.length - 1,
                0, B.length - 1);
    }
    private TreeNode construct(int[] A, int[] B,
                               HashMap<Integer, Integer> map,
                               int inStart, int inEnd,
                               int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        // Last element of postorder is root
        int rootVal = B[postEnd];
        TreeNode root = new TreeNode(rootVal);
        // Find root position in inorder
        int rootIndex = map.get(rootVal);
        // Number of nodes in left subtree
        int leftSize = rootIndex - inStart;
        // Construct left subtree
        root.left = construct(A, B, map,
                inStart, rootIndex - 1,
                postStart, postStart + leftSize - 1);
        // Construct right subtree
        root.right = construct(A, B, map,
                rootIndex + 1, inEnd,
                postStart + leftSize, postEnd - 1);
        return root;
    }
}
