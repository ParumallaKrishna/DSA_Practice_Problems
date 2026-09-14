package com.scaler.module_2.assignments.DSA_Module_3.Arrays2_2D;
import java.util.ArrayList;
/*Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
It is allowed to swap any two elements (not necessarily consecutive).
Find the minimum number of swaps required to sort the array in ascending order.
Problem Constraints
1 <= N <= 100000
0 <= A[i] < N
Input Format
The only argument given is the integer array A.
Output Format
Return the minimum number of swaps.
Example Input
Input 1:
A = [1, 2, 3, 4, 0]
Input 2:
A = [2, 0, 1, 3]
Example Output
Output 1: 4
Output 2: 2*/
public class Arrays2D_7 {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            // If current element is already correct
            if (A.get(i) == i) {
                continue;
            }
            // Keep swapping until A[i] is correct
            while (A.get(i) != i) {
                int correctIndex = A.get(i);
                // Swap A[i] with A[correctIndex]
                int temp = A.get(i);
                A.set(i, A.get(correctIndex));
                A.set(correctIndex, temp);
                swaps++;
            }
        }
        return swaps;
    }
}
