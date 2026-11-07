package com.scaler.module_2.assignments.DSA_Module_6.DP_4;

import java.util.ArrayList;

/*Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).



Problem Constraints

1 <= N <= 500

1 <= C, B[i] <= 106

1 <= A[i] <= 50



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [6, 10, 12]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [1, 3, 2, 4]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 22
Output 2:

 0*/
public class DP_1 {
    public int solve(int[] A, int[] B, int C) {

        int n = A.length;

        int maxValue = 0;

        // Calculate maximum possible total value
        for (int value : A) {
            maxValue += value;
        }

        int INF = Integer.MAX_VALUE;

        // dp[v] = minimum weight needed to achieve value v
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= maxValue; i++) {
            dp.add(INF);
        }

        dp.set(0, 0);

        // Process each item
        for (int i = 0; i < n; i++) {

            int value = A[i];
            int weight = B[i];

            // Traverse backwards: 0/1 Knapsack
            for (int v = maxValue; v >= value; v--) {

                if (dp.get(v - value) != INF) {

                    int newWeight = dp.get(v - value) + weight;

                    dp.set(v, Math.min(dp.get(v), newWeight));
                }
            }
        }

        // Find maximum achievable value within capacity
        for (int v = maxValue; v >= 0; v--) {

            if (dp.get(v) <= C) {
                return v;
            }
        }

        return 0;
    }
}
