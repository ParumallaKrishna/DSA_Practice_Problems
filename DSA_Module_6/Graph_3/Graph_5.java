package com.scaler.module_2.assignments.DSA_Module_6.Graph_3;

import java.util.Arrays;

/*Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].

For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.

Return an one-dimensional binary array of size M denoting answer for each edge.

NOTE:

The graph may be disconnected in that case consider mst for each component.
No self-loops and no multiple edges present.
Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].


Problem Constraints

1 <= A, M <= 3*105

1 <= B[i][0], B[i][1] <= A

1 <= B[i][1] <= 103



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].



Output Format

Return an one-dimensional binary array of size M denoting answer for each edge.



Example Input

Input 1:

 A = 3
 B = [ [1, 2, 2]
       [1, 3, 2]
       [2, 3, 3]
     ]


Example Output

Output 1:

 [1, 1, 0]*/
public class Graph_5 {
    int[] parent;
    int[] size;

    public int[] solve(int A, int[][] B) {

        int M = B.length;

        int[] ans = new int[M];

        // Sort edge indices by weight
        Integer[] indices = new Integer[M];

        for (int i = 0; i < M; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i, j) ->
                Integer.compare(B[i][2], B[j][2])
        );

        // Initialize DSU
        parent = new int[A + 1];
        size = new int[A + 1];

        for (int i = 1; i <= A; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int i = 0;

        while (i < M) {

            int j = i;
            int weight = B[indices[i]][2];

            // Find all edges having the same weight
            while (j < M && B[indices[j]][2] == weight) {
                j++;
            }

            // First check all edges in this weight group
            for (int k = i; k < j; k++) {

                int idx = indices[k];

                int u = B[idx][0];
                int v = B[idx][1];

                int rootU = find(u);
                int rootV = find(v);

                if (rootU != rootV) {
                    ans[idx] = 1;
                } else {
                    ans[idx] = 0;
                }
            }

            // Now union all edges in this weight group
            for (int k = i; k < j; k++) {

                int idx = indices[k];

                int u = B[idx][0];
                int v = B[idx][1];

                union(u, v);
            }

            i = j;
        }

        return ans;
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int u, int v) {

        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return;
        }

        if (size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }
}
