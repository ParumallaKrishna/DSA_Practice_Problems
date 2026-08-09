package com.scaler.module_2.assignments.DSA_Module_2.Modular_Arthimetic;
/*You are given a number A in the form of a string. Check if the number is divisible by eight or not.
Return 1 if it is divisible by eight else, return 0.
Problem Constraints
1 <= length of the String <= 100000
'0' <= A[i] <= '9'
Input Format
The only argument given is a string A.
Output Format
Return 1 if it is divisible by eight else return 0.
Example Input
Input 1: A = "16"
Input 2: A = "123"
Example Output
Output 1: 1
Output 2: 0*/
public class MA5 {
    public int solve(String A) {
        int n = A.length();
        int number = 0;
        int start = Math.max(0, n - 3);
        for (int i = start; i < n; i++) {
            number = number * 10 + (A.charAt(i) - '0');
        }
        if (number % 8 == 0) {
            return 1;
        }
        return 0;
    }
}
