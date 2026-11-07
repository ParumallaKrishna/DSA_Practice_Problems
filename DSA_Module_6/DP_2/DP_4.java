package com.scaler.module_2.assignments.DSA_Module_6.DP_2;

import java.util.ArrayList;

/*Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.
Problem Constraints

1 <= N, M <= 100



Input Format

The first argument is a 2-D binary array A.



Output Format

Return an integer denoting the area of the largest rectangle containing only ones.



Example Input

Input 1:

 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0]
     ]
Input 2:

 A = [
       [0, 1, 0]
       [1, 1, 1]
     ]


Example Output

Output 1:

 4
Output 2:

 3*/
public class DP_4 {
    public int maximalRectangle(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        ArrayList<Integer> heights = new ArrayList<>();

        // Initialize histogram heights
        for (int j = 0; j < m; j++) {
            heights.add(0);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Update histogram heights
            for (int j = 0; j < m; j++) {

                if (A[i][j] == 1) {
                    heights.set(j, heights.get(j) + 1);
                } else {
                    heights.set(j, 0);
                }
            }

            // Find maximum rectangle in histogram
            ArrayList<Integer> stack = new ArrayList<>();

            for (int j = 0; j <= m; j++) {

                int currentHeight = (j == m) ? 0 : heights.get(j);

                while (!stack.isEmpty() &&
                        heights.get(stack.get(stack.size() - 1)) > currentHeight) {

                    int height = heights.get(stack.remove(stack.size() - 1));

                    int width;

                    if (stack.isEmpty()) {
                        width = j;
                    } else {
                        width = j - stack.get(stack.size() - 1) - 1;
                    }

                    int area = height * width;

                    maxArea = Math.max(maxArea, area);
                }

                stack.add(j);
            }
        }

        return maxArea;
    }
}
