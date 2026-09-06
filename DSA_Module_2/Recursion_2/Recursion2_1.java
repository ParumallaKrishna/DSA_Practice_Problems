package com.scaler.module_2.assignments.DSA_Module_2.Recursion_2;
/*Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).
Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
Problem Constraints
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109
Input Format
Given three integers A, B, C.
Output Format
Return an integer.
Example Input
Input 1: A = 2 B = 3 C = 3
Input 2: A = 3 B = 3 C = 1
Example Output
Output 1: 2
Output 2: 0*/
public class Recursion2_1 {
    public int pow(int A, int B, int C) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        int D =A;
        for(int i=1;i<B;i++){
            D=(D*A)%C;
        }
        return D;
    }
}
