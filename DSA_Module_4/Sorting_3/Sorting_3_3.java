package com.scaler.module_2.assignments.DSA_Module_4.Sorting_3;

import java.util.ArrayList;

/*Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 105
Input Format
The first argument is an integer array A.
Output Format
Return an integer array that is the sorted array A.
Example Input
Input 1: A = [1, 3, 1]
Input 2: A = [4, 2, 1, 3]
Example Output
Output 1: [1, 1, 3]
Output 2: [1, 2, 3, 4]*/
public class Sorting_3_3 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int max = 100000;
        ArrayList<Integer> freq = new ArrayList<>();
        // Create frequency array
        for (int i = 0; i <= max; i++) {
            freq.add(0);
        }
        // Count frequency
        for (int i = 0; i < A.size(); i++) {
            int value = A.get(i);
            freq.set(value, freq.get(value) + 1);
        }
        // Build sorted array
        int index = 0;
        for (int value = 1; value <= max; value++) {
            int count = freq.get(value);
            while (count > 0) {
                A.set(index, value);
                index++;
                count--;
            }
        }
        return A;
    }
}
