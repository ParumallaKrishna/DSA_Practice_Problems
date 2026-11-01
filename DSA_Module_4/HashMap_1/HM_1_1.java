package com.scaler.module_2.assignments.DSA_Module_4.HashMap_1;

import java.util.HashSet;
import java.util.List;

/*Given an unsorted integer array A of size N.
Find the length of the longest set of consecutive elements from array A.
Problem Constraints
1 <= N <= 106
-106 <= A[i] <= 106
Input Format
First argument is an integer array A of size N.
Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.
Example Input
Input 1: A = [100, 4, 200, 1, 3, 2]
Input 2: A = [2, 1]
Example Output
Output 1: 4
Output 2: 2*/
public class HM_1_1 {
    public int longestConsecutive(final List<Integer> A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            set.add(A.get(i));
        }
        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}
