package com.scaler.module_2.assignments.DSA_Module_3.BitManipulation;

import java.util.ArrayList;

/*Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.
Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109
Input Format
The first argument is an array of integers of size N.
Output Format
Return an array of two integers that appear only once.
Example Input
Input 1: A = [1, 2, 3, 1, 2, 4]
Input 2: A = [1, 2]
Example Output
Output 1: [3, 4]
Output 2: [1, 2]*/
public class BM1 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int xor = 0;
        // XOR all elements
        for (int i = 0; i < A.size(); i++) {
            xor = xor ^ A.get(i);
        }
        // Find the rightmost set bit
        int bit = xor & (-xor);
        int num1 = 0;
        int num2 = 0;
        // Divide numbers into two groups
        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) & bit) != 0) {
                num1 = num1 ^ A.get(i);
            } else {
                num2 = num2 ^ A.get(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (num1 < num2) {
            result.add(num1);
            result.add(num2);
        } else {
            result.add(num2);
            result.add(num1);
        }
        return result;
    }
}
