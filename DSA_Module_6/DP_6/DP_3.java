package com.scaler.module_2.assignments.DSA_Module_6.DP_6;

import java.util.ArrayList;

/*Given a string A, partition A such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of A.



Problem Constraints

1 <= length(A) <= 501



Input Format

The first and the only argument contains the string A.



Output Format

Return an integer, representing the minimum cuts needed.



Example Input

Input 1:

 A = "aba"
Input 2:

 A = "aab"


Example Output

Output 1:

 0
Output 2:

 1*/
public class DP_3 {
    public int minCut(String A) {

        int n = A.length();

        // Check whether substring i to j is palindrome
        ArrayList<ArrayList<Boolean>> palindrome = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Boolean> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(false);
            }

            palindrome.add(row);
        }

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (A.charAt(i) == A.charAt(j) &&
                        (j - i <= 2 || palindrome.get(i + 1).get(j - 1))) {

                    palindrome.get(i).set(j, true);
                }
            }
        }

        // DP: minimum cuts required for prefix ending at i
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dp.add(i);
        }

        for (int i = 0; i < n; i++) {

            if (palindrome.get(0).get(i)) {
                dp.set(i, 0);
                continue;
            }

            for (int j = 1; j <= i; j++) {

                if (palindrome.get(j).get(i)) {

                    dp.set(i, Math.min(
                            dp.get(i),
                            dp.get(j - 1) + 1
                    ));
                }
            }
        }

        return dp.get(n - 1);
    }
}
