package com.scaler.module_2.assignments.DSA_Module_1.Subarrays;

import java.util.ArrayList;

/*You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.
Problem Constraints
1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106
Input Format
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.
Output Format
Return a single integer which denotes the maximum sum.
Example Input
Input 1: A = 5 B = 12 C = [2, 1, 3, 4, 5]
Input 2: A = 3 B = 1 C = [2, 2, 2]
Example Output
Output 1: 12
Output 2: 0*/
public class SA2 {
    public int solve(int A, int B, ArrayList<Integer> C) {
        int left = 0;
        long sum = 0;
        long maxSum = 0;
        for (int right = 0; right < A; right++) {
            sum += C.get(right);
            while (sum > B && left <= right) {
                sum -= C.get(left);
                left++;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return (int) maxSum;
    }
}
