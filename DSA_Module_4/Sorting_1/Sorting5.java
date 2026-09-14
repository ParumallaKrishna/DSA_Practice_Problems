package com.scaler.module_2.assignments.DSA_Module_4.Sorting_1;

import java.util.ArrayList;
import java.util.Collections;

/*Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.
Problem Constraints
2 <= length of the array <= 100000
-109 <= A[i] <= 109
Input Format
The only argument given is the integer array A.
Output Format
Return the minimum value of | A[i] - A[j] |.
Example Input
Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [5, 17, 100, 11]
Example Output
Output 1: 1
Output 2: 6*/
public class Sorting5 {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        long minDiff = Long.MAX_VALUE;
        for (int i = 1; i < A.size(); i++) {
            long diff = (long) A.get(i) - A.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }
        return (int) minDiff;
    }
}
