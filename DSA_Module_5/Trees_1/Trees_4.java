package com.scaler.module_2.assignments.DSA_Module_5.Trees_1;

import java.util.HashMap;

/*Given preorder and inorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.
Problem Constraints
1 <= number of nodes <= 105
Input Format
First argument is an integer array A denoting the preorder traversal of the tree.
Second argument is an integer array B denoting the inorder traversal of the tree.
Output Format
Return the root node of the binary tree.
Example Input
Input 1: A = [1, 2, 3] B = [2, 1, 3]
Input 2: A = [1, 6, 2, 3] B = [6, 1, 3, 2]
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
public class Trees_4 {
    public TreeNode buildTree(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Store inorder elements and their indices
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        return construct(A, map, 0, A.length - 1,
                0, B.length - 1);
    }
    private TreeNode construct(int[] A,
                               HashMap<Integer, Integer> map,
                               int preStart, int preEnd,
                               int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // First element of preorder is the root
        int rootVal = A[preStart];
        TreeNode root = new TreeNode(rootVal);
        // Find root position in inorder
        int rootIndex = map.get(rootVal);
        // Number of nodes in left subtree
        int leftSize = rootIndex - inStart;
        // Construct left subtree
        root.left = construct(A, map,
                preStart + 1,
                preStart + leftSize,
                inStart,
                rootIndex - 1);
        // Construct right subtree
        root.right = construct(A, map,
                preStart + leftSize + 1,
                preEnd,
                rootIndex + 1,
                inEnd);
        return root;
    }
}
