package com.scaler.module_2.assignments.DSA_Module_5.Queues;
import java.util.Deque;
import java.util.LinkedList;
/*Given an array A of both positive and negative integers.
Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
Problem Constraints
1 <= size of array A <= 105
-109 <= A[i] <= 109
1 <= B <= size of array
Input Format
The first argument denotes the integer array A.
The second argument denotes the value B
Output Format
Return an integer that denotes the required value.
Example Input
Input 1: A = [2, 5, -1, 7, -3, -1, -2] B = 4
Input 2:
 A = [2, -1, 3]
 B = 2
Example Output
Output 1: 18
Output 2: 3*/
public class Queue_5 {
    public int solve(int[] A, int B) {
        int n = A.length;
        long mod = 1000000007L;
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            // Remove indices outside the window
            while (!maxDeque.isEmpty() &&
                    maxDeque.peekFirst() <= i - B) {
                maxDeque.pollFirst();
            }
            while (!minDeque.isEmpty() &&
                    minDeque.peekFirst() <= i - B) {
                minDeque.pollFirst();
            }
            // Maintain decreasing order for maximum
            while (!maxDeque.isEmpty() &&
                    A[maxDeque.peekLast()] <= A[i]) {
                maxDeque.pollLast();
            }
            // Maintain increasing order for minimum
            while (!minDeque.isEmpty() &&
                    A[minDeque.peekLast()] >= A[i]) {
                minDeque.pollLast();
            }
            // Add current index
            maxDeque.offerLast(i);
            minDeque.offerLast(i);
            // Calculate sum for every complete window
            if (i >= B - 1) {
                long max = A[maxDeque.peekFirst()];
                long min = A[minDeque.peekFirst()];

                ans = (ans + max + min) % mod;
            }
        }
        return (int) ((ans + mod) % mod);
    }
}
