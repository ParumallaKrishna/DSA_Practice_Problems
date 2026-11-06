package com.scaler.module_2.assignments.DSA_Module_6.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/*In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management. Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays, A and B of size N. A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit margin for the ith item. To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.
The objective is to identify a method to strategically buy certain items, ensuring they are sold before their expiration date, thereby maximizing overall profit. Can you assist Flipkart in developing an innovative approach to optimize their grocery inventory and enhance profitability?
Your task is to find the maximum profit one can earn by buying groceries considering that you can only buy one grocery item at a time.
NOTE:
You can assume that it takes 1 minute to buy a grocery item, so you can only buy the ith grocery item when the current time <= A[i] - 1.
You can start buying from day = 0.
Return your answer modulo 109 + 7.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
0 <= B[i] <= 109
Input Format
The first argument is an integer array A represents the deadline for buying the grocery items.
The second argument is an integer array B represents the profit obtained after buying the grocery items.
Output Format
Return an integer denoting the maximum profit you can earn.
Example Input
Input 1: A = [1, 3, 2, 3, 3] B = [5, 6, 1, 3, 9]
Input 2: A = [3, 8, 7, 5] B = [3, 1, 7, 19]
Example Output
Output 1: 20
Output 2: 30*/
public class Greedy_3 {
    static final int MOD = 1000000007;

    public int solve(int[] A, int[] B) {

        int n = A.length;

        // Store deadline and profit
        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = A[i];
            items[i][1] = B[i];
        }

        // Sort by deadline
        Arrays.sort(items, (x, y) ->
                Integer.compare(x[0], y[0])
        );

        // Min Heap to remove lowest profit
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            int deadline = items[i][0];
            int profit = items[i][1];

            pq.add(profit);

            // Remove lowest profit if deadline capacity is exceeded
            if (pq.size() > deadline) {
                pq.poll();
            }
        }

        // Calculate maximum profit
        long total = 0;

        while (!pq.isEmpty()) {
            total = (total + pq.poll()) % MOD;
        }

        return (int) total;
    }
}
