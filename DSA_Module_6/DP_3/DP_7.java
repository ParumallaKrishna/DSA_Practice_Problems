package com.scaler.module_2.assignments.DSA_Module_6.DP_3;
/*You are trying to send signals to aliens using a linear array of A laser lights. You don't know much about how the aliens are going to percieve the signals, but what you know is that if two consecutive lights are on then the aliens might take it as a sign of danger and destroy the earth.

Find and return the total number of ways in which you can send a signal without compromising the safty of the earth. Return the ans % 109 + 7.



Problem Constraints

1 <= A <= 105



Input Format

The only argument given is integer A.



Output Format

Return the ans%(109+7).



Example Input

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 3
Output 2:

 5*/
public class DP_7 {
    public int solve(int A) {

        int MOD = 1000000007;

        if (A == 1) {
            return 2;
        }

        long prev2 = 1; // dp[0]
        long prev1 = 2; // dp[1]

        for (int i = 2; i <= A; i++) {

            long current = (prev1 + prev2) % MOD;

            prev2 = prev1;
            prev1 = current;
        }

        return (int) prev1;
    }
}
