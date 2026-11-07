package com.scaler.module_2.assignments.DSA_Module_6.DP_4;

import java.util.ArrayList;

/*Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.

Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.



Problem Constraints

1 <= N <= 1000

0 <= A[i] <= 106



Input Format

First and only argument is an integer array A of size N.



Output Format

Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.



Example Input

Input 1:

 A = [3, 4, 1, 6, 2]
Input 2:

 A = [1, 5, 2, 5, 6]


Example Output

Output 1:

 15
Output 2:

 11*/
public class DP_2 {
    public int solve(int[] A) {

        int n = A.length;

        // dp[len] = maximum revenue for rod length len
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            dp.add(0);
        }

        // Calculate maximum revenue for every rod length
        for (int len = 1; len <= n; len++) {

            int maxRevenue = 0;

            // Try every possible cut length
            for (int cut = 1; cut <= len; cut++) {

                int currentRevenue =
                        A[cut - 1] + dp.get(len - cut);

                maxRevenue = Math.max(maxRevenue, currentRevenue);
            }

            dp.set(len, maxRevenue);
        }

        return dp.get(n);
    }
}
