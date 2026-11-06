package com.scaler.module_2.assignments.DSA_Module_5.Heap_1;

import java.util.PriorityQueue;

/*Misha loves eating candies. She has been given N boxes of Candies.
She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?
NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
NOTE 2: The same box will not be chosen again.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 105
1 <= B <= 106
Input Format
The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
The second argument is B, the maximum number of candies Misha like in a box.
Output Format
Return an integer denoting the number of candies Misha will eat.
Example Input
Input 1: A = [3, 2, 3] B = 4
Input 2: A = [1, 2, 1] B = 2
Example Output
Output 1: 2
Output 2: 1*/
public class Heap_3 {
    class Pair {
        int candies;
        int index;
        Pair(int candies, int index) {
            this.candies = candies;
            this.index = index;
        }
    }
    public int solve(int[] A, int B) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.candies, b.candies)
        );
        for (int i = 0; i < A.length; i++) {
            pq.add(new Pair(A[i], i));
        }
        int total = 0;
        boolean[] visited = new boolean[A.length];
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.candies > B) {
                break;
            }
            if (visited[curr.index]) {
                continue;
            }
            visited[curr.index] = true;
            int eaten = curr.candies / 2;
            int remaining = curr.candies - eaten;
            total += eaten;
            // Find the next minimum box
            if (!pq.isEmpty()) {
                Pair next = pq.poll();
                // Transfer remaining candies
                next.candies += remaining;
                pq.add(next);
            }
        }
        return total;
    }
}
