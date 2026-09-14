package com.scaler.module_2.assignments.DSA_Module_3.BitManipulation;
/*Given an integer A.
Two numbers, X and Y, are defined as follows:
X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.
NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
Problem Constraints
1 <= A <= 109
Input Format
First and only argument is an integer A.
Output Format
Return an integer denoting the XOR of X and Y.
Example Input
A = 5
Example Output
10*/
public class BM5 {
    public int solve(int A) {
        int P = 1;
        while (P <= A) {
            P = P << 1;
        }
        // Greatest X < A such that X & A = 0
        int X = (P - 1) ^ A;
        // Smallest Y > A such that Y & A = 0
        int Y = P;
        return X ^ Y;
    }
}
