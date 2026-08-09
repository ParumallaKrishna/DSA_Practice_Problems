package com.scaler.module_2.assignments.DSA_Module_1.Sliding_Window;

import java.util.ArrayList;

/*Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
Problem Constraints
1 <= A <= 1000
Input Format
First and only argument is integer A
Output Format
Return a 2-D matrix which consists of the elements added in spiral order.
Example Input
Input 1: 1
Input 2: 2
Input 3: 5
Example Output
Output 1: [ [1] ]
Output 2: [ [1, 2], [4, 3] ]
Output 3: [ [1,   2,  3,  4, 5],  [16, 17, 18, 19, 6],  [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9] ]*/
public class SW3 {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Create A x A matrix filled with 0
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                row.add(0);
            }
            result.add(row);
        }
        int top = 0;
        int bottom = A - 1;
        int left = 0;
        int right = A - 1;
        int value = 1;
        while (top <= bottom && left <= right) {
            // 1. Move from left to right
            for (int j = left; j <= right; j++) {
                result.get(top).set(j, value);
                value++;
            }
            top++;
            // 2. Move from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.get(i).set(right, value);
                value++;
            }
            right--;
            // 3. Move from right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.get(bottom).set(j, value);
                    value++;
                }
                bottom--;
            }
            // 4. Move from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.get(i).set(left, value);
                    value++;
                }
                left++;
            }
        }
        return result;
    }
}
