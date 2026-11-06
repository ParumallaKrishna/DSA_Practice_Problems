package com.scaler.module_2.assignments.DSA_Module_5.Heap_1;

import java.util.PriorityQueue;

/*Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
NOTE: You can perform the modification on the same element multiple times.
Problem Constraints
1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100
Input Format
The first argument given is an integer array A.
The second argument given is an integer B.
Output Format
Return an integer denoting the maximum array sum after B modifications.
Example Input
Input 1: A = [24, -68, -29, -9, 84] B = 4
Input 2: A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61] B = 10
Example Output
Output 1: 196
Output 2: 362*/
public class Heap_4 {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Insert all elements into Min Heap
        for (int num : A) {
            pq.add(num);
        }
        // Flip negative numbers first
        while (B > 0 && !pq.isEmpty() && pq.peek() < 0) {
            int num = pq.poll();
            pq.add(-num);
            B--;
        }
        // Calculate maximum sum
        int sum = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            sum += num;
        }
        // If odd operations remain, flip the smallest positive number
        if (B % 2 == 1) {
            int min = Integer.MAX_VALUE;
            for (int num : A) {
                min = Math.min(min, Math.abs(num));
            }
            sum -= 2 * min;
        }
        return sum;
    }
}
