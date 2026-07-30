package com.scaler.module_2.assignments.DSA_Module_1.Intro_to_Array;
/*Given an array A of N integers.
Count the number of elements that have at least 1 elements greater than itself.
Problem Constraints
1 <= N <= 103
1 <= A[i] <= 109
Input Format
First and only argument is an array of integers A.
Output Format
Return the count of elements.
Input 1:
A = [3, 1, 2]
Input 2:
A = [5, 5, 3]
Output 1:
2
Output 2:
1*/
public class Array_1 {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int num : A) {
            max = Math.max(max, num);
        }
        int maxCount = 0;
        for (int num : A) {
            if (num == max) {
                maxCount++;
            }
        }
        return A.length - maxCount;
    }
}