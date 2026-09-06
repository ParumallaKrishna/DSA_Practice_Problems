package com.scaler.module_2.assignments.DSA_Module_2.Recursion_1;
/*The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
Fn = Fn-1 + Fn-2
Given a number A, find and return the Ath Fibonacci Number using recursion.
Given that F0 = 0 and F1 = 1.
Problem Constraints
0 <= A <= 20
Input Format
First and only argument is an integer A.
Output Format
Return an integer denoting the Ath term of the sequence.
Example Input
Input 1:
 A = 2
Input 2:
 A = 9
Example Output
Output 1: 1
Output 2: 34*/
public class Recursion1 {
    public int findAthFibonacci(int A) {
        if(A<=1){
            return A;
        }
        int prev1=1,prev2=0;
        int curr = 0;
        for(int i=2;i<=A;i++){
            curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
}
