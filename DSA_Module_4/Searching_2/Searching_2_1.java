package com.scaler.module_2.assignments.DSA_Module_4.Searching_2;
/*Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
NOTE:
   The value of A*A can cross the range of Integer.
   Do not use the sqrt function from the standard library.
   Users are expected to solve this in O(log(A)) time.
Problem Constraints
0 <= A <= 109
Input Format
The first and only argument given is the integer A.
Output Format
Return floor(sqrt(A))
Example Input
Input 1: 11
Input 2: 9
Example Output
Output 1: 3
Output 2: 3*/
public class Searching_2_1 {
    public int sqrt(int A) {
        if (A == 0 || A == 1) {
            return A;
        }
        int low = 1;
        int high = A;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == A) {
                return mid;
            } else if (square < A) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
