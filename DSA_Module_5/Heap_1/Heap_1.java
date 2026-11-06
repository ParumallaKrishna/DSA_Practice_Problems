package com.scaler.module_2.assignments.DSA_Module_5.Heap_1;

import java.util.PriorityQueue;

/*You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.
Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000
Input Format
The only argument given is the integer array A.
Output Format
Return an integer denoting the minimum cost to connect these ropes into one rope.
Example Input
Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [5, 17, 100, 11]
Example Output
Output 1: 33
Output 2: 182*/
public class Heap_1 {
    public int solve(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Insert all rope lengths
        for (int num : A) {
            pq.add(num);
        }
        int totalCost = 0;
        // Connect ropes until only one remains
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            totalCost += cost;
            // Add combined rope back
            pq.add(cost);
        }
        return totalCost;
    }
}
