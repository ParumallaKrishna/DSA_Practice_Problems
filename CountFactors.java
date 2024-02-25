package com.scaler.module_2.assignments;

/* Problem Description
Given an integer A, you need to find the count of it's factors.
Factor of a number is the number which divides it perfectly leaving no remainder.
Example : 1, 2, 3, 6 are factors of 6
Problem Constraints
1 <= A <= 109
Input Format
First and only argument is an integer A.
Output Format
Return the count of factors of A.
Example Input
Input 1:
5
Input 2:
10*/
public class CountFactors {
    public int solve(int A) {
        int factor = 0;
        for(int i = 1; i*i<=A; i++){
            if(A%i==0){
                if(i==A/i){factor += 1;}
                else{
                    factor += 2;
                }
            }
        }
        return factor;
    }
}

