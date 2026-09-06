package com.scaler.module_2.assignments.DSA_Module_2.Recursion_1;
/*Write a program to find the factorial of the given number A using recursion.
Note: The factorial of a number N is defined as the product of the numbers from 1 to N.
Problem Constraints
0 <= A <= 12
Input Format
First and only argument is an integer A.
Output Format
Return an integer denoting the factorial of the number A.
Example Input
Input 1: A = 4
Input 2: A = 1
Example Output
Output 1: 24
Output 2: 1*/
public class Recursion2 {
    public int solve(int A) {
        // if(A==1){ return A;}
        // return A*solve(A-1);
        int fact =1;
        for(int i=2;i<=A;i++){
            fact=fact*i;
        }
        return fact;
    }
}
