package com.scaler.module_2.assignments.DSA_Module_1.Matrices;

import java.util.ArrayList;

/*You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.
Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
0 <= A[i][j] <= 103
Input Format
First argument is a 2D integer matrix A.
Output Format
Return a 2D matrix after doing required operations.
Example Input
Input 1:
[1,2,3,4]
[5,6,7,0]
[9,2,0,4]
Example Output
Output 1:
[1,2,0,0]
[0,0,0,0]
[0,0,0,0]
*/
public class Matrices12 {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        boolean[] zeroRow = new boolean[rows];
        boolean[] zeroCol = new boolean[cols];
        // Step 1: Find rows and columns containing 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A.get(i).get(j) == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }
        // Step 2: Make required rows zero
        for (int i = 0; i < rows; i++) {
            if (zeroRow[i]) {
                for (int j = 0; j < cols; j++) {
                    A.get(i).set(j, 0);
                }
            }
        }
        // Step 3: Make required columns zero
        for (int j = 0; j < cols; j++) {
            if (zeroCol[j]) {
                for (int i = 0; i < rows; i++) {
                    A.get(i).set(j, 0);
                }
            }
        }
        return A;
    }
}
