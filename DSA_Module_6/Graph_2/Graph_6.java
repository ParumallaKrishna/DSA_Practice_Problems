package com.scaler.module_2.assignments.DSA_Module_6.Graph_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A where 1 is the root of the tree.

You are given Q queries. In each query, you will be given two integers L and X. Find the value of such node which lies at level L mod (MaxDepth + 1) and has value greater than or equal to X.

Answer to the query is the smallest possible value or -1, if all the values at the required level are smaller than X.

NOTE:

Level and Depth of the root is considered as 0.
It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
Please read the input format for more clarification.


Problem Constraints

2 <= A, Q(size of array E and F) <= 105

1 <= B[i], C[i] <= A

1 <= D[i], E[i], F[i] <= 106



Input Format

The first argument is an integer A denoting the number of nodes.

The second and third arguments are the integer arrays B and C where for each i (0 <= i < A-1), B[i] and C[i] are the nodes connected by an edge.

The fourth argument is an integer array D, where D[i] denotes the value of the (i+1)th node

The fifth and sixth arguments are the integer arrays E and F where for each i (0 <= i < Q), E[i] denotes L and F[i] denotes X for ith query.



Output Format

Return an array of integers where the ith element denotes the answer to ith query.



Example Input

Input 1:

 A = 5
 B = [1, 4, 3, 1]
 C = [5, 2, 4, 4]
 D = [7, 38, 27, 37, 1]
 E = [1, 1, 2]
 F = [32, 18, 26]
Input 2:

 A = 3
 B = [1, 2]
 C = [3, 1]
 D = [7, 15, 27]
 E = [1, 10, 1]
 F = [29, 6, 26]


Example Output

Output 1:

 [37, 37, 27]
Output 2:

 [-1, 7, 27]*/
public class Graph_6 {
    public int[] solve(int A, int[] B, int[] C, int[] D,
                       int[] E, int[] F) {

        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < A - 1; i++) {
            int u = B[i];
            int v = C[i];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Group node values according to their levels
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            levels.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[A + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        int[] depth = new int[A + 1];

        int maxDepth = 0;

        // BFS traversal
        while (!queue.isEmpty()) {

            int node = queue.poll();

            int level = depth[node];

            levels.get(level).add(D[node - 1]);

            maxDepth = Math.max(maxDepth, level);

            for (int neighbour : adj.get(node)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    depth[neighbour] = level + 1;

                    queue.add(neighbour);
                }
            }
        }

        // Step 3: Sort values at every level
        for (int i = 0; i <= maxDepth; i++) {
            Collections.sort(levels.get(i));
        }

        // Step 4: Answer queries using binary search
        int Q = E.length;

        int[] result = new int[Q];

        for (int i = 0; i < Q; i++) {

            int requiredLevel = E[i] % (maxDepth + 1);

            int x = F[i];

            ArrayList<Integer> values = levels.get(requiredLevel);

            result[i] = lowerBound(values, x);
        }

        return result;
    }

    // Find smallest value >= X
    private int lowerBound(ArrayList<Integer> values, int X) {

        int low = 0;
        int high = values.size() - 1;

        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (values.get(mid) >= X) {

                answer = values.get(mid);

                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return answer;
    }
}
