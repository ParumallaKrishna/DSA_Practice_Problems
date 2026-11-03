package com.scaler.module_2.assignments.DSA_Module_5.Trees_4;

/*Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
Problem Constraints
1 <= size of tree <= 100000
1 <= B, C <= 109
Input Format
First argument is head of tree A.
Second argument is integer B.
Third argument is integer C.
Output Format
Return the LCA.
Example Input
Input 1:
      1
     /  \
    2    3
B = 2
C = 3
Input 2:
      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5
Example Output
Output 1: 1
Output 2: 2
*/
public class Trees_1 {
    public int lca(TreeNode A, int B, int C) {
        if (!find(A, B) || !find(A, C)) {
            return -1;
        }
        TreeNode ans = findLCA(A, B, C);

        return ans.val;
    }

    public TreeNode findLCA(TreeNode root, int B, int C) {

        if (root == null) {
            return null;
        }

        if (root.val == B || root.val == C) {
            return root;
        }

        TreeNode left = findLCA(root.left, B, C);
        TreeNode right = findLCA(root.right, B, C);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }

    public boolean find(TreeNode root, int target) {

        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        return find(root.left, target) || find(root.right, target);
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
