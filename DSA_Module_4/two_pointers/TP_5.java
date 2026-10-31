package com.scaler.module_2.assignments.DSA_Module_4.two_pointers;

import java.util.ArrayList;

/*You are given a sorted array of distinct positive integers A and a positive integer B. Count the number of rectangles with distinct configurations that can be formed by picking a length and a breadth from A such that the area is strictly less than B. Ordered pairs are distinct: a rectangle of size 2 x 3 is different from one of size 3 x 2.
Return the count modulo 109 + 7.
Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 109, all values are distinct and A is sorted in ascending order
1 <= B <= 109
Input Format
The first argument is the sorted integer array A.
The second argument is the integer B.
Output Format
Return a single integer, the count modulo 109 + 7.
Example Input
Input 1: A = [1, 2] B = 5
Input 2: A = [1, 2] B = 1
Example Output
Output 1: 4
Output 2: 0*/
public class TP_5 {
    public int solve(ArrayList<Integer> A, int B) {
        int mod = 1000000007;
        int i = 0;
        int j = A.size() - 1;
        long count = 0;
        while (i <= j) {
            long area = (long) A.get(i) * A.get(j);
            if (area < B) {
                // Count all ordered pairs using elements i to j
                long n = j - i + 1;
                count = (count + (2L * n - 1)) % mod;
                i++;
            } else {
                j--;
            }
        }
        return (int) count;
    }
}
