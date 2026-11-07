package com.scaler.module_2.assignments.DSA_Module_6.Graph_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format

The first argument given is the integer matrix A.



Output Format

Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input

Input 1:


A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]


Input 2:



A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]

Example Output

Output 1:

 4
Output 2:

 -1*/
public class Graph_5 {
    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        ArrayList<int[]> queue = new ArrayList<>();

        int fresh = 0;

        // Find all rotten and fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (A[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (A[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int minutes = 0;
        int index = 0;

        while (index < queue.size()) {

            int size = queue.size() - index;
            boolean rottenThisMinute = false;

            for (int k = 0; k < size; k++) {

                int[] cell = queue.get(index++);

                int x = cell[0];
                int y = cell[1];

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < n &&
                            ny >= 0 && ny < m &&
                            A[nx][ny] == 1) {

                        A[nx][ny] = 2;
                        fresh--;

                        queue.add(new int[]{nx, ny});

                        rottenThisMinute = true;
                    }
                }
            }

            if (rottenThisMinute) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
