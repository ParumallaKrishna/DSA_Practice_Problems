package com.scaler.module_2.assignments.DSA_Module_6.DP_5;

import java.util.ArrayList;

/*Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.



Problem Constraints

1 <= Length of A, B <= 1005



Input Format

First argument is a string A.
Second argument is a string B.



Output Format

Return an integer denoting the length of the longest common subsequence.



Example Input

Input 1:

 A = "abbcdgf"
 B = "bbadcgf"
Input 2:

 A = "aaaaaa"
 B = "ababab"


Example Output

Output 1:

 5
Output 2:

 3
*/
public class DP_2 {
    public int solve(String A, String B) {

        int n = A.length();
        int m = B.length();

        ArrayList<Integer> prev = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();

        for (int j = 0; j <= m; j++) {
            prev.add(0);
            curr.add(0);
        }

        for (int i = 1; i <= n; i++) {

            curr.set(0, 0);

            for (int j = 1; j <= m; j++) {

                if (A.charAt(i - 1) == B.charAt(j - 1)) {

                    curr.set(j, prev.get(j - 1) + 1);

                } else {

                    curr.set(j, Math.max(
                            prev.get(j),
                            curr.get(j - 1)
                    ));
                }
            }

            ArrayList<Integer> temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev.get(m);
    }
}
