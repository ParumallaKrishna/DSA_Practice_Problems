package com.scaler.module_2.assignments.DSA_Module_6.Graph_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Problem Constraints

1 <= A <= 6*104

1 <= length(B) = length(C) <= 105

1 <= B[i], C[i] <= A



Input Format

The first argument of input contains an integer A, representing the number of courses.

The second argument of input contains an integer array, B.

The third argument of input contains an integer array, C.



Output Format

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Example Input

Input 1:

 A = 3
 B = [1, 2]
 C = [2, 3]
Input 2:

 A = 2
 B = [1, 2]
 C = [2, 1]


Example Output

Output 1:

 1
Output 2:

 0*/
public class Graph_3 {
    public int solve(int A, int[] B, int[] C) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        // Calculate indegree
        int[] indegree = new int[A + 1];

        for (int i = 0; i < B.length; i++) {

            int u = B[i];
            int v = C[i];

            adj.get(u).add(v);
            indegree[v]++;
        }

        // Add courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        // BFS
        while (!queue.isEmpty()) {

            int course = queue.poll();

            count++;

            for (int neighbour : adj.get(course)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        // Check whether all courses can be completed
        return count == A ? 1 : 0;
    }
}
