package com.scaler.module_2.assignments.DSA_Module_6.DP_4;

import java.util.ArrayList;

/*In Danceland, one person can party either alone or can pair up with another person.

Can you find in how many ways they can party if there are A people in Danceland?

Note: Return your answer modulo 10003, as the answer can be large.



Problem Constraints

1 <= A <= 105



Input Format

Given only argument A of type Integer, number of people in Danceland.



Output Format

Return an integer denoting the number of ways people of Danceland can party.



Example Input

Input 1:

 A = 3
Input 2:

 A = 5


Example Output

Output 1:

 4
Output 2:

 26*/
public class DP_6 {
    public int solve(int A) {

        int MOD = 10003;

        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            dp.add(0);
        }

        dp.set(0, 1);
        dp.set(1, 1);

        for (int i = 2; i <= A; i++) {

            long ways = dp.get(i - 1)
                    + (long)(i - 1) * dp.get(i - 2);

            dp.set(i, (int)(ways % MOD));
        }

        return dp.get(A);
    }
}
