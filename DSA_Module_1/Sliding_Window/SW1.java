package com.scaler.module_2.assignments.DSA_Module_1.Sliding_Window;

import java.util.ArrayList;

/*Given an array A of length N. Also given are integers B and C.
Return 1 if there exists a subarray with length B having sum C and 0 otherwise
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 104
1 <= B <= N
1 <= C <= 109
Input Format
First argument A is an array of integers.
The remaining arguments B and C are integers
Output Format
Return 1 if such a subarray exist and 0 otherwise
Example Input
Input 1: A = [4, 3, 2, 6, 1] B = 3 C = 11
Input 2: A = [4, 2, 2, 5, 1] B = 4 C = 6
Example Output
Output 1: 1
Output 2: 0*/
public class SW1 {
    public int solve(ArrayList<Integer> A, int B, int C) {
        int n = A.size();
        int sum = 0;
        // Calculate sum of first B elements
        for (int i = 0; i < B; i++) {
            sum += A.get(i);
        }
        // Check first window
        if (sum == C) {
            return 1;
        }
        // Slide the window
        for (int i = B; i < n; i++) {
            // Add new element
            sum += A.get(i);
            // Remove element leaving the window
            sum -= A.get(i - B);
            if (sum == C) {
                return 1;
            }
        }
        return 0;
    }
}
