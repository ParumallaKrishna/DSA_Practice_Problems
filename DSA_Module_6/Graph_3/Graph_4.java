package com.scaler.module_2.assignments.DSA_Module_6.Graph_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

D[i]: Shortest distance from the C node to node i.
If node i is not reachable from C then -1.
Note:

There are no self-loops in the graph.
There are no multiple edges between two pairs of vertices.
The graph may or may not be connected.
Nodes are numbered from 0 to A-1.
Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

0 <= C < A



Input Format

The first argument is an integer A, representing the number of nodes in the graph.
The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.


Output Format

Return the integer array D.



Example Input

Input 1:

A = 6
B = [   [0, 4, 9]
        [3, 4, 6]
        [1, 2, 1]
        [2, 5, 1]
        [2, 4, 5]
        [0, 3, 7]
        [0, 1, 1]
        [4, 5, 7]
        [0, 5, 1] ]
C = 4
Input 2:

A = 5
B = [   [0, 3, 4]
        [2, 3, 3]
        [0, 1, 9]
        [3, 4, 10]
        [1, 3, 8]  ]
C = 4


Example Output

Output 1:

D = [7, 6, 5, 6, 0, 6]
Output 2:

D = [14, 18, 13, 10, 0]*/
public class Graph_4 {
    public int[] solve(int A, int[][] B, int C) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        // Build adjacency list
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {

            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Min heap: {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[C] = 0;
        pq.offer(new int[]{0, C});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentDist = current[0];
            int node = current[1];

            // Ignore outdated entries
            if (currentDist > dist[node]) {
                continue;
            }

            for (int[] edge : adj.get(node)) {

                int next = edge[0];
                int weight = edge[1];

                int newDist = currentDist + weight;

                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    pq.offer(new int[]{newDist, next});
                }
            }
        }

        // Convert unreachable nodes to -1
        for (int i = 0; i < A; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
