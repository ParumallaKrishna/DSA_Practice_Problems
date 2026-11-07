package com.scaler.module_2.assignments.DSA_Module_6.DP_3;

import java.util.ArrayList;

/*Rishik likes candies a lot. So, he went to a candy-shop to buy candies.

The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles, each candy in that packet has a sweetness B[i]. The shopkeeper puts the condition that Rishik can buy as many complete candy-packets as he wants but he can't buy a part of the packet.

Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?


Problem Constraints

1 <= N <= 700

1 <= A[i] <= 1000

1 <= B[i] <= 1000

1 <= C[i],D <= 1000



Input Format

First argument of input is an integer array A
Second argument of input is an integer array B
Third argument of input is an integer array C
Fourth argument of input is an integer D


Output Format

Return a single integer denoting maximum sweetness of the candies that he can buy


Example Input

Input 1:

 A = [1, 2, 3]
 B = [2, 2, 10]
 C = [2, 3, 9]
 D = 8
Input 2:

 A = [2]
 B = [5]
 C = [10]
 D = 99


Example Output

Output 1:

 10
Output 2:

 90*/
public class DP_5 {
    public int solve(int[] A, int[] B, int[] C, int D) {

        int n = A.length;

        // dp[w] = maximum sweetness with budget w
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= D; i++) {
            dp.add(0);
        }

        // Unbounded Knapsack
        for (int w = 1; w <= D; w++) {

            for (int i = 0; i < n; i++) {

                int cost = C[i];
                int sweetness = A[i] * B[i];

                if (cost <= w) {

                    int current = sweetness + dp.get(w - cost);

                    dp.set(w, Math.max(dp.get(w), current));
                }
            }
        }

        return dp.get(D);
    }
}
