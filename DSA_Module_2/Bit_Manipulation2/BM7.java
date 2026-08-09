package com.scaler.module_2.assignments.DSA_Module_2.Bit_Manipulation2;
/*Alex and Sam are good friends. Alex is doing a lot of programming these days. He has set a target score of A for himself.
Initially, Alex's score was zero. Alex can double his score by doing a question, or Alex can seek help from Sam for doing questions that will contribute 1 to Alex's score. Alex wants his score to be precisely A. Also, he does not want to take much help from Sam.
Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of A.
Problem Constraints
0 <= A <= 10^9
Input Format
The only argument given is an integer A.
Output Format
Return the minimum number of times help taken from Sam.
Example Input
Input 1: A = 5
Input 2: A = 3
Example Output
Output 1: 2
Output 2: 2*/
public class BM7 {
    public int solve(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                count++;
            }
            A = A >> 1;
        }
        return count;
    }
}
