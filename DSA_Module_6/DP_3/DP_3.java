package com.scaler.module_2.assignments.DSA_Module_6.DP_3;

import java.util.ArrayList;

/*Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).

Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.



Problem Constraints

1 <= length of(A) <= 100

Sum of all the elements will not exceed 10,000.



Input Format

First and only argument is an integer array A.



Output Format

Return an integer denoting the minimum number of elements whose sign needs to be flipped.



Example Input

Input 1:

 A = [15, 10, 6]
Input 2:

 A = [14, 10, 4]


Example Output

Output 1:

 1
Output 2:

 1*/
public class DP_3 {
    public int solve(final int[] A) {

        int n = A.length;
        int total = 0;

        for (int num : A) {
            total += num;
        }

        int target = total / 2;
        int INF = 1000000;

        // dp[s] = minimum number of elements needed
        // to achieve subset sum s
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= target; i++) {
            dp.add(INF);
        }

        dp.set(0, 0);

        // 0/1 Knapsack: process each element once
        for (int i = 0; i < n; i++) {

            int num = A[i];

            for (int s = target; s >= num; s--) {

                if (dp.get(s - num) != INF) {

                    int count = dp.get(s - num) + 1;

                    dp.set(s, Math.min(dp.get(s), count));
                }
            }
        }

        // Find the maximum achievable subset sum
        for (int s = target; s >= 0; s--) {

            if (dp.get(s) != INF) {
                return dp.get(s);
            }
        }

        return 0;
    }
}
