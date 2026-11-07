package com.scaler.module_2.assignments.DSA_Module_6.DP_5;

import java.util.ArrayList;

/*Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).



The matching should cover the entire input string (not partial).






Problem Constraints

1 <= length(A), length(B) <= 104



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B.



Output Format

Return 1 if the patterns match else return 0.



Example Input

Input 1:

 A = "aaa"
 B = "a*"
Input 2:

 A = "acz"
 B = "a?a"


Example Output

Output 1:

 1
Output 2:

 0
*/
public class DP_3 {
    public int isMatch(final String A, final String B) {

        int n = A.length();
        int m = B.length();

        ArrayList<Boolean> dp = new ArrayList<>();

        for (int j = 0; j <= m; j++) {
            dp.add(false);
        }

        dp.set(0, true);

        // Initialize empty string matching pattern prefixes
        for (int j = 1; j <= m; j++) {

            if (B.charAt(j - 1) == '*') {
                dp.set(j, dp.get(j - 1));
            } else {
                dp.set(j, false);
            }
        }

        for (int i = 1; i <= n; i++) {

            boolean diagonal = dp.get(0);

            // Non-empty A cannot match an empty pattern
            dp.set(0, false);

            for (int j = 1; j <= m; j++) {

                boolean up = dp.get(j);

                if (B.charAt(j - 1) == '*') {

                    dp.set(j, dp.get(j - 1) || dp.get(j));

                } else if (B.charAt(j - 1) == '?' ||
                        A.charAt(i - 1) == B.charAt(j - 1)) {

                    dp.set(j, diagonal);

                } else {

                    dp.set(j, false);
                }

                diagonal = up;
            }
        }

        return dp.get(m) ? 1 : 0;
    }
}
