package com.scaler.module_2.assignments.DSA_Module_6.DP_6;

import java.util.ArrayList;

/*You are given an array A. You need to find the length of the Longest Increasing Subsequence in the array.

In other words, you need to find a subsequence of array A in which the elements are in sorted order, (strictly increasing) and as long as possible.



Problem Constraints

1 ≤ length(A), A[i] ≤ 105



Input Format

The first and only argument of the input is the array A.



Output Format

Output a single integer, the length of the longest increasing subsequence in array A.



Example Input

Input 1:

A: [2, 1, 4, 3]
Input 2:

A: [5, 6, 3, 7, 9]


Example Output

Output 1:

2
Output 2:

4
*/
public class DP_5 {
    public int findLIS(int[] A) {

        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {

            int num = A[i];

            // Extend the increasing subsequence
            if (dp.size() == 0 || num > dp.get(dp.size() - 1)) {

                dp.add(num);

            } else {

                // Binary search: first element >= num
                int left = 0;
                int right = dp.size() - 1;

                while (left <= right) {

                    int mid = left + (right - left) / 2;

                    if (dp.get(mid) >= num) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                dp.set(left, num);
            }
        }

        return dp.size();
    }
}
