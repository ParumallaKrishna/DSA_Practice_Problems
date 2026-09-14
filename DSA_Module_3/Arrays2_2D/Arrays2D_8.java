package com.scaler.module_2.assignments.DSA_Module_3.Arrays2_2D;
import java.util.ArrayList;
/*Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.
NOTE:
If two rows have the maximum number of 1 then return the row which has a lower index.
Rows are numbered from top to bottom and columns are numbered from left to right.
Assume 0-based indexing.
Assume each row to be sorted by values.
Expected time complexity is O(rows + columns).
Problem Constraints
1 <= N <= 1000
0 <= A[i] <= 1
Input Format
The only argument given is the integer matrix A.
Output Format
Return the row with the maximum number of 1.
Example Input
Input 1:
 A = [   [0, 1, 1]
         [0, 0, 1]
         [0, 1, 1]   ]
Input 2:
 A = [   [0, 0, 0, 0]
         [0, 0, 0, 1]
         [0, 0, 1, 1]
         [0, 1, 1, 1]    ]
Example Output
Output 1: 0
Output 2: 3*/
public class Arrays2D_8 {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int row = 0;
        int col = N - 1;
        int ans = -1;
        int firstOne = N;
        while (row < N && col >= 0) {
            if (A.get(row).get(col) == 1) {
                // Found a 1 further to the left
                if (col < firstOne) {
                    firstOne = col;
                    ans = row;
                }
                col--;
            } else {
                row++;
            }
        }
        return ans;
    }
}
