package com.scaler.module_2.assignments.DSA_Module_4.HashMap_1;
import java.util.HashMap;
import java.util.List;
/*Given an integer array A, find the length of the longest subarray of A whose elements sum to zero. A subarray is a contiguous block of elements of A.
If no subarray of A sums to zero, return 0.
Problem Constraints
1 <= |A| <= 3 * 105
-109 <= A[i] <= 109
Input Format
The only argument is the integer array A.
Output Format
Return an integer, the length of the longest subarray of A that sums to zero, or 0 if there is no such subarray.
Example Input
Input 1: A = [1, -2, 1, 2]
Input 2: A = [3, 2, -1]
Example Output
Output 1: 3
Output 2: 0*/
public class HM_1_3 {
    public int solve(List<Integer> A) {
        HashMap<Long, Integer> map = new HashMap<>();
        long prefixSum = 0;
        int maxLength = 0;
        for (int i = 0; i < A.size(); i++) {
            prefixSum += A.get(i);
            // Prefix sum is zero
            if (prefixSum == 0) {
                maxLength = i + 1;
            }
            // Same prefix sum found again
            if (map.containsKey(prefixSum)) {
                int previousIndex = map.get(prefixSum);
                int length = i - previousIndex;
                maxLength = Math.max(maxLength, length);
            }
            else {
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}
