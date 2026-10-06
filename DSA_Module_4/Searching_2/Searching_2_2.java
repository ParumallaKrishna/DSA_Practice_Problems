package com.scaler.module_2.assignments.DSA_Module_4.Searching_2;
import java.util.List;
/*Given a sorted array of integers A of size N and an integer B,
where array A is rotated at some pivot unknown beforehand.
For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
You can assume that no duplicates exist in the array.
NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 109
All elements in A are Distinct.
Input Format
The First argument given is the integer array A.
The Second argument given is the integer B.
Output Format
Return index of B in array A, otherwise return -1
Example Input
Input 1: A = [4, 5, 6, 7, 0, 1, 2, 3] B = 4
Input 2: A : [ 9, 10, 3, 5, 6, 8 ] B : 5
Example Output
Output 1: 0
Output 2: 3*/
public class Searching_2_2 {
    public int search(final List<Integer> A, int B) {
        int low = 0;
        int high = A.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == B) {
                return mid;
            }
            if (A.get(low) <= A.get(mid)) {
                if (A.get(low) <= B && B < A.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A.get(mid) < B && B <= A.get(high)) {
                    low = mid + 1;

                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
