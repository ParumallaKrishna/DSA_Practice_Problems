package com.scaler.module_2.assignments.DSA_Module_2.Recursion_1;
/*Given a number A, we need to find the sum of its digits using recursion.
Problem Constraints
1 <= A <= 109
Input Format
The first and only argument is an integer A.
Output Format
Return an integer denoting the sum of digits of the number A.
Example Input
Input 1: A = 46
Input 2: A = 11
Example Output
Output 1: 10
Output 2: 2*/
public class Recursion6 {
    public int solve(int A) {
        String B = String.valueOf(A);
        int sum=0;
        for(char ch :B.toCharArray()){
            sum = sum+(ch-'0');
        }
        return sum;
    }
}
