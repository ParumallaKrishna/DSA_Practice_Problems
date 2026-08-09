package com.scaler.module_2.assignments.DSA_Module_2.Sorting;

import java.util.ArrayList;
import java.util.Collections;

/*Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
Problem Constraint
2 <= N <= 105
-109 <= A[i] <= 109
Input Format
The first and only argument is an integer array A of size N.
Output Format
Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0.
Example Input
Input 1: A = [3, 5, 1]
Input 2: A = [2, 4, 1]
Example Output
Output 1: 1
Output 2: 0*/
public class Sorting6 {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int difference = A.get(1) - A.get(0);
        for (int i = 2; i < A.size(); i++) {
            if (A.get(i) - A.get(i - 1) != difference) {
                return 0;
            }
        }
        return 1;
    }
}
