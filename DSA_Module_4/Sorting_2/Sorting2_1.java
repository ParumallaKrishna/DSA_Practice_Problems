package com.scaler.module_2.assignments.DSA_Module_4.Sorting_2;

import java.util.ArrayList;
import java.util.Collections;

/*You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.
Find the minimum number of steps.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
Input Format
The only argument given is an Array A, having N integers.
Output Format
Return the minimum number of steps required to make all elements unique.
Example Input
Input 1: A = [1, 1, 3]
Input 2: A = [2, 4, 5]
Example Output
Output 1: 1
Output 2: 0*/
public class Sorting2_1 {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        long steps = 0;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) <= A.get(i - 1)) {
                int newValue = A.get(i - 1) + 1;
                steps += (long) newValue - A.get(i);
                A.set(i, newValue);
            }
        }
        return (int) steps;
    }
}
