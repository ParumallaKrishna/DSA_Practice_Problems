package com.scaler.module_2.assignments.DSA_Module_1.Matrices;

import java.util.ArrayList;

/*Given a 2D integer array A, return the transpose of A.
The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
Problem Constraints
1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000
Input Format
First argument is a 2D matrix of integers.
Output Format
You have to return the Transpose of this 2D matrix.
Example Input
Input 1: A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2: A = [[1, 2],[1, 2],[1, 2]]
Example Output
Output 1: [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Output 2: [[1, 1, 1], [2, 2, 2]]*/
public class Matrices6 {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int j = 0; j < cols; j++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                row.add(A.get(i).get(j));
            }
            result.add(row);
        }
        return result;
    }
}
