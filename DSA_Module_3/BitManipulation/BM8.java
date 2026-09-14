package com.scaler.module_2.assignments.DSA_Module_3.BitManipulation;
import java.util.ArrayList;
/*Given an integer array A, find the sum of the bitwise XOR of all pairs of numbers in the array. Every pair of indices i < j adds A[i] XOR A[j] to the sum exactly once.
Since the answer can be large, return the remainder after dividing it by 109 + 7.
Problem Constraints
1 <= |A| <= 105
1 <= A[i] < 109
Input Format
The only argument is the integer array A.
Output Format
Return a single integer: the sum of A[i] XOR A[j] over all pairs of indices i < j, modulo 109 + 7.
Example Input
Input 1: A = [1, 2, 3]
Input 2: A = [3, 4, 2]
Example Output
Output 1: 6
Output 2: 14*/
public class BM8 {
    public int solve(ArrayList<Integer> A) {
        final long MOD = 1000000007L;
        int n = A.size();
        long ans = 0;
        // A[i] < 10^9, so 30 bits are enough
        for (int bit = 0; bit < 30; bit++) {
            long ones = 0;
            // Count numbers having this bit set
            for (int i = 0; i < n; i++) {
                if ((A.get(i) & (1 << bit)) != 0) {
                    ones++;
                }
            }
            long zeros = n - ones;
            // Number of pairs where XOR has this bit set
            long pairs = (ones * zeros) % MOD;
            // Contribution of this bit
            long contribution = (pairs * (1L << bit)) % MOD;
            ans = (ans + contribution) % MOD;
        }
        return (int) ans;
    }
}
