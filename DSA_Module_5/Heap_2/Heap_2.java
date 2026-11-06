package com.scaler.module_2.assignments.DSA_Module_5.Heap_2;

import java.util.PriorityQueue;

/*N people having different priorities are standing in a queue.
The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
Your task is to sort the queue in the increasing order of priorities.
NOTE:
No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).
Problem Constraints
1 <= N <= 100000
0 <= B <= N
Input Format
The first argument is an integer array A representing the priorities and initial order of N persons.
The second argument is an integer B.
Output Format
Return an integer array representing the sorted queue.
Example Input
Input 1: A = [1, 40, 2, 3] B = 2
Input 2: A = [2, 1, 17, 10, 21, 95] B = 1
Example Output
Output 1: [1, 2, 3, 40]
Output 2: [1, 2, 10, 17, 21, 95]*/
public class Heap_2 {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        int[] result = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Add first B + 1 elements
        for (int i = 0; i < Math.min(n, B + 1); i++) {
            pq.add(A[i]);
        }
        int index = 0;
        // Extract minimum and insert next element
        for (int i = B + 1; i < n; i++) {
            result[index] = pq.poll();
            index++;
            pq.add(A[i]);
        }
        // Extract remaining elements
        while (!pq.isEmpty()) {
            result[index] = pq.poll();
            index++;
        }
        return result;
    }
}
