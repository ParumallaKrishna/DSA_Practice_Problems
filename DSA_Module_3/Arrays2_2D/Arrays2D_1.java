package com.scaler.module_2.assignments.DSA_Module_3.Arrays2_2D;

import java.util.ArrayList;

/*Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
Problem Constraints
1 <= N <=30
0 <= A[i][j] <= 10
Input Format
Single argument representing a 2-D array A of size N x N.
Output Format
Return an integer denoting the sum of all possible submatrices in the given matrix.
Example Input
Input 1: A = [ [1, 1] [1, 1] ]
Input 2: A = [ [1, 2] [3, 4] ]
Example Output
Output 1: 16
Output 2: 40
*/
public class Arrays2D_1 {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long contribution =
                        (long) A.get(i).get(j)
                                * (i + 1)
                                * (j + 1)
                                * (n - i)
                                * (n - j);

                sum += contribution;
            }
        }
        return (int)sum;
    }
}
