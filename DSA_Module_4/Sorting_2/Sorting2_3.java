package com.scaler.module_2.assignments.DSA_Module_4.Sorting_2;

import java.util.ArrayList;
import java.util.Collections;

/*Given an array of integers A, sort the array into a wave-like array and return it.
In other words, arrange the elements into a sequence such that
a1 >= a2 <= a3 >= a4 <= a5.....
NOTE: If multiple answers are possible, return the lexicographically smallest one.
Problem Constraints
1 <= len(A) <= 106
0 <= A[i] <= 106
Input Format
The first argument is an integer array A.
Output Format
Return an array arranged in the sequence as described.
Example Input
Input 1: A = [1, 2, 3, 4]
Input 2: A = [1, 2]
Example Output
Output 1: [2, 1, 4, 3]
Output 2: [2, 1]*/
public class Sorting2_3 {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        // Step 1: Sort the array
        Collections.sort(A);
        // Step 2: Swap adjacent elements
        for (int i = 0; i + 1 < A.size(); i += 2) {
            int temp = A.get(i);
            A.set(i, A.get(i + 1));
            A.set(i + 1, temp);
        }
        return A;
    }
}
