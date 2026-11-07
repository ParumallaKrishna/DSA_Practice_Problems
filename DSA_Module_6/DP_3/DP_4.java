package com.scaler.module_2.assignments.DSA_Module_6.DP_3;

import java.util.ArrayList;
import java.util.Collections;

/*Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

NOTE:

You can break an item for maximizing the total value of the knapsack



Problem Constraints

1 <= N <= 105

1 <= A[i], B[i] <= 103

1 <= C <= 103




Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.




Output Format

Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 24000
Output 2:

 2105*/
public class DP_4 {
    public int solve(int[] A, int[] B, int C) {

        int n = A.length;

        // Store value, weight and ratio
        ArrayList<double[]> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            double ratio = (double) A[i] / B[i];

            items.add(new double[]{A[i], B[i], ratio});
        }

        // Sort items by descending value/weight ratio
        Collections.sort(items, (x, y) ->
                Double.compare(y[2], x[2])
        );

        double maxValue = 0.0;
        int remainingCapacity = C;

        for (int i = 0; i < n; i++) {

            double value = items.get(i)[0];
            double weight = items.get(i)[1];

            if (remainingCapacity == 0) {
                break;
            }

            // Take the complete item
            if (weight <= remainingCapacity) {

                maxValue += value;
                remainingCapacity -= (int) weight;
            }

            // Take only the fraction that fits
            else {

                maxValue += value * remainingCapacity / weight;
                remainingCapacity = 0;
            }
        }

        return (int) Math.floor(maxValue * 100 + 1e-9);
    }
}
