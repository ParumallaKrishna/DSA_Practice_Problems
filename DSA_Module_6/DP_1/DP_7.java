package com.scaler.module_2.assignments.DSA_Module_6.DP_1;
/*A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.



Problem Constraints

1 <= length(A) <= 105



Input Format

The first and the only argument is a string A.



Output Format

Return an integer, representing the number of ways to decode the string modulo 109 + 7.



Example Input

Input 1:

 A = "12"
Input 2:

 A = "8"


Example Output

Output 1:

 2
Output 2:

 1*/
public class DP_7 {
    public int numDecodings(String A) {

        int MOD = 1000000007;

        int n = A.length();

        if (A.charAt(0) == '0') {
            return 0;
        }

        long prev2 = 1;
        long prev1 = 1;

        for (int i = 1; i < n; i++) {

            long current = 0;

            // Single digit decoding
            if (A.charAt(i) != '0') {
                current = prev1;
            }

            // Two digit decoding
            int num = (A.charAt(i - 1) - '0') * 10
                    + (A.charAt(i) - '0');

            if (num >= 10 && num <= 26) {
                current = (current + prev2) % MOD;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return (int) (prev1 % MOD);
    }
}
