package com.scaler.module_2.assignments.DSA_Module_6.Graph_3;

import java.util.Arrays;

/*Flipkart has ‘A’ local distribution centers located across a large metropolitan city. Each distribution center needs to be interconnected through roads to facilitate efficient movement of goods. The cost of constructing a road between any two distribution centers is represented by the weight of the edge connecting them.

Given a graph with ‘A’ nodes representing the distribution centers and C weighted edges representing the possible roads between them, your task is to find the minimum total cost of constructing roads such that every distribution center can be reached from the first distribution center.

Cost Calculation:
The cost of constructing the roads is the sum of the weights of the edges selected for the construction.

NOTE: Return the answer modulo 10^9+7 as the answer can be large.



Problem Constraints

1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 109



Input Format

First argument is an integer A.
Second argument is a 2-D integer array B of size C×3 denoting edges. B[i][0]and B[i][1]are the distribution centers connected by the ith edge with construction cost B[i][2].



Output Format

Return an integer denoting the minimum construction cost.



Example Input

Input 1:

A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]
Input 2:

A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]


Example Output

Output 1:

9
Output 2:

37*/
public class Graph_1 {
    int[] parent;
    int[] size;

    static final int MOD = 1000000007;

    public int solve(int A, int[][] B) {

        // Initialize DSU
        parent = new int[A + 1];
        size = new int[A + 1];

        for (int i = 1; i <= A; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Sort edges by increasing weight
        Arrays.sort(B, (a, b) -> Integer.compare(a[2], b[2]));

        long totalCost = 0;
        int edgesSelected = 0;

        // Kruskal's algorithm
        for (int i = 0; i < B.length; i++) {

            int u = B[i][0];
            int v = B[i][1];
            int weight = B[i][2];

            int rootU = find(u);
            int rootV = find(v);

            // Select edge only if it connects different components
            if (rootU != rootV) {

                union(rootU, rootV);

                totalCost += weight;
                edgesSelected++;

                // MST contains exactly A - 1 edges
                if (edgesSelected == A - 1) {
                    break;
                }
            }
        }

        return (int) (totalCost % MOD);
    }

    // Find with path compression
    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Union by size
    private void union(int rootU, int rootV) {

        if (size[rootU] < size[rootV]) {
            int temp = rootU;
            rootU = rootV;
            rootV = temp;
        }

        parent[rootV] = rootU;
        size[rootU] += size[rootV];
    }
}
