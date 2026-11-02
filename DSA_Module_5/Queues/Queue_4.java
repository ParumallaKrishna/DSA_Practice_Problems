package com.scaler.module_2.assignments.DSA_Module_5.Queues;
import java.util.LinkedList;
import java.util.Queue;
/*Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
NOTE: All the A integers will fit in 32-bit integers.
Problem Constraints
1 <= A <= 29500
Input Format
The only argument given is integer A.
Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
Example Input
Input 1: A = 3
Input 2: A = 7
Example Output
Output 1: [1, 2, 3]
Output 2: [1, 2, 3, 11, 12, 13, 21]*/
public class Queue_4 {
    public int[] solve(int A) {
        int[] ans = new int[A];
        Queue<Integer> queue = new LinkedList<>();
        // Insert initial numbers
        queue.add(1);
        queue.add(2);
        queue.add(3);
        for (int i = 0; i < A; i++) {
            int num = queue.poll();
            ans[i] = num;
            queue.add(num * 10 + 1);
            queue.add(num * 10 + 2);
            queue.add(num * 10 + 3);
        }
        return ans;
    }
}
