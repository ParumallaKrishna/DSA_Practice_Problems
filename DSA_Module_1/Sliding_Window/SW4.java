package com.scaler.module_2.assignments.DSA_Module_1.Sliding_Window;

import java.util.ArrayList;

/*Given an array A of size N, find the subarray of size B with the least average.
Problem Constraints
1 <= B <= N <= 105
-105 <= A[i] <= 105
Input Format
First argument contains an array A of integers of size N.
Second argument contains integer B.
Output Format
Return the index of the first element of the subarray of size B that has least average.
Array indexing starts from 0.
Example Input
Input 1: A = [3, 7, 90, 20, 10, 50, 40] B = 3
Input 2: A = [3, 7, 5, 20, -10, 0, 12] B = 2
Example Output
Output 1: 3
Output 2: 4*/
public class SW4 {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        // Sum of first window
        long sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A.get(i);
        }
        long minSum = sum;
        int minIndex = 0;
        // Sliding window
        for (int i = B; i < n; i++) {
            // Add new element
            sum += A.get(i);
            // Remove element leaving the window
            sum -= A.get(i - B);
            // Found a smaller sum
            if (sum < minSum) {
                minSum = sum;
                minIndex = i - B + 1;
            }
        }
        return minIndex;
    }
}
