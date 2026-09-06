package com.scaler.module_2.assignments.DSA_Module_2.Hashing2;

import java.util.ArrayList;
import java.util.HashMap;

/*Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.
If there is no subarray which sums to zero then return 0.
Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109
Input Format
Single argument which is an integer array A.
Output Format
Return an integer.
Example Input
Input 1: A = [1, -2, 1, 2]
Input 2: A = [3, 2, -1]
Example Output
Output 1: 3
Output 2: 0*/
public class Hashing2_1 {
    public int solve(ArrayList<Integer> A) {
        HashMap<Long, Integer> map = new HashMap<>();
        long prefixSum = 0;
        int maxLength = 0;
        // Store initial prefix sum (0) at index -1 for handling full array cases
        map.put(0L, -1);
        for (int i = 0; i < A.size(); i++) {
            prefixSum += A.get(i);
            // If prefix sum is already in map, update max length
            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                // Store the first occurrence of the prefix sum
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}
