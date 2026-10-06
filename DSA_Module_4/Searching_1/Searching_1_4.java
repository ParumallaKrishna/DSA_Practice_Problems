package com.scaler.module_2.assignments.DSA_Module_4.Searching_1;

import java.util.ArrayList;

/*Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
Elements which are appearing twice are adjacent to each other.
NOTE: Users are expected to solve this in O(log(N)) time.
Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
Input Format
The only argument given is the integer array A.
Output Format
Return the single element that appears only once.
Example Input
Input 1: A = [1, 1, 7]
Input 2: A = [2, 3, 3]
Example Output
Output 1: 7
Output 2: 2*/
public class Searching_1_4 {
    public int solve(ArrayList<Integer> A) {
        int low = 0;
        int high = A.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (A.get(mid).equals(A.get(mid + 1))) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return A.get(low);
    }
}
