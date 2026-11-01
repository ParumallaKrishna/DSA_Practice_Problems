package com.scaler.module_2.assignments.DSA_Module_5.Stack_2;
import java.util.ArrayList;
import java.util.Stack;
/*Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
Find the largest rectangle containing only 1's and return its area.
Note: Rows are numbered from top to bottom and columns are numbered from left to right.
Input Format
The only argument given is the integer matrix A.
Output Format
Return the area of the largest rectangle containing only 1's.
Constraints
1 <= N, M <= 1000
0 <= A[i] <= 1
For Example
Input 1:
    A = [   [0, 0, 1]
            [0, 1, 1]
            [1, 1, 1]   ]
Output 1:    4
Input 2:
    A = [   [0, 1, 0, 1]
            [1, 0, 1, 0]    ]
Output 2:    1*/
public class Stack_5 {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[] heights = new int[m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            // Build histogram for current row
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            // Find largest rectangle in histogram
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= m; j++) {
                int currHeight = (j == m) ? 0 : heights[j];
                while (!stack.isEmpty() &&
                        heights[stack.peek()] >= currHeight) {
                    int height = heights[stack.pop()];
                    int width;
                    if (stack.isEmpty()) {
                        width = j;
                    } else {
                        width = j - stack.peek() - 1;
                    }
                    int area = height * width;
                    maxArea = Math.max(maxArea, area);
                }
                stack.push(j);
            }
        }
        return maxArea;
    }
}
