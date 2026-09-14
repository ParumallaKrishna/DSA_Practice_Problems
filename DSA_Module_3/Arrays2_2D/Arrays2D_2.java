package com.scaler.module_2.assignments.DSA_Module_3.Arrays2_2D;

import java.util.ArrayList;

/*Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
NOTE:
Rows are numbered from top to bottom, and columns are numbered from left to right.
The sum may be large, so return the answer mod 109 + 7.
Also, select the data type carefully, if you want to store the addition of some elements.
Indexing given in B, C, D, and E arrays is 1-based.
Top Left 0-based index = (B[i] - 1, C[i] - 1)
Bottom Right 0-based index = (D[i] - 1, E[i] - 1)
Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M
Input Format
The first argument given is the integer matrix A.
The second argument given is the integer array B.
The third argument given is the integer array C.
The fourth argument given is the integer array D.
The fifth argument given is the integer array E.
(B[i], C[i]) represents the top left corner of the i'th query.
(D[i], E[i]) represents the bottom right corner of the i'th query.
Output Format
Return an integer array containing the submatrix sum for each query.
Example Input
Input 1:
 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ] B = [1, 2] C = [1, 2] D = [2, 3] E = [2, 3]
Input 2: A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ] B = [1, 1] C = [1, 4] D = [2, 2] E = [2, 4]
Example Output
Output 1: [12, 28]
Output 2: [22, 19]*/
public class Arrays2D_2 {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        int n = A.size();
        int m = A.get(0).size();
        long MOD = 1000000007L;
        // 2D Prefix Sum using ArrayList
        ArrayList<ArrayList<Long>> prefix = new ArrayList<>();
        // Create n + 1 rows
        for (int i = 0; i <= n; i++) {
            ArrayList<Long> row = new ArrayList<>();
            // Create m + 1 columns initialized with 0
            for (int j = 0; j <= m; j++) {
                row.add(0L);
            }
            prefix.add(row);
        }
        // Build prefix sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long value =
                        A.get(i - 1).get(j - 1)
                                + prefix.get(i - 1).get(j)
                                + prefix.get(i).get(j - 1)
                                - prefix.get(i - 1).get(j - 1);
                value %= MOD;
                if (value < 0) {
                    value += MOD;
                }
                prefix.get(i).set(j, value);
            }
        }
        // Store answers
        ArrayList<Integer> result = new ArrayList<>();
        // Process queries
        for (int q = 0; q < B.size(); q++) {
            int b = B.get(q);
            int c = C.get(q);
            int d = D.get(q);
            int e = E.get(q);
            long sum =
                    prefix.get(d).get(e)
                            - prefix.get(b - 1).get(e)
                            - prefix.get(d).get(c - 1)
                            + prefix.get(b - 1).get(c - 1);
            sum %= MOD;
            if (sum < 0) {
                sum += MOD;
            }
            result.add((int) sum);
        }
        return result;
    }
}
