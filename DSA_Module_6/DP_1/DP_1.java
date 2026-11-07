package com.scaler.module_2.assignments.DSA_Module_6.DP_1;
/*You are climbing a staircase and it takes A steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Return the number of distinct ways modulo 1000000007
Problem Constraints
1 <= A <= 105
Input Format
The first and the only argument contains an integer A, the number of steps.
Output Format
Return an integer, representing the number of ways to reach the top.
Example Input
Input 1: A = 2
Input 2: A = 3
Example Output
Output 1: 2
Output 2: 3*/
public class DP_1 {
    public int climbStairs(int A) {

        int MOD = 1000000007;

        if (A == 1) {
            return 1;
        }

        if (A == 2) {
            return 2;
        }

        long prev2 = 1;
        long prev1 = 2;

        for (int i = 3; i <= A; i++) {

            long current = (prev1 + prev2) % MOD;

            prev2 = prev1;
            prev1 = current;
        }

        return (int) prev1;
    }
}
