package com.scaler.module_2.assignments.DSA_Module_2.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.
If a number has no tens digit, we can assume value to be 0.
If 2 numbers have same tens digit, in that case number with max value will come first
Solution should be based on comparator.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
Input Format
First argument A is an array of integers.
Output Format
Return the array after sorting
Example Input
Input 1: A = [15, 11, 7, 19]
Input 2: A = [2, 24, 22, 19]
Example Output
Output 1: [7, 19, 15, 11]
Output 2: [2, 19, 24, 22]*/
public class Sorting7 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int tensA = (a / 10) % 10;
                int tensB = (b / 10) % 10;
                // First priority: tens digit in increasing order
                if (tensA != tensB) {
                    return tensA - tensB;
                }
                // Second priority: larger number first
                return b - a;
            }
        });
        return A;
    }
}
