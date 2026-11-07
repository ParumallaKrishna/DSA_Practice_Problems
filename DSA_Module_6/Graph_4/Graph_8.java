package com.scaler.module_2.assignments.DSA_Module_6.Graph_4;

import java.util.ArrayList;

/*Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is atleast one 1 is present in the matrix.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 1



Input Format

The first argument given is the integer matrix A.



Output Format

Return the matrix B.



Example Input

Input 1:

 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1]
       [0, 1, 1, 0]
     ]
Input 2:

 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]
     ]


Example Output

Output 1:

 [
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]
 ]
Output 2:

 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4]
 ]*/
public class Graph_8 {
    public int[][] solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        int[][] dist = new int[n][m];

        ArrayList<int[]> queue = new ArrayList<>();

        // Initialize distances and add all 1s to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (A[i][j] == 1) {
                    dist[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        // Four possible directions
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int index = 0;

        // Multi-source BFS
        while (index < queue.size()) {

            int[] cell = queue.get(index++);

            int x = cell[0];
            int y = cell[1];

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n &&
                        ny >= 0 && ny < m &&
                        dist[nx][ny] == -1) {

                    dist[nx][ny] = dist[x][y] + 1;

                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return dist;
    }
}
