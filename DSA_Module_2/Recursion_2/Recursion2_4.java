package com.scaler.module_2.assignments.DSA_Module_2.Recursion_2;
/*On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
Problem Constraints
1 <= A <= 105
0 <= B <= min(2A - 1 - 1 , 1018)
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
public class Recursion2_4 {
    public int solve(int A, long B) {
        int count = 0;
        while (B > 0) {
            count += (B & 1);
            B = B >> 1;
        }
        return count % 2;
    }
}
