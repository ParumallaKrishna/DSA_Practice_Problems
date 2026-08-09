package com.scaler.module_2.assignments.DSA_Module_2.Modular_Arthimetic;
/*You are given A, B and C .
Calculate the value of (A ^ B) % C
Problem Constraints
1 <= A <= 109
0 <= B <= 105
1 <= C <= 109
Input Format
Given three integers A, B and C.
Output Format
Return an integer.
Example Input
Input 1: A = 2 B = 3 C = 3
Input 2: A = 5 B = 2 C = 4
Example Output
Output 1: 2
Output 2: 1*/
public class MA1 {
    public int solve(int A, int B, int C) {
        long ans=1;
        for(int i=1;i<=B;i++){
            ans=(ans*A)%C;
        }
        return (int)ans%C;
    }
}
