package com.scaler.module_2.assignments.DSA_Module_3.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;

/*Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109
Input Format
First and only argument of input contains an integer array A.
Output Format
Return a single integer denoting minimum xor value.
Example Input
Input 1: A = [0, 2, 5, 7]
Input 2: A = [0, 4, 7, 9]
Example Output
Output 1: 2
Output 2: 3*/
public class BM6 {
    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int minXor = Integer.MAX_VALUE;
        // Check only adjacent elements
        for (int i = 0; i < A.size() - 1; i++) {
            int currentXor = A.get(i) ^ A.get(i + 1);
            minXor = Math.min(minXor, currentXor);
        }
        return minXor;
    }
}
