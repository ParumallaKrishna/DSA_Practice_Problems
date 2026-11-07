package com.scaler.module_2.assignments.DSA_Module_6.Graph_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.

The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.



Problem Constraints

2 <= |A| <= 40000



Input Format

First and only argument is vector A



Output Format

Return the length of the longest path



Example Input

Input 1:


A = [-1, 0]
Input 2:


A = [-1, 0, 0]


Example Output

Output 1:

 1
Output 2:

 2
*/
public class Graph_5 {
    public int solve(int[] A) {

        int n = A.length;

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int root = -1;

        for (int i = 0; i < n; i++) {

            if (A[i] == -1) {
                root = i;
            } else {
                adj.get(i).add(A[i]);
                adj.get(A[i]).add(i);
            }
        }

        // First BFS: find farthest node from root
        int[] first = bfs(root, adj, n);

        int farthestNode = first[0];

        // Second BFS: find diameter
        int[] second = bfs(farthestNode, adj, n);

        return second[1];
    }

    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj, int n) {

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        int farthestNode = start;
        int maxDistance = 0;

        int[] distance = new int[n];

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbour : adj.get(node)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    distance[neighbour] = distance[node] + 1;

                    queue.add(neighbour);

                    if (distance[neighbour] > maxDistance) {
                        maxDistance = distance[neighbour];
                        farthestNode = neighbour;
                    }
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }
}
