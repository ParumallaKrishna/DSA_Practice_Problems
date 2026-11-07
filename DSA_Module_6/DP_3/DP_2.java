package com.scaler.module_2.assignments.DSA_Module_6.DP_3;

import java.util.ArrayList;

/*Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.



Problem Constraints

1 <= A <= 1000

1 <= |B| <= 1000

1 <= B[i] <= 1000

1 <= C[i] <= 1000



Input Format

First argument is the Weight of knapsack A

Second argument is the vector of values B

Third argument is the vector of weights C



Output Format

Return the maximum value that fills the knapsack completely



Example Input

Input 1:

A = 10
B = [5]
C = [10]
Input 2:

A = 10
B = [6, 7]
C = [5, 5]


Example Output

Output 1:

 5
Output 2:

14*/
public class DP_2 {
    public int solve(int A, int[] B, int[] C) {

        int n = B.length;

        ArrayList<Integer> dp = new ArrayList<>();

        // Initialize all capacities as unreachable
        for (int i = 0; i <= A; i++) {
            dp.add(Integer.MIN_VALUE);
        }

        // Zero capacity requires zero value
        dp.set(0, 0);

        // Calculate maximum value for each exact capacity
        for (int w = 1; w <= A; w++) {

            for (int i = 0; i < n; i++) {

                if (C[i] <= w && dp.get(w - C[i]) != Integer.MIN_VALUE) {

                    int currentValue = B[i] + dp.get(w - C[i]);

                    dp.set(w, Math.max(dp.get(w), currentValue));
                }
            }
        }

        return dp.get(A);
    }
}
