package com.scaler.module_2.assignments.DSA_Module_3.Arrays3;
import java.util.ArrayList;
/*Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
NOTE:
The replacement must be in-place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
Problem Constraints
1 <= N <= 5 * 105
1 <= A[i] <= 109
Input Format
The first and the only argument of input has an array of integers, A.
Output Format
Return an array of integers, representing the next permutation of the given array.
Example Input
Input 1: A = [1, 2, 3]
Input 2: A = [3, 2, 1]
Example Output
Output 1: [1, 3, 2]
Output 2: [1, 2, 3]*/
public class Arrays3_4 {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();
        // Step 1: Find the first decreasing element from right
        int i = n - 2;
        while (i >= 0 && A.get(i) >= A.get(i + 1)) {
            i--;
        }
        // Step 2: If a valid pivot exists
        if (i >= 0) {
            // Find the smallest element greater than A[i]
            // from the right side
            int j = n - 1;
            while (j >= 0 && A.get(j) <= A.get(i)) {
                j--;
            }
            // Swap pivot and successor
            int temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
        }
        // Step 3: Reverse the suffix
        int left = i + 1;
        int right = n - 1;
        while (left < right) {
            int temp = A.get(left);
            A.set(left, A.get(right));
            A.set(right, temp);
            left++;
            right--;
        }
        return A;
    }
}
