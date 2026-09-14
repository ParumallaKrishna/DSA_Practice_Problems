package com.scaler.module_2.assignments.DSA_Module_3.BitManipulation;
import java.util.ArrayList;
/*Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].
Problem Constraints
1 <= len(A) <= 105
1 <= A[i] <= 109
Input Format
The first argument is an integer array A.
Output Format
Return a single integer that is the maximum A[i] & A[j].
Example Input
Input 1:- A = [53, 39, 88]
Input 2:- A = [38, 44, 84, 12]
Example Output
Output 1:- 37
Output 2:- 36
*/
public class BM2 {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int ans = 0;
        // Check bits from most significant to least significant
        for (int bit = 30; bit >= 0; bit--) {
            int candidate = ans | (1 << bit);
            int count = 0;
            // Count numbers having all bits of candidate
            for (int i = 0; i < n; i++) {
                if ((A.get(i) & candidate) == candidate) {
                    count++;
                }
            }
            // We need at least two numbers
            if (count >= 2) {
                ans = candidate;
            }
        }
        return ans;
    }
}
