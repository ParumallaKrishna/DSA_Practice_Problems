package com.scaler.module_2.assignments.DSA_Module_2.Recursion_2;
/*On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
Problem Constraints
1 <= A <= 20
0 <= B < 2A - 1
Input Format
First argument is an integer A.
Second argument is an integer B.
Output Format
Return an integer denoting the Bth indexed symbol in row A.
Example Input
Input 1: A = 3 B = 0
Input 2: A = 4 B = 4
Example Output
Output 1: 0
Output 2: 1*/
public class Recursion2_3 {
    public int solve(int A, int B) {
        // Base case
        if (A == 1) {
            return 0;
        }
        int mid = 1 << (A - 2);
        if (B < mid) {
            return solve(A - 1, B);
        }
        return 1 - solve(A - 1, B - mid);
    }
}
