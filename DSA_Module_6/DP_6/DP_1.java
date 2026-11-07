package com.scaler.module_2.assignments.DSA_Module_6.DP_6;

import java.util.ArrayList;
import java.util.Arrays;

/*Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.

One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

Find the maximum number of envelopes you can put one inside other.



Problem Constraints

1 <= N <= 1000
1 <= A[i][0], A[i][1] <= 109



Input Format

The only argument given is the integer matrix A.



Output Format

Return an integer denoting the maximum number of envelopes you can put one inside other.



Example Input

Input 1:

 A = [
         [5, 4]
         [6, 4]
         [6, 7]
         [2, 3]
     ]
Input 2:

 A = [
         [8, 9]
         [8, 18]
     ]


Example Output

Output 1:

 3
Output 2:

 1*/
public class DP_1 {
    public int solve(int[][] A) {

        int n = A.length;

        // Sort by height ascending.
        // If heights are equal, sort width descending.
        Arrays.sort(A, (a, b) -> {

            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dp.add(1);
        }

        int maxLength = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (A[j][1] < A[i][1]) {

                    dp.set(i, Math.max(
                            dp.get(i),
                            dp.get(j) + 1
                    ));
                }
            }

            maxLength = Math.max(maxLength, dp.get(i));
        }

        return maxLength;
    }
}
