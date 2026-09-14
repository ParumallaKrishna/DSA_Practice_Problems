package com.scaler.module_2.assignments.DSA_Module_3.Arrays2_2D;

import java.util.ArrayList;

/*Given a row-wise and column-wise sorted matrix A of size N * M.
Return the maximum non-empty submatrix sum of this matrix.
Problem Constraints
1 <= N, M <= 1000
-109 <= A[i][j] <= 109
Input Format
The first argument is a 2D integer array A.
Output Format
Return a single integer that is the maximum non-empty submatrix sum of this matrix.
Example Input
Input 1:-
    -5 -4 -3
A = -1  2  3
     2  2  4
Input 2:-
    1 2 3
A = 4 5 6
    7 8 9
Example Output
Output 1:- 12
Output 2:- 45*/
public class Arrays2D_4 {
    public Long solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        long[][] suffix = new long[N + 1][M + 1];
        long ans = Long.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                suffix[i][j] =
                        A.get(i).get(j)
                                + suffix[i + 1][j]
                                + suffix[i][j + 1]
                                - suffix[i + 1][j + 1];
                ans = Math.max(ans, suffix[i][j]);
            }
        }
        return ans;
    }
}
