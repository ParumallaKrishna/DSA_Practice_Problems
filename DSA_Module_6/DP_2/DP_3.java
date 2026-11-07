package com.scaler.module_2.assignments.DSA_Module_6.DP_2;
/*Given an integer A, how many structurally unique BST's (binary search trees) exist that can store values 1...A?



Problem Constraints

1 <= A <=18



Input Format

First and only argument is the integer A



Output Format

Return a single integer, the answer to the problem



Example Input

Input 1:

 1
Input 2:

 2


Example Output

Output 1:

 1
Output 2:

 2*/
public class DP_3 {
    public int numTrees(int A) {

        int[] dp = new int[A + 1];

        dp[0] = 1;

        for (int n = 1; n <= A; n++) {

            dp[n] = 0;

            for (int root = 1; root <= n; root++) {

                int left = dp[root - 1];

                int right = dp[n - root];

                dp[n] += left * right;
            }
        }

        return dp[A];
    }
}
