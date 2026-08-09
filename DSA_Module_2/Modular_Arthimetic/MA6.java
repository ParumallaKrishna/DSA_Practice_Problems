package com.scaler.module_2.assignments.DSA_Module_2.Modular_Arthimetic;
/*Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.
Return the minimum result obtained.
Problem Constraints
10 <= A, B, C <= 99
Input Format
The first argument of input contains an integer, A.
The second argument of input contains an integer, B.
The third argument of input contains an integer, C.
Output Format
Return an integer representing the answer.
Example Input
Input 1: A = 10 B = 20 C = 30
Input 2: A = 55  B = 43 C = 47
Example Output
Output 1: 102030
Output 2: 434755 */
public class MA6 {
    public int solve(int A, int B, int C) {
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, concatenate(A, B, C));
        ans = Math.min(ans, concatenate(A, C, B));
        ans = Math.min(ans, concatenate(B, A, C));
        ans = Math.min(ans, concatenate(B, C, A));
        ans = Math.min(ans, concatenate(C, A, B));
        ans = Math.min(ans, concatenate(C, B, A));
        return ans;
    }
    private int concatenate(int A, int B, int C) {
        return A * 10000 + B * 100 + C;
    }
}
