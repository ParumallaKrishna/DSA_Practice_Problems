package com.scaler.module_2.assignments.DSA_Module_1.Matrices;
import java.util.ArrayList;
/*You are given a 2D matrix A of integers.
Your task is to compute the sum of elements in each row and return a 1D array where each element represents the sum of a corresponding row in the matrix.
Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
1 <= A[i][j] <= 103
Input Format
First argument A is a 2D array of integers.(2D matrix).
Output Format
Return an array containing row-wise sums of original matrix.
Example Input
Input 1:
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]
Example Output
Output 1: [10,26,18]*/
public class Matrices2 {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int rows = A.size();
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < A.get(i).size(); j++) {
                sum += A.get(i).get(j);
            }
            result.add(sum);
        }
        return result;
    }
}
