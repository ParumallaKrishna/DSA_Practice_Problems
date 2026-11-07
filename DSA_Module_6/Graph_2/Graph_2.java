package com.scaler.module_2.assignments.DSA_Module_6.Graph_2;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:

There are no self-loops in the graph.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

2 <= A <= 104

1 <= M <= min(100000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format

Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.



Example Input

Input 1:

 A = 6
 B = [  [6, 3]
        [6, 1]
        [5, 1]
        [5, 2]
        [3, 4]
        [4, 2] ]
Input 2:

 A = 3
 B = [  [1, 2]
        [2, 3]
        [3, 1] ]


Example Output

Output 1:

 [5, 6, 1, 3, 4, 2]
Output 2:

 []*/
public class Graph_2 {
    public int[] solve(int A, int[][] B) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        // Calculate indegree
        int[] indegree = new int[A + 1];

        for (int i = 0; i < B.length; i++) {

            int u = B[i][0];
            int v = B[i][1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        // Min Heap for lexicographically smallest ordering
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        int[] result = new int[A];
        int index = 0;

        while (!pq.isEmpty()) {

            int node = pq.poll();

            result[index++] = node;

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    pq.add(neighbour);
                }
            }
        }

        // Cycle detected
        if (index != A) {
            return new int[0];
        }

        return result;
    }
}
