package com.scaler.module_2.assignments.DSA_Module_6.DP_4;

import java.util.ArrayList;

/*Given two strings A and B, count the number of unique ways in string A to form a subsequence that is identical to string B.

A subsequence of a string is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Since the answer can be very large, return the result modulo 109 + 7.


Problem Constraints

1 <= |A|, |B| <= 1000


Input Format

The first argument is a string A.
The second argument is a string B.


Output Format

Return an integer representing the number of distinct subsequences of A which equal B, modulo 109 + 7.


Example Input

Input 1:
A = "abc"
B = "abc"
Input 2:
A = "rabbbit"
B = "rabbit"


Example Output

Output 1:
1
Output 2:
3*/
public class DP_4 {
    public int numDistinct(String A, String B) {

        int MOD = 1000000007;

        int n = A.length();
        int m = B.length();

        ArrayList<Long> dp = new ArrayList<>();

        for (int i = 0; i <= m; i++) {
            dp.add(0L);
        }

        dp.set(0, 1L);

        for (int i = 0; i < n; i++) {

            for (int j = m; j >= 1; j--) {

                if (A.charAt(i) == B.charAt(j - 1)) {

                    long ways = (dp.get(j) + dp.get(j - 1)) % MOD;

                    dp.set(j, ways);
                }
            }
        }

        return dp.get(m).intValue();
    }
}
