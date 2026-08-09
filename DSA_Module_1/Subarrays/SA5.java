package com.scaler.module_2.assignments.DSA_Module_1.Subarrays;
import java.util.ArrayList;
/*Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.
Problem Constraints
1 <= len(A) <= 5 x 103
1 <= A[i] <= 103
1 <= B <= 107
Input Format
The first argument given is the integer array A.
The second argument given is an integer B.
Output Format
Return the count of good subarrays in A.
Example Input
Input 1: A = [1, 2, 3, 4, 5] B = 4
Input 2: A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9] B = 65
Example Output
Output 1: 6
Output 2: 36*/
public class SA5 {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int count = 0;
        // Prefix sum
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + A.get(i);
        }
        // Generate all subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Sum of subarray A[i...j]
                long sum = prefix[j + 1] - prefix[i];
                // Length of subarray
                int length = j - i + 1;
                // Condition 1:
                // Even length and sum < B
                if (length % 2 == 0 && sum < B) {
                    count++;
                }
                // Condition 2:
                // Odd length and sum > B
                else if (length % 2 != 0 && sum > B) {
                    count++;
                }
            }
        }
        return count;
    }
}
