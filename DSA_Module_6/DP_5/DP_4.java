package com.scaler.module_2.assignments.DSA_Module_6.DP_5;

import java.util.ArrayList;

/*Given A, B, C find whether C is formed by the interleaving of A and B.



Problem Constraints

1 <= length(A), length(B) <= 100

1 <= length(C) <= 200



Input Format

The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.



Output Format

Return 1 if string C is formed by interleaving of A and B else 0.



Example Input

Input 1:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbcbcac"
Input 2:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbbaccc"


Example Output

Output 1:

 1
Output 2:

 0*/
public class DP_4 {
    public int isInterleave(String A, String B, String C) {

        int n = A.length();
        int m = B.length();

        // Length condition
        if (n + m != C.length()) {
            return 0;
        }

        ArrayList<Boolean> dp = new ArrayList<>();

        for (int j = 0; j <= m; j++) {
            dp.add(false);
        }

        dp.set(0, true);

        // Initialize using only B
        for (int j = 1; j <= m; j++) {

            dp.set(j,
                    dp.get(j - 1) &&
                            B.charAt(j - 1) == C.charAt(j - 1)
            );
        }

        for (int i = 1; i <= n; i++) {

            // Initialize using only A
            dp.set(0,
                    dp.get(0) &&
                            A.charAt(i - 1) == C.charAt(i - 1)
            );

            for (int j = 1; j <= m; j++) {

                int k = i + j - 1;

                boolean takeA =
                        dp.get(j) &&
                                A.charAt(i - 1) == C.charAt(k);

                boolean takeB =
                        dp.get(j - 1) &&
                                B.charAt(j - 1) == C.charAt(k);

                dp.set(j, takeA || takeB);
            }
        }

        return dp.get(m) ? 1 : 0;
    }
}
