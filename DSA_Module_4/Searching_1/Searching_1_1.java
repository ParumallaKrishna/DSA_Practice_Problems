package com.scaler.module_2.assignments.DSA_Module_4.Searching_1;
import java.util.ArrayList;
/*You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.
If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
Your solution should have a time complexity of O(log(N)).
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 105
1 <= B <= 105
Input Format
The first argument is an integer array A of size N.
The second argument is an integer B.
Output Format
Return an integer denoting the index of target value.
Example Input
Input 1: A = [1, 3, 5, 6] B = 5
Input 2: A = [1, 4, 9] B = 3
Example Output
Output 1: 2
Output 2: 1*/
public class Searching_1_1 {
    public int searchInsert(ArrayList<Integer> A, int B) {
        int low = 0;
        int high = A.size() - 1;
        int ans = A.size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) >= B) {
                // mid can be the answer
                ans = mid;
                // Try to find an even smaller index
                high = mid - 1;
            } else {
                // A[mid] is too small
                low = mid + 1;
            }
        }
        return ans;
    }
}
