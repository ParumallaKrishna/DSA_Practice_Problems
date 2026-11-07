package com.scaler.module_2.assignments.DSA_Module_6.DP_2;

import java.util.ArrayList;

/*Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Return the minimum sum of the path.

NOTE: You can only move either down or right at any point in time.



Problem Constraints

1 <= M, N <= 2000

-1000 <= A[i][j] <= 1000



Input Format

First and only argument is a 2-D grid A.



Output Format

Return an integer denoting the minimum sum of the path.



Example Input

Input 1:

 A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]
Input 2:

 A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]


Example Output

Output 1:

 8
Output 2:

 -1*/
public class DP_5 {
    public int minPathSum(int[][] A) {

        int m = A.length;
        int n = A[0].length;

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        // Initialize DP matrix
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(0);
            }

            dp.add(row);
        }

        // Starting cell
        dp.get(0).set(0, A[0][0]);

        // First column: only downward movement
        for (int i = 1; i < m; i++) {
            dp.get(i).set(
                    0,
                    dp.get(i - 1).get(0) + A[i][0]
            );
        }

        // First row: only rightward movement
        for (int j = 1; j < n; j++) {
            dp.get(0).set(
                    j,
                    dp.get(0).get(j - 1) + A[0][j]
            );
        }

        // Remaining cells
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                int top = dp.get(i - 1).get(j);
                int left = dp.get(i).get(j - 1);

                int minSum = Math.min(top, left) + A[i][j];

                dp.get(i).set(j, minSum);
            }
        }

        return dp.get(m - 1).get(n - 1);
    }
}
