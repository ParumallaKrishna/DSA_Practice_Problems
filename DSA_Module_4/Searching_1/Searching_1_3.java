package com.scaler.module_2.assignments.DSA_Module_4.Searching_1;
import java.util.*;
/*Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
Return an array of size 2, such that
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].
Note : Note: The time complexity of your algorithm must be O(log n)..
Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109
Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].
Example Input
Input 1: A = [5, 7, 7, 8, 8, 10] B = 8
Input 2: A = [5, 17, 100, 111] B = 3
Example Output
Output 1: [3, 4]
Output 2: [-1, -1]*/
public class Searching_1_3 {
    public ArrayList<Integer> searchRange(List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = findLeft(A, B);
        int right = findRight(A, B);
        result.add(left);
        result.add(right);
        return result;
    }
    // Find first occurrence
    private int findLeft(List<Integer> A, int B) {
        int low = 0;
        int high = A.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == B) {
                ans = mid;
                // Continue searching on the left
                high = mid - 1;
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    // Find last occurrence
    private int findRight(List<Integer> A, int B) {
        int low = 0;
        int high = A.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == B) {
                ans = mid;
                // Continue searching on the right
                low = mid + 1;
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
