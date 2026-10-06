package com.scaler.module_2.assignments.DSA_Module_4.Searching_2;
import java.util.ArrayList;
/*Given a matrix of integers A of size N x M in which each row is sorted.
Find and return the overall median of matrix A.
NOTE: No extra memory is allowed.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
Problem Constraints
1 <= N, M <= 10^5
1 <= N*M <= 10^6
1 <= A[i] <= 10^9
N*M is odd
Input Format
The first and only argument given is the integer matrix A.
Output Format
Return the overall median of matrix A.
Example Input
Input 1:
A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ]
Input 2: A = [   [5, 17, 100]    ]
Example Output
Output 1: 5
Output 2: 17
*/
public class Searching_2_5 {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            low = Math.min(low, A.get(i).get(0));
            high = Math.max(high, A.get(i).get(M - 1));
        }
        int total = N * M;
        int required = (total / 2) + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < N; i++) {
                count += upperBound(A.get(i), mid);
            }
            if (count >= required) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private int upperBound(ArrayList<Integer> row, int target) {
        int low = 0;
        int high = row.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
