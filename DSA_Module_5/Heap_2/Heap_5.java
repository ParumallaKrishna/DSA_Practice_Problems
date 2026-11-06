package com.scaler.module_2.assignments.DSA_Module_5.Heap_2;

import java.util.PriorityQueue;

/*Given an integer array A of size N.
You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
Problem Constraints
1 <= N <= 105
0 <= A[i] <= 103
Input Format
First and only argument is an integer array A.
Output Format
Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.
Example Input
Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [10, 2, 13, 4]
Example Output
Output 1: [-1, -1, 6, 24, 60]
Output 2: [-1, -1, 260, 520]
*/
public class Heap_5 {
    public int[] solve(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(A[i]);
            if (pq.size() > 3) {
                pq.poll();
            }
            if (pq.size() < 3) {
                B[i] = -1;
            } else {
                int product = 1;
                for (int num : pq) {
                    product *= num;
                }
                B[i] = product;
            }
        }
        return B;
    }
}
