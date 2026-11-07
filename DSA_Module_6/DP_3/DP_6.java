package com.scaler.module_2.assignments.DSA_Module_6.DP_3;

import java.util.ArrayList;

/*As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.

Each friend can take any dish unlimited number of times.

There always exists a dish with filling capacity 1 so that a solution always exists.



Problem Constraints

|A| <= 1000

|B| <= 1000

|C| <= 1000



Input Format

First Argument is vector A, denoting eating capacities

Second Argument is vector B, denoting filling capacities

Third Argument is vector C, denoting cost



Output Format

Return a single integer, the answer to the problem



Example Input

Input 1:

A = [2, 4, 6]
B = [2, 1, 3]
C = [2, 5, 3]
Input 2:

A = [2]
B = [1]
C = [2]


Example Output

Output 1:

12
Output 2:

4*/
public class DP_6 {
    public int solve(final int[] A, final int[] B, final int[] C) {

        int maxCapacity = 0;

        // Find maximum eating capacity
        for (int capacity : A) {
            maxCapacity = Math.max(maxCapacity, capacity);
        }

        int INF = 1000000000;

        // dp[x] = minimum cost to achieve exact filling x
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= maxCapacity; i++) {
            dp.add(INF);
        }

        dp.set(0, 0);

        // Unbounded Knapsack
        for (int i = 1; i <= maxCapacity; i++) {

            for (int j = 0; j < B.length; j++) {

                int filling = B[j];
                int cost = C[j];

                if (filling <= i && dp.get(i - filling) != INF) {

                    int currentCost = dp.get(i - filling) + cost;

                    dp.set(i, Math.min(dp.get(i), currentCost));
                }
            }
        }

        // Calculate total minimum cost for all friends
        int totalCost = 0;

        for (int capacity : A) {
            totalCost += dp.get(capacity);
        }

        return totalCost;
    }
}
