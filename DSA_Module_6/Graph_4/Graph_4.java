package com.scaler.module_2.assignments.DSA_Module_6.Graph_4;

import java.util.ArrayList;
import java.util.Arrays;

/*A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.

Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.

Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.

NOTE: All cities can be visited from any city.



Problem Constraints

1 <= A <= 105

1 <= B[i][0], B[i][1] <= N



Input Format

First argument is an integer A denoting the number of cities, N.

Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .



Output Format

Return an integer denoting the maximum number of roads king can construct.



Example Input

Input 1:

 A = 3
 B = [
       [1, 2]
       [1, 3]
     ]
Input 2:

 A = 5
 B = [
       [1, 3]
       [1, 4]
       [3, 2]
       [3, 5]
     ]


Example Output

Output 1:

 0
Output 2:

 2*/
public class Graph_4 {
    public int solve(int A, int[][] B) {

        int MOD = 1000000007;

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

        // BFS coloring
        int[] color = new int[A];
        Arrays.fill(color, -1);

        int count0 = 0;
        int count1 = 0;

        ArrayList<Integer> queue = new ArrayList<>();

        queue.add(0);
        color[0] = 0;

        int index = 0;

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
                }
            }
        }

        // Maximum possible roads between two groups
        long totalRoads = (long) count0 * count1;

        // Subtract existing roads
        long newRoads = totalRoads - (A - 1);

        return (int) (newRoads % MOD);
    }
}
