package com.scaler.module_2.assignments.DSA_Module_6.Graph_1;

import java.util.LinkedList;
import java.util.Queue;

/*There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.



Problem Constraints

0 <= x , y, R <= 100

1 <= N <= 1000

Center of each circle would lie within the grid



Input Format

1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle



Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).



Example Input

Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]
Input 2:

 x = 3
 y = 3
 N = 1
 R = 1
 A = [0]
 B = [3]


Example Output

Output 1:

 NO
Output 2:

 YES*/
public class Graph_4 {
    public String solve(int A, int B, int C, int D, int[] E, int[] F) {

        boolean[][] blocked = new boolean[A + 1][B + 1];
        boolean[][] visited = new boolean[A + 1][B + 1];

        // Mark all cells covered by circles
        for (int k = 0; k < C; k++) {

            for (int i = 0; i <= A; i++) {
                for (int j = 0; j <= B; j++) {

                    int dx = i - E[k];
                    int dy = j - F[k];

                    if (dx * dx + dy * dy <= D * D) {
                        blocked[i][j] = true;
                    }
                }
            }
        }

        // Starting or destination cell is blocked
        if (blocked[0][0] || blocked[A][B]) {
            return "NO";
        }

        // 8 possible directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            // Destination reached
            if (x == A && y == B) {
                return "YES";
            }

            // Explore 8 neighbours
            for (int d = 0; d < 8; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx <= A &&
                        ny >= 0 && ny <= B &&
                        !blocked[nx][ny] &&
                        !visited[nx][ny]) {

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return "NO";
    }
}
