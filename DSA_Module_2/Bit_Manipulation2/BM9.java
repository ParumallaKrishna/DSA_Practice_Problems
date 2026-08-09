package com.scaler.module_2.assignments.DSA_Module_2.Bit_Manipulation2;
/*Given an integer A, find and return the Ath magic number.
A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
Problem Constraints
1 <= A <= 5000
Input Format
The only argument given is integer A.
Output Format
Return the Ath magic number.
Example Input 1: A = 3
Example Input 2: A = 10
Example Output 1: 30
Example Output 2: 650
*/
public class BM9 {
    public int solve(int A) {
        int power = 5;
        int answer = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                answer += power;
            }
            power = power * 5;
            A = A >> 1;
        }
        return answer;
    }
}
