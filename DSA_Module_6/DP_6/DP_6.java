package com.scaler.module_2.assignments.DSA_Module_6.DP_6;

import java.util.ArrayList;

/*Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).

You need to return the length of longest palindromic subsequence.



Problem Constraints

1 <= length of(A) <= 103



Input Format

First and only integer is a string A.



Output Format

Return an integer denoting the length of longest palindromic subsequence.



Example Input

Input 1:

 A = "bebeeed"
Input 2:

 A = "aedsead"


Example Output

Output 1:

 4
Output 2:

 5
*/
public class DP_6 {
    public int solve(String A) {

        int n = A.length();

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        // Initialize DP table
        for (int i = 0; i < n; i++) {

            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(0);
            }

            dp.add(row);
        }

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp.get(i).set(i, 1);
        }

        // Process substrings by increasing length
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                if (A.charAt(i) == A.charAt(j)) {

                    int innerLength = 0;

                    if (len > 2) {
                        innerLength = dp.get(i + 1).get(j - 1);
                    }

                    dp.get(i).set(j, 2 + innerLength);

                } else {

                    dp.get(i).set(j,
                            Math.max(
                                    dp.get(i + 1).get(j),
                                    dp.get(i).get(j - 1)
                            )
                    );
                }
            }
        }

        return dp.get(0).get(n - 1);
    }
}
