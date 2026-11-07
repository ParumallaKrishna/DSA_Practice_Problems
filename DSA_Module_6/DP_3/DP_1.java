package com.scaler.module_2.assignments.DSA_Module_6.DP_3;

import java.util.ArrayList;

/*Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Problem Constraints

1 <= N <= 103

1 <= C <= 103

1 <= A[i], B[i] <= 103



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 220
Output 2:

 0*/
public class DP_1 {
    public int solve(int[] A, int[] B, int C) {

        int n = A.length;

        ArrayList<Integer> dp = new ArrayList<>();

        // Initialize DP with 0
        for (int i = 0; i <= C; i++) {
            dp.add(0);
        }

        // Process each item
        for (int i = 0; i < n; i++) {

            // Traverse capacity backwards
            for (int w = C; w >= B[i]; w--) {

                int pick = A[i] + dp.get(w - B[i]);

                int notPick = dp.get(w);

                dp.set(w, Math.max(pick, notPick));
            }
        }

        return dp.get(C);
    }
}
