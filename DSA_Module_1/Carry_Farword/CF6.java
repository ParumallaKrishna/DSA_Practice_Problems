package com.scaler.module_2.assignments.DSA_Module_1.Carry_Farword;

import java.util.ArrayList;

/*You are given an integer array A.
Decide whether it is possible to divide the array into one or more subarrays of even length such that the first and last element of all subarrays will be even.
Return "YES" if it is possible; otherwise, return "NO" (without quotes).
Problem Constraints
1 <= |A|, A[i] <= 106
Input Format
The first and the only input argument is an integer array, A.
Output Format
Return a string "YES" or "NO" denoting the answer.
Example Input
Input 1: A = [2, 4, 8, 6]
Input 2: A = [2, 4, 8, 7, 6]
Example Output
Output 1: "YES"
Output 2: "NO"*/
public class CF6 {
    public String solve(ArrayList<Integer> A) {
        int n = A.size();
        // Array length must be even
        if (n % 2 != 0) {
            return "NO";
        }
        // First and last elements must be even
        if (A.get(0) % 2 != 0 || A.get(n - 1) % 2 != 0) {
            return "NO";
        }
        return "YES";
    }
}
