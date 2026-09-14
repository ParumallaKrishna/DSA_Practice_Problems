package com.scaler.module_2.assignments.DSA_Module_3.Arrays1_1D;

import java.util.List;

/*Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.
In other words, among all possible subarrays of A, determine the one that yields the highest sum and return that sum.
Problem Constraints
1 <= N <= 106
-1000 <= A[i] <= 1000
Input Format
The first and the only argument contains an integer array, A.
Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.
Example Input
Input 1: A = [1, 2, 3, 4, -10]
Input 2: A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Example Output
Output 1: 10
Output 2: 6 */
public class Arrays1 {
    public int maxSubArray(final List<Integer> A) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (Integer num : A) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            // Reset currentSum if it drops below 0
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
