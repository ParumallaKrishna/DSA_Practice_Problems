package com.scaler.module_2.assignments.DSA_Module_3.Arrays1_1D;

import java.util.List;

/*Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.
Your task is to calculate the total amount of water that can be trapped in these valleys.
Example:
The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below. The total amount of rain water trapped in A is 11.
Rain Water Trapped
Problem Constraints
1 <= |A| <= 105
0 <= A[i] <= 105
Input Format
First and only argument is the Integer Array, A.
Output Format
Return an Integer, denoting the total amount of water that can be trapped in these valleys
Example Input
Input 1: A = [0, 1, 0, 2]
Input 2: A = [1, 2]
Example Output
Output 1: 1
Output 2: 0*/
public class Arrays3 {
    public int trap(final List<Integer> A) {
        int n = A.size();
        if (n <= 2) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left <= right) {
            if (A.get(left) <= A.get(right)) {
                if (A.get(left) >= leftMax) {
                    leftMax = A.get(left);
                } else {
                    water += leftMax - A.get(left);
                }
                left++;
            } else {
                if (A.get(right) >= rightMax) {
                    rightMax = A.get(right);
                } else {
                    water += rightMax - A.get(right);
                }
                right--;
            }
        }
        return water;
    }
}
