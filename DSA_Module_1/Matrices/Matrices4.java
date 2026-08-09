package com.scaler.module_2.assignments.DSA_Module_1.Matrices;

import java.util.ArrayList;

/*You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).
Problem Constraints
1 <= N <= 103
-1000 <= A[i][j] <= 1000
Input Format
First and only argument is a 2D integer matrix A.
Output Format
Return an integer denoting the sum of minor diagonal elements.
Example Input
Input 1:
 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
Input 2:
 A = [[3, 2],
      [2, 3]]
Example Output
Output 1: -5
Output 2: 4 */
public class Matrices4 {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            sum += A.get(i).get(j);
        }
        return sum;
    }
}
