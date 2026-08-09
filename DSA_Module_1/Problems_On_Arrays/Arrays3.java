package com.scaler.module_2.assignments.DSA_Module_1.Problems_On_Arrays;

import java.util.ArrayList;

/*Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109
Input Format
First argument contains an array A of integers of size N
Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
Example Input
Input 1: A = [2, 1, 6, 4]
Input 2: A = [1, 1, 1]
Example Output
Output 1: 1
Output 2: 3 */
public class Arrays3 {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        long totalEven = 0;
        long totalOdd = 0;
        // Calculate total even and odd index sums
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                totalEven += A.get(i);
            } else {
                totalOdd += A.get(i);
            }
        }
        long evenLeft = 0;
        long oddLeft = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            // Remove A[i] from the appropriate total
            if (i % 2 == 0) {
                totalEven -= A.get(i);
            } else {
                totalOdd -= A.get(i);
            }
            // Remaining elements on the right
            long evenRight = totalEven;
            long oddRight = totalOdd;
            // After removing A[i], right-side indices swap parity
            long newEvenSum = evenLeft + oddRight;
            long newOddSum = oddLeft + evenRight;
            if (newEvenSum == newOddSum) {
                count++;
            }
            // Add current element to the left side
            if (i % 2 == 0) {
                evenLeft += A.get(i);
            } else {
                oddLeft += A.get(i);
            }
        }
        return count;
    }
}
