package com.scaler.module_2.assignments.DSA_Module_3.Arrays1_1D;

import java.util.ArrayList;

/*You are given an array of N integers, A1, A2, .... AN.
Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
Problem Constraints
1 <= N <= 100000
-109 <= A[i] <= 109
Input Format
First argument is an integer array A of size N.
Output Format
Return an integer denoting the maximum value of f(i, j).
Example Input
Input 1: A = [1, 3, -1]
Input 2: A = [2]
Example Output
Output 1: 5
Output 2: 0*/
public class Arrays4 {
    public int maxArr(ArrayList<Integer> A) {
        long maxPlus = Long.MIN_VALUE;
        long minPlus = Long.MAX_VALUE;
        long maxMinus = Long.MIN_VALUE;
        long minMinus = Long.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            long plus = (long) A.get(i) + i;
            long minus = (long) A.get(i) - i;
            maxPlus = Math.max(maxPlus, plus);
            minPlus = Math.min(minPlus, plus);
            maxMinus = Math.max(maxMinus, minus);
            minMinus = Math.min(minMinus, minus);
        }
        long ans = Math.max(
                maxPlus - minPlus,
                maxMinus - minMinus
        );
        return (int) ans;
    }
}
