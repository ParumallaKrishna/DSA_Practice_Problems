package com.scaler.module_2.assignments.DSA_Module_3.Arrays2_2D;

import java.util.ArrayList;

/*Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
Note: It is possible to swap any two elements, not necessarily consecutive.
Problem Constraints
1 <= length of the array <= 100000
-109 <= A[i], B <= 109
Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return the minimum number of swaps.
Example Input
Input 1: A = [1, 12, 10, 3, 14, 10, 5] B = 8
Input 2: A = [5, 17, 100, 11] B = 20
Example Output
Output 1: 2
Output 2: 1*/
public class Arrays2D_6 {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        // Step 1: Count elements <= B
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) <= B) {
                k++;
            }
        }
        // If all elements are good or no good elements
        if (k == 0 || k == n) {
            return 0;
        }
        // Step 2: Count good elements in first window of size k
        int good = 0;
        for (int i = 0; i < k; i++) {
            if (A.get(i) <= B) {
                good++;
            }
        }
        int maxGood = good;
        // Step 3: Sliding window
        for (int i = k; i < n; i++) {
            // Add new element
            if (A.get(i) <= B) {
                good++;
            }
            // Remove old element
            if (A.get(i - k) <= B) {
                good--;
            }
            maxGood = Math.max(maxGood, good);
        }
        // Minimum bad elements in any window
        return k - maxGood;
    }
}
