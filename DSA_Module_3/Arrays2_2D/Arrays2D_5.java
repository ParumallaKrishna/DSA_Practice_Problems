package com.scaler.module_2.assignments.DSA_Module_3.Arrays2_2D;

import java.util.ArrayList;

/*Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, such that the sum of all the elements in the submatrix is maximum.
Problem Constraints
1 <= N <= 103.
1 <= B <= N
-102 <= A[i][j] <= 102.
Input Format
First arguement is an 2D integer matrix A.
Second argument is an integer B.
Output Format
Return a single integer denoting the maximum sum of submatrix of size B x B.
Example Input
Input 1:
 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ] B = 3
Input 2: A = [
        [2, 2]
        [2, 2] ] B = 2
Example Output
Output 1: 48
Output 2: 8*/
public class Arrays2D_5 {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        // Prefix Sum Matrix using ArrayList
        ArrayList<ArrayList<Long>> prefix = new ArrayList<>();
        // Create (N + 1) x (N + 1) matrix with 0
        for (int i = 0; i <= N; i++) {
            ArrayList<Long> row = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                row.add(0L);
            }
            prefix.add(row);
        }
        // Build Prefix Sum
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                long sum =
                        A.get(i - 1).get(j - 1)
                                + prefix.get(i - 1).get(j)
                                + prefix.get(i).get(j - 1)
                                - prefix.get(i - 1).get(j - 1);

                prefix.get(i).set(j, sum);
            }
        }
        long maxSum = Long.MIN_VALUE;
        // Find every B x B submatrix
        for (int i = 0; i <= N - B; i++) {
            for (int j = 0; j <= N - B; j++) {
                long sum =
                        prefix.get(i + B).get(j + B)
                                - prefix.get(i).get(j + B)
                                - prefix.get(i + B).get(j)
                                + prefix.get(i).get(j);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return (int) maxSum;
    }
}
