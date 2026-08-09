package com.scaler.module_2.assignments.DSA_Module_1.Matrices;

import java.util.ArrayList;

/*You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.
Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
1 <= A[i][j] <= 103
Input Format
First argument is a 2D array of integers.(2D matrix).
Output Format
Return an array containing column-wise sums of original matrix.
Example Input
Input 1:
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]
Example Output
Output 1: {15,10,13,16}*/
public class Matrices1 {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += A.get(i).get(j);
            }
            result.add(sum);
        }
        return result;
    }
}
