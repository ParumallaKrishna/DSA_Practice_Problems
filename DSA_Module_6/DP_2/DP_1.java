package com.scaler.module_2.assignments.DSA_Module_6.DP_2;

import java.util.ArrayList;

/*Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids.
Return the total number unique paths from (1, 1) to (n, m).

Note:
1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
2. Given Source Point and Destination points are 1-based index.



Problem Constraints

1 <= n, m <= 100
A[i][j] = 0 or 1


Input Format

Firts and only argument A is a 2D array of size n * m.


Output Format

Return an integer denoting the number of unique paths from (1, 1) to (n, m).


Example Input

Input 1:

 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:

 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]


Example Output

Output 1:

 2
Output 2:

 0*/
public class DP_1 {
    public int uniquePathsWithObstacles(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        // Initialize DP matrix with zeros
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                row.add(0);
            }

            dp.add(row);
        }

        // Starting cell is blocked
        if (A[0][0] == 1) {
            return 0;
        }

        dp.get(0).set(0, 1);

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // Skip obstacle cells
                if (A[i][j] == 1) {
                    dp.get(i).set(j, 0);
                    continue;
                }

                // Starting cell
                if (i == 0 && j == 0) {
                    continue;
                }

                int up = 0;
                int left = 0;

                // Paths from top
                if (i > 0) {
                    up = dp.get(i - 1).get(j);
                }

                // Paths from left
                if (j > 0) {
                    left = dp.get(i).get(j - 1);
                }

                dp.get(i).set(j, up + left);
            }
        }

        return dp.get(n - 1).get(m - 1);
    }
}
