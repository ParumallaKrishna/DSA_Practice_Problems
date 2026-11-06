package com.scaler.module_2.assignments.DSA_Module_5.Tries_2;
/*Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 109
Input Format
The only argument given is the integer array A.
Output Format
Return an integer denoting the maximum result of A[i] XOR A[j].
Example Input
Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [5, 17, 100, 11]
Example Output
Output 1: 7
Output 2: 117
*/
public class Tries_1 {
    public int solve(int[] A) {
        int maxXor = 0;
        for (int i = 30; i >= 0; i--) {
            // Try setting the current bit to 1
            int candidate = maxXor | (1 << i);
            java.util.HashSet<Integer> set = new java.util.HashSet<>();
            // Store prefixes of all elements
            for (int num : A) {
                set.add(num >> i);
            }
            boolean found = false;
            // Check whether candidate XOR is possible
            for (int num : A) {
                int prefix = num >> i;
                if (set.contains(prefix ^ candidate >> i)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                maxXor = candidate;
            }
        }
        return maxXor;
    }
}
