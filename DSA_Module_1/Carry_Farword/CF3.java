package com.scaler.module_2.assignments.DSA_Module_1.Carry_Farword;
/*You have given a string A having Uppercase English letters.
You have to find how many times subsequence "AG" is there in the given string.
NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
Problem Constraints
1 <= length(A) <= 105
Input Format
First and only argument is a string A.
Output Format
Return an integer denoting the answer.
Example Input
Input 1: A = "ABCGAG"
Input 2: A = "GAB"
Example Output
Output 1: 3
Output 2: 0*/
public class CF3 {
    public int solve(String A) {
        long countA = 0;
        long answer = 0;
        long MOD = 1000000007;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == 'A') {
                countA++;
            }
            if (ch == 'G') {
                answer = (answer + countA) % MOD;
            }
        }
        return (int) answer;
    }
}
