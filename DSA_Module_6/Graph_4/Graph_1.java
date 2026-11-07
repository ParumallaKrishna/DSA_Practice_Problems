package com.scaler.module_2.assignments.DSA_Module_6.Graph_4;
/*Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).

If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.

Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.

If there is no possible path from vertex i to vertex j , B[i][j] = -1

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

1 <= N <= 200
-1 <= A[i][j] <= 1000000


Input Format

The first and only argument given is the integer matrix A.


Output Format

Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j
If there is no possible path from vertex i to vertex j, B[i][j] = -1.


Example Input

A = [ [0 , 50 , 39]
          [-1 , 0 , 1]
          [-1 , 10 , 0] ]


Example Output

[ [0 , 49 , 39 ]
   [-1 , 0 , -1 ]
   [-1 , 10 , 0 ] ]
*/
public class Graph_1 {
    public int[][] solve(int[][] A) {

        int n = A.length;
        int INF = Integer.MAX_VALUE;

        int[][] dist = new int[n][n];

        // Copy input and replace -1 with INF
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (A[i][j] == -1) {
                    dist[i][j] = INF;
                } else {
                    dist[i][j] = A[i][j];
                }
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (dist[i][k] != INF &&
                            dist[k][j] != INF) {

                        dist[i][j] = Math.min(
                                dist[i][j],
                                dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }

        // Convert INF back to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (dist[i][j] == INF) {
                    dist[i][j] = -1;
                }
            }
        }

        return dist;
    }
}
