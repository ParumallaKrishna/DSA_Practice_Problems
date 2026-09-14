package com.scaler.module_2.assignments.DSA_Module_3.BitManipulation;

import java.util.ArrayList;

/*You are given an array of integers A of size N.
The value of a subarray is defined as BITWISE OR of all elements in it.
Return the sum of value of all subarrays of A % (109 + 7).
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 108
Input Format
The first argument given is the integer array A.
Output Format
Return the sum of Value of all subarrays of A % 109 + 7.
Example Input
Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [7, 8, 9, 10]
Example Output
Output 1: 71
Output 2: 110*/
public class BM7 {
    public int solve(ArrayList<Integer> A) {
        final long MOD = 1000000007L;
        int n = A.size();
        long ans = 0;
        // A[i] <= 10^8, so check 31 bits
        for (int bit = 0; bit < 31; bit++) {
            long count = 0;
            int last = -1;
            for (int i = 0; i < n; i++) {
                // Check if current bit is set
                if ((A.get(i) & (1 << bit)) != 0) {
                    last = i;
                }
                // Number of subarrays ending at i
                // where this bit is set
                count += last + 1;
            }
            long contribution = (count % MOD) * ((1L << bit) % MOD);
            ans = (ans + contribution) % MOD;
        }
        return (int) ans;
    }
}
