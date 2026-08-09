package com.scaler.module_2.assignments.DSA_Module_1.Carry_Farword;
import java.util.*;
/*Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.
Problem Constraints
1 <= |A| <= 2000
Input Format
First and only argument is vector A
Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
Example Input
Input 1: A = [1, 3, 2]
Input 2: A = [2, 6, 1, 6, 9]
Example Output
Output 1: 2
Output 2: 3*/
public class CF2 {
    public int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Find minimum and maximum
        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }
        int minIndex = -1;
        int maxIndex = -1;
        int ans = A.size();
        // Find minimum subarray
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == min) {
                minIndex = i;

                if (maxIndex != -1) {
                    ans = Math.min(ans, minIndex - maxIndex + 1);
                }
            }
            if (A.get(i) == max) {
                maxIndex = i;

                if (minIndex != -1) {
                    ans = Math.min(ans, maxIndex - minIndex + 1);
                }
            }
        }
        return ans;
    }
}
