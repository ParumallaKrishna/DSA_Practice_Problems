package com.scaler.module_2.assignments.DSA_Module_1.Carry_Farword;

import java.util.ArrayList;

/*Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Return the maximum possible profit.
Problem Constraints
0 <= A.size() <= 700000
1 <= A[i] <= 107
Input Format
The first and the only argument is an array of integers, A.
Output Format
Return an integer, representing the maximum possible profit.
Example Input
Input 1: A = [1, 2]
Input 2: A = [1, 4, 5, 2, 4]
Example Output
Output 1: 1
Output 2: 4
*/
public class CF4 {
    public int solve(ArrayList<Integer> A) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < A.size(); i++) {
            // Find the minimum buying price
            minPrice = Math.min(minPrice, A.get(i));
            // Calculate profit if we sell today
            int profit = A.get(i) - minPrice;
            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
