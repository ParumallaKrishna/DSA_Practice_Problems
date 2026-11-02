package com.scaler.module_2.assignments.DSA_Module_5.Trees_3;
/*Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.
Note - If there are multiple options, always replace a node by its in-order predecessor
Problem Constraints
2 <= No. of nodes in BST <= 105
1 <= value of nodes <= 109
Each node has a unique value
Input Format
The first argument is the root node of a Binary Search Tree A.
The second argument is the value B.
Output Format
Delete the given node if found and return the root of the BST.
Example Input
Input 1:
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8
     B = 10
Input 2:
            8
           / \
          6  21
         / \
        1   7
     B = 6
Example Output
Output 1:
            15
          /    \
        12      20
        / \    /  \
       8  14  16  27
Output 2:
            8
           / \
          1  21
           \
            7
*/
public class Trees_3 {
    public TreeNode solve(TreeNode A, int B) {
        if (A == null) {
            return null;
        }
        // Search for the node
        if (B < A.val) {
            A.left = solve(A.left, B);
        }
        else if (B > A.val) {
            A.right = solve(A.right, B);
        }
        else {
            // Case 1: No left child
            if (A.left == null) {
                return A.right;
            }
            // Case 2: No right child
            if (A.right == null) {
                return A.left;
            }
            // Case 3: Two children
            // Find inorder predecessor (maximum in left subtree)
            TreeNode temp = A.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            // Replace current node's value
            A.val = temp.val;
            // Delete predecessor from left subtree
            A.left = solve(A.left, temp.val);
        }
        return A;
    }
}
