package com.scaler.module_2.assignments.DSA_Module_1.Matrices;

import java.util.ArrayList;

/*You are given a n x n 2D matrix A representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note: If you end up using an additional array, you will only receive partial score.
Problem Constraints
1 <= n <= 1000
Input Format
First argument is a 2D matrix A of integers
Output Format
Return the 2D rotated matrix.
Example Input
Input 1:
 [ [1, 2],
    [3, 4]]
Input 2:
 [ [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]]
Example Output
Output 1:
 [[3, 1],
    [4, 2]]
Output 2:
 [[7, 4, 1],
    [8, 5, 2],
    [9, 6, 3] ]*/
public class Matrices7 {
    public void solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i));
                A.get(j).set(i, temp);
            }
        }
        // Step 2: Reverse every row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = A.get(i).get(left);
                A.get(i).set(left, A.get(i).get(right));
                A.get(i).set(right, temp);
                left++;
                right--;
            }
        }
    }
}
