package com.scaler.module_2.assignments.DSA_Module_6.Graph_4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/*You are given an undirected unweighted graph consisting of A vertices and M edges given in a form of 2D Matrix B of size M x 2 where (B[i][0], B][i][1]) denotes two nodes connected by an edge.

You have to write a number on each vertex of the graph. Each number should be 1, 2 or 3. The graph becomes Poisonous if for each edge the sum of numbers on vertices connected by this edge is odd.

Calculate the number of possible ways to write numbers 1, 2 or 3 on vertices so the graph becomes poisonous. Since this number may be large, return it modulo 998244353.

NOTE:

Note that you have to write exactly one number on each vertex.
The graph does not have any self-loops or multiple edges.
Nodes are labelled from 1 to A.


Problem Constraints

1 <= A <= 3*105

0 <= M <= 3*105

1 <= B[i][0], B[i][1] <= A

B[i][0] != B[i][1]



Input Format

First argument is an integer A denoting the number of nodes.

Second argument is an 2D Matrix B of size M x 2 denoting the M edges.



Output Format

Return one integer denoting the number of possible ways to write numbers 1, 2 or 3 on the vertices of given graph so it becomes Poisonous . Since answer may be large, print it modulo 998244353.



Example Input

Input 1:

 A = 2
 B = [  [1, 2]
     ]
Input 2:

 A = 4
 B = [  [1, 2]
        [1, 3]
        [1, 4]
        [2, 3]
        [2, 4]
        [3, 4]
    ]


Example Output

Output 1:

 4
Output 2:

 0*/
public class Graph_7 {
    static final long MOD = 998244353;

    public int solve(int A, int[][] B) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {

            int u = B[i][0] - 1;
            int v = B[i][1] - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[A];
        Arrays.fill(color, -1);

        long answer = 1;

        // Check every connected component
        for (int i = 0; i < A; i++) {

            if (color[i] != -1) {
                continue;
            }

            ArrayList<Integer> queue = new ArrayList<>();

            queue.add(i);
            color[i] = 0;

            int count0 = 0;
            int count1 = 0;

            int index = 0;

            // BFS coloring
            while (index < queue.size()) {

                int node = queue.get(index++);

                if (color[node] == 0) {
                    count0++;
                } else {
                    count1++;
                }

                for (int neighbor : adj.get(node)) {

                    if (color[neighbor] == -1) {

                        color[neighbor] = 1 - color[node];
                        queue.add(neighbor);

                    } else if (color[neighbor] == color[node]) {

                        // Graph is not bipartite
                        return 0;
                    }
                }
            }

            // Calculate 2^count0 + 2^count1
            long ways0 = power(2, count0);
            long ways1 = power(2, count1);

            long componentWays = (ways0 + ways1) % MOD;

            // Multiply answers of all components
            answer = (answer * componentWays) % MOD;
        }

        return (int) answer;
    }

    // Binary exponentiation
    private long power(long base, int exponent) {

        long result = 1;

        while (exponent > 0) {

            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;

            exponent >>= 1;
        }

        return result;
    }
}
