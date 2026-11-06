package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_1;
/*Given a matrix of integers A of size N x M . There are 4 types of squares in it:
1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
Note: Rows are numbered from top to bottom and columns are numbered from left to right.
Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2
Input Format
The first argument given is the integer matrix A.
Output Format
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
Example Input
Input 1:
A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:
A = [   [0, 1]
        [2, 0]    ]
Example Output
Output 1: 2
Output 2: 0*/
public class BT_4 {
    int rows, cols;
    boolean[][] visited;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solve(int[][] A) {

        rows = A.length;
        cols = A[0].length;

        visited = new boolean[rows][cols];

        int startRow = 0;
        int startCol = 0;
        int total = 0;

        // Find starting position and count non-obstacle cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (A[i][j] != -1) {
                    total++;
                }

                if (A[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        return dfs(A, startRow, startCol, total);
    }

    private int dfs(int[][] A, int r, int c, int remaining) {

        // Reached ending cell
        if (A[r][c] == 2) {
            return remaining == 1 ? 1 : 0;
        }

        // Mark current cell as visited
        visited[r][c] = true;

        int paths = 0;

        // Explore four directions
        for (int d = 0; d < 4; d++) {

            int nr = r + dr[d];
            int nc = c + dc[d];

            // Check boundaries
            if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols) {
                continue;
            }

            // Skip obstacles and visited cells
            if (A[nr][nc] == -1 || visited[nr][nc]) {
                continue;
            }

            paths += dfs(A, nr, nc, remaining - 1);
        }

        // Backtrack
        visited[r][c] = false;

        return paths;
    }
}
