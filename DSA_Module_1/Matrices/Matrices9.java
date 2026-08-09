package com.scaler.module_2.assignments.DSA_Module_1.Matrices;

import java.util.ArrayList;

/*You are given two matrices A and B of equal dimensions and you have to check whether two matrices are equal or not.
NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j.
Problem Constraints
1 <= A.size(), B.size() <= 1000
1 <= A[i].size(), B[i].size() <= 1000
1 <= A[i][j], B[i][j] <= 1000
A.size() == B.size()
A[i].size() == B[i].size()
Input Format
First argument is 2-D array of integers representing matrix A.
Second argument is 2-D array of integers representing matrix B.
Output Format
Return 1 if both matrices are equal or return 0.
Example Input
Input 1:
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
B = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
Input 2:
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
B = [[1, 2, 3],
     [7, 8, 9],
     [4, 5, 6]]
Example Output
Output 1: 1
Output 2: 0*/
public class Matrices9 {
    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int rows = A.size();
        int cols = A.get(0).size();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!A.get(i).get(j).equals(B.get(i).get(j))) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
