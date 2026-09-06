package com.scaler.module_2.assignments.DSA_Module_2.Interview_problems;
/*Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
Input Format
The only argument given is string A.
Output Format
Return the length of the longest consecutive 1’s that can be achieved.
Constraints
1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example
Input 1: A = "111000"
Output 1: 3
Input 2: A = "111011101"
Output 2: 7*/
public class IP1 {
    public int solve(String A) {
        int n = A.length();
        // Total number of 1s
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                totalOnes++;
            }
        }
        if (totalOnes == 0) {
            return 0;
        }
        if (totalOnes == n) {
            return n;
        }
        // right[i] = number of consecutive 1s starting from i
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (A.charAt(i) == '1') {
                right[i] = 1;
                if (i + 1 < n) {
                    right[i] += right[i + 1];
                }
            }
        }
        int maxLength = 0;
        int leftOnes = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                leftOnes++;
            } else {
                int rightOnes = 0;
                if (i + 1 < n) {
                    rightOnes = right[i + 1];
                }
                int length = leftOnes + 1 + rightOnes;
                // Cannot exceed total number of 1s
                length = Math.min(length, totalOnes);
                maxLength = Math.max(maxLength, length);
                leftOnes = 0;
            }
        }
        return maxLength;
    }
}
