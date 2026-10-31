package com.scaler.module_2.assignments.DSA_Module_4.Searching_3;
import java.util.ArrayList;
/*Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9
Input Format
The first argument given is the integer array A.
The second argument given is integer B.
Output Format
Return the maximum value of K (sub array length).
Example Input
Input 1: A = [1, 2, 3, 4, 5] B = 10
Input 2: A = [5, 17, 100, 11] B = 130
Example Output
Output 1: 2
Output 2: 3*/
public class Searching_3_4 {
    public int solve(ArrayList<Integer> A, int B) {
        int low = 1;
        int high = A.size();
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(A, B, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public boolean isPossible(ArrayList<Integer> A, int B, int K) {
        long sum = 0;
        // Calculate first window sum
        for (int i = 0; i < K; i++) {
            sum += A.get(i);
        }
        if (sum > B) {
            return false;
        }
        // Sliding window
        for (int i = K; i < A.size(); i++) {
            sum = sum - A.get(i - K) + A.get(i);
            if (sum > B) {
                return false;
            }
        }
        return true;
    }
}
