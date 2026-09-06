package com.scaler.module_2.assignments.DSA_Module_2.Recursion_2;
/*Given a number A, check if it is a magic number or not.
A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.
Problem Constraints
1 <= A <= 109
Input Format
The first and only argument is an integer A.
Output Format
Return an 1 if the given number is magic else return 0.
Example Input
Input 1: A = 83557
Input 2: A = 1291
Example Output
Output 1: 1
Output 2: 0*/
public class Recursion2_2 {
    public int solve(int A) {
        while (A >= 10) {
            int sum = 0;
            while (A > 0) {
                sum += A % 10;
                A /= 10;
            }
            A = sum;
        }
        return A == 1 ? 1 : 0;
    }
}
