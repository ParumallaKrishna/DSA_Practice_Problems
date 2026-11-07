package com.scaler.module_2.assignments.DSA_Module_6.Graph_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*You are given an undirected graph with A nodes, numbered 0 to A - 1. The edges are given as a 2D array B of size |B| x 2, where B[i] = [u, v] means there is an edge between node u and node v.

The graph is called bipartite if you can split its nodes into two groups so that every edge of the graph joins a node of one group to a node of the other. No edge may have both of its endpoints in the same group. Either group is allowed to be empty.

Decide whether the given graph is bipartite.

A few things to keep in mind:
The graph has no self-loops, so B[i][0] is never equal to B[i][1].
No pair of nodes is joined by more than one edge.
The graph need not be connected, so you must account for every component.


Problem Constraints

1 <= A <= 105
1 <= |B| <= min(A * (A - 1) / 2, 2 * 105)
B[i] has length 2 for every i
0 <= B[i][0], B[i][1] < A
B[i][0] != B[i][1]
No unordered pair {u, v} appears more than once in B


Input Format

The first argument is the integer A, the number of nodes.
The second argument is the 2D integer array B of edges.


Output Format

Return the integer 1 if the graph is bipartite, and 0 otherwise.


Example Input

Input 1:
A = 2
B = [
    [0, 1]
]
Input 2:
A = 3
B = [
    [0, 1],
    [0, 2],
    [1, 2]
]


Example Output

Output 1:
1
Output 2:
0
*/
public class Graph_3 {
    public int solve(int A, int[][] B) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Build adjacency list
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {

            int u = B[i][0];
            int v = B[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[A];
        Arrays.fill(color, -1);

        // Check every connected component
        for (int i = 0; i < A; i++) {

            if (color[i] != -1) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(i);
            color[i] = 0;

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int neighbor : adj.get(node)) {

                    // Assign opposite color
                    if (color[neighbor] == -1) {

                        color[neighbor] = 1 - color[node];
                        queue.offer(neighbor);

                    }
                    // Same color on adjacent nodes
                    else if (color[neighbor] == color[node]) {

                        return 0;
                    }
                }
            }
        }

        return 1;
    }
}
