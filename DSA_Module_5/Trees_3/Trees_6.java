package com.scaler.module_2.assignments.DSA_Module_5.Trees_3;

import java.util.HashSet;

/*Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
Return 1 to denote that two such nodes exist. Return 0, otherwise.
Problem Constraints
1 <= size of tree <= 100000
1 <= B <= 109
Input Format
First argument is the head of the tree A.
Second argument is the integer B.
Output Format
Return 1 if such a pair can be found, 0 otherwise.
Example Input
Input 1:
         10
         / \
        9   20
B = 19
Input 2:
          10
         / \
        9   20
B = 40
Example Output
Output 1: 1
Output 2: 0
*/
public class Trees_6 {
    public int t2Sum(TreeNode A, int B) {
        HashSet<Integer> set = new HashSet<>();

        return check(A, B, set);
    }
    private int check(TreeNode root, int B, HashSet<Integer> set) {
        if (root == null) {
            return 0;
        }
        int complement = B - root.val;
        if (set.contains(complement)) {
            return 1;
        }
        set.add(root.val);
        if (check(root.left, B, set) == 1) {
            return 1;
        }
        if (check(root.right, B, set) == 1) {
            return 1;
        }
        return 0;
    }
}
