package com.scaler.module_2.assignments.DSA_Module_6.Graph_3;
/*There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints

1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103



Input Format

The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format

Return an integer representing the minimal cost required.



Example Input

Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]
Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]


Example Output

Output 1:

 6
Output 2:

 6*/
public class Graph_2 {
    public int solve(int A, int[][] B) {

        // Sort bridges by cost
        java.util.Arrays.sort(B, (a, b) ->
                Integer.compare(a[2], b[2])
        );

        int[] parent = new int[A + 1];
        int[] size = new int[A + 1];

        // Initialize DSU
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        long totalCost = 0;
        int selected = 0;

        for (int i = 0; i < B.length; i++) {

            int u = B[i][0];
            int v = B[i][1];
            int cost = B[i][2];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // Select bridge only if it connects different components
            if (rootU != rootV) {

                totalCost += cost;

                union(parent, size, rootU, rootV);

                selected++;

                if (selected == A - 1) {
                    break;
                }
            }
        }

        return (int) totalCost;
    }

    private int find(int[] parent, int x) {

        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    private void union(int[] parent, int[] size,
                       int rootU, int rootV) {

        if (size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }
}
