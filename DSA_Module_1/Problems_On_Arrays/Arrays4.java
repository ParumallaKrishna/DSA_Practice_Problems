package com.scaler.module_2.assignments.DSA_Module_1.Problems_On_Arrays;

import java.util.List;

/*Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.
Problem Constraints
1 <= N <= 5*105
1 <= num[i] <= 109
Input Format
Only argument is an integer array.
Output Format
Return an integer.
Example Input
Input 1: [2, 1, 2]
Input 2: [1, 1, 1]
Example Output
Input 1: 2
Input 2: 1 */
public class Arrays4 {
    public int majorityElement(final List<Integer> A) {
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (count == 0) {
                candidate = A.get(i);
                count = 1;
            }
            else if (A.get(i).equals(candidate)) {
                count++;
            }
            else {
                count--;
            }
        }
        return candidate;
    }
}
