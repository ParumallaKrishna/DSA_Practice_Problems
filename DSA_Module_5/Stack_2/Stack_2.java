package com.scaler.module_2.assignments.DSA_Module_5.Stack_2;

import java.util.ArrayList;
import java.util.Stack;

/*Given an array of integers A.
A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.
Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10000
Input Format
The only argument given is the integer array A.
Output Format
Return the area of the largest rectangle in the histogram.
Example Input
Input 1: A = [2, 1, 5, 6, 2, 3]
Input 2: A = [2]
Example Output
Output 1: 10
Output 2: 2*/
public class Stack_2 {
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = A.size();
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) >= currHeight) {
                int height = A.get(stack.pop());
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
