package com.scaler.module_2.assignments.DSA_Module_6.DP_6;

import java.util.ArrayList;

/*Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.



Problem Constraints

1 <= length(A) <= 2500
0 <= A[i] <= 2500



Input Format

The first and the only argument is an integer array A.



Output Format

Return an integer representing the length of the longest increasing subsequence.



Example Input

Input 1:

 A = [1, 2, 1, 5]
Input 2:

 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]


Example Output

Output 1:

 3
Output 2:

 6*/
public class DP_2 {
    public int lis(final int[] A) {

        int n = A.length;

        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dp.add(1);
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (A[j] < A[i]) {

                    dp.set(i, Math.max(dp.get(i), dp.get(j) + 1));
                }
            }

            ans = Math.max(ans, dp.get(i));
        }

        return ans;
    }
}
