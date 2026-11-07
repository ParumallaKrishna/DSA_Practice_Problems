package com.scaler.module_2.assignments.DSA_Module_6.DP_5;

import java.util.ArrayList;

/*Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' . ' : Matches any single character.
' * ' : Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Problem Constraints

1 <= length(A), length(B) <= 104



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B denoting the pattern.



Output Format

Return 1 if the patterns match else return 0.



Example Input

Input 1:

 A = "aab"
 B = "c*a*b"
Input 2:

 A = "acz"
 B = "a.a"


Example Output

Output 1:

 1
Output 2:

 0*/
public class DP_5 {
    public int isMatch(final String A, final String B) {

        int n = A.length();
        int m = B.length();

        ArrayList<Boolean> prev = new ArrayList<>();
        ArrayList<Boolean> curr = new ArrayList<>();

        for (int j = 0; j <= m; j++) {
            prev.add(false);
            curr.add(false);
        }

        prev.set(0, true);

        // Initialize empty string matching patterns like a*, a*b*
        for (int j = 2; j <= m; j++) {

            if (B.charAt(j - 1) == '*') {
                prev.set(j, prev.get(j - 2));
            }
        }

        for (int i = 1; i <= n; i++) {

            curr.set(0, false);

            for (int j = 1; j <= m; j++) {

                char a = A.charAt(i - 1);
                char b = B.charAt(j - 1);

                if (b == '*') {

                    // Zero occurrences of preceding character
                    curr.set(j, curr.get(j - 2));

                    // One or more occurrences
                    char preceding = B.charAt(j - 2);

                    if (preceding == '.' || preceding == a) {

                        if (prev.get(j)) {
                            curr.set(j, true);
                        }
                    }

                } else if (b == '.' || b == a) {

                    curr.set(j, prev.get(j - 1));

                } else {

                    curr.set(j, false);
                }
            }

            ArrayList<Boolean> temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev.get(m) ? 1 : 0;
    }
}
