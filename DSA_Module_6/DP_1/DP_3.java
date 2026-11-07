package com.scaler.module_2.assignments.DSA_Module_6.DP_1;

import java.util.ArrayList;

/*Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
Problem Constraints
1 <= A <= 105
Input Format
First and only argument is an integer A.
Output Format
Return an integer denoting the minimum count.
Example Input
Input 1:
 A = 6
Input 2:
 A = 5
Example Output
Output 1:
 3
Output 2:
 2*/
public class DP_3 {
    public int countMinSquares(int A) {

        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            dp.add(0);
        }

        dp.set(0, 0);

        for (int i = 1; i <= A; i++) {

            // Maximum possible count is i (1 + 1 + ... + 1)
            dp.set(i, i);

            for (int j = 1; j * j <= i; j++) {

                int square = j * j;

                int count = 1 + dp.get(i - square);

                dp.set(i, Math.min(dp.get(i), count));
            }
        }

        return dp.get(A);
    }

}
