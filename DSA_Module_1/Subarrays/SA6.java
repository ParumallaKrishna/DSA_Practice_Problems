package com.scaler.module_2.assignments.DSA_Module_1.Subarrays;

import java.util.ArrayList;

/*Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.
Problem Constraints
1 <= N <= 5 x 103
1 <= A[i] <= 1000
1 <= B <= 107
Input Format
First argument is an integer array A.
Second argument is an integer B.
Output Format
Return an integer denoting the number of subarrays in A having sum less than B.
Example Input
Input 1: A = [2, 5, 6] B = 10
Input 2: A = [1, 11, 2, 3, 15] B = 10
Example Output
Output 1: 4
Output 2: 4*/
public class SA6 {
    public int solve(ArrayList<Integer> A, int B) {
        int left = 0;
        int count = 0;
        long sum = 0;
        for (int right = 0; right < A.size(); right++) {
            sum += A.get(right);
            while (sum >= B && left <= right) {
                sum -= A.get(left);
                left++;
            }
            // All subarrays ending at 'right'
            // and starting from left to right are valid
            count += right - left + 1;
        }
        return count;
    }
}
