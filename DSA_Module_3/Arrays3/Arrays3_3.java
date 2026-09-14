package com.scaler.module_2.assignments.DSA_Module_3.Arrays3;

import java.util.ArrayList;

/*Given an unsorted integer array, A of size N. Find the first missing positive integer.
Note: Your algorithm should run in O(n) time and use constant space.
Problem Constraints
1 <= N <= 1000000
-109 <= A[i] <= 109
Input Format
First argument is an integer array A.
Output Format
Return an integer denoting the first missing positive integer.
Example Input
Input 1: [1, 2, 0]
Input 2: [3, 4, -1, 1]
Input 3: [-8, -7, -6]
Example Output
Output 1: 3
Output 2: 2
Output 3: 1*/
public class Arrays3_3 {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        // Place each number x at index x - 1
        for (int i = 0; i < n; i++) {
            while (A.get(i) >= 1 &&
                    A.get(i) <= n &&
                    !A.get(A.get(i) - 1).equals(A.get(i))) {
                int correctIndex = A.get(i) - 1;
                // Swap
                int temp = A.get(i);
                A.set(i, A.get(correctIndex));
                A.set(correctIndex, temp);
            }
        }
        // Find first missing positive
        for (int i = 0; i < n; i++) {
            if (A.get(i) != i + 1) {
                return i + 1;
            }
        }
        // All 1 to N are present
        return n + 1;
    }
}
