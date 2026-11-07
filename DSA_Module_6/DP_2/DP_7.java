package com.scaler.module_2.assignments.DSA_Module_6.DP_2;

import java.util.ArrayList;

/*Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords intersect.

Two ways are different if there exists a chord which is present in one way and not in other.
Return the answer modulo 109 + 7.



Problem Constraints

1 <= A <= 103



Input Format

The first and the only argument contains the integer A.



Output Format

Return an integer answering the query as described in the problem statement.



Example Input

Input 1:

 A = 1
Input 2:

 A = 2


Example Output

Output 1:

 1
Output 2:

 2*/
public class DP_7 {
    public int chordCnt(int A) {

        int MOD = 1000000007;

        ArrayList<Long> dp = new ArrayList<>();

        // Initialize DP array
        for (int i = 0; i <= A; i++) {
            dp.add(0L);
        }

        dp.set(0, 1L);

        // Calculate Catalan numbers
        for (int i = 1; i <= A; i++) {

            long ways = 0;

            for (int j = 0; j < i; j++) {

                long left = dp.get(j);
                long right = dp.get(i - j - 1);

                ways = (ways + (left * right) % MOD) % MOD;
            }

            dp.set(i, ways);
        }

        return dp.get(A).intValue();
    }
}
