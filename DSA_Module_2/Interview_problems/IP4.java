package com.scaler.module_2.assignments.DSA_Module_2.Interview_problems;

import java.util.ArrayList;

/*Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.
Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.
Problem Constraints
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000
Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.
Output Format
Return the resultant matrix.
Example Input
Input 1: A = [1, 2, 3, 4, 5] B = [2, 3]
Input 2: A = [5, 17, 100, 11] B = [1]
Example Output
Output 1: [ [3, 4, 5, 1, 2] [4, 5, 1, 2, 3] ]
Output 2: [ [17, 100, 11, 5] ]*/
public class IP4 {
    public ArrayList<ArrayList<Integer>> solve(
            ArrayList<Integer> A,
            ArrayList<Integer> B) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int rotation : B) {
            ArrayList<Integer> row = new ArrayList<>();
            // In case rotation >= n
            rotation = rotation % n;
            // Add elements from rotation index to end
            for (int i = rotation; i < n; i++) {
                row.add(A.get(i));
            }
            // Add elements from beginning to rotation index
            for (int i = 0; i < rotation; i++) {
                row.add(A.get(i));
            }
            result.add(row);
        }
        return result;
    }
}
