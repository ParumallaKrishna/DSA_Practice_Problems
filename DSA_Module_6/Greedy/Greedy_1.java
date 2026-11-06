package com.scaler.module_2.assignments.DSA_Module_6.Greedy;
/*N children are standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?
Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109
Input Format
The first and only argument is an integer array A representing the rating of children.
Output Format
Return an integer representing the minimum candies to be given.
Example Input
Input 1: A = [1, 2]
Input 2: A = [1, 5, 2, 1]
Example Output
Output 1: 3
Output 2: 7*/
public class Greedy_1 {
    public int candy(int[] A) {

        int n = A.length;

        int[] candies = new int[n];

        // Initially give 1 candy to every child
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Left to right: compare with left neighbor
        for (int i = 1; i < n; i++) {

            if (A[i] > A[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left: compare with right neighbor
        for (int i = n - 2; i >= 0; i--) {

            if (A[i] > A[i + 1]) {
                candies[i] = Math.max(
                        candies[i],
                        candies[i + 1] + 1
                );
            }
        }

        // Calculate total candies
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += candies[i];
        }

        return total;
    }

}
