package com.scaler.module_2.assignments.DSA_Module_4.Searching_1;

import java.util.ArrayList;

/*Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.
NOTE:
It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 109
Input Format
The only argument given is the integer array A.
Output Format
Return the peak element.
Example Input
Input 1:
A = [1, 2, 3, 4, 5]
Input 2:
A = [5, 17, 100, 11]
Example Output
Output 1: 5
Output 2: 100*/
public class Searching_1_2 {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        // Only one element
        if (n == 1) {
            return A.get(0);
        }
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) < A.get(mid + 1)) {
                // We are on increasing slope
                // Peak is on the right
                low = mid + 1;
            } else {
                // We are on decreasing slope
                // mid can itself be the peak
                high = mid;
            }
        }
        // low == high
        return A.get(low);
    }
}
