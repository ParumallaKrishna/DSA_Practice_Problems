package com.scaler.module_2.assignments.DSA_Module_6.Graph_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format

Return 1 if cycle is present else return 0.



Example Input

Input 1:

 A = 5
 B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]


Example Output

Output 1:

 1
Output 2:

 0*/
public class Graph_2 {
    public int solve(int A, int[][] B) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        // Store indegree of each node
        int[] indegree = new int[A + 1];

        // Build directed graph
        for (int i = 0; i < B.length; i++) {

            int u = B[i][0];
            int v = B[i][1];

            adj.get(u).add(v);

            indegree[v]++;
        }

        // Add nodes having indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= A; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int processed = 0;

        // Kahn's BFS
        while (!queue.isEmpty()) {

            int node = queue.poll();

            processed++;

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        // If all nodes are processed, no cycle exists
        return processed == A ? 0 : 1;
    }
}
