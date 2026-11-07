package com.scaler.module_2.assignments.DSA_Module_6.Graph_3;

import java.util.LinkedList;
import java.util.Queue;

/*Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.


The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.

NOTE: A knight cannot go out of the board.



Problem Constraints

1 <= A, B <= 500



Input Format

The first argument of input contains an integer A.
The second argument of input contains an integer B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.



Output Format

If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.



Example Input

Input 1:

 A = 8
 B = 8
 C = 1
 D = 1
 E = 8
 F = 8
Input 2:

 A = 2
 B = 4
 C = 2
 D = 1
 E = 4
 F = 4


Example Output

Output 1:

 6
Output 2:

 -1*/
public class Graph_7 {
    public int knight(int A, int B, int C, int D, int E, int F) {

        // Convert to 0-based indexing
        C--;
        D--;
        E--;
        F--;

        int[][] moves = {
                {2, 1},
                {2, -1},
                {-2, 1},
                {-2, -1},
                {1, 2},
                {1, -2},
                {-1, 2},
                {-1, -2}
        };

        boolean[][] visited = new boolean[A][B];

        // Queue stores {row, col, steps}
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{C, D, 0});
        visited[C][D] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int steps = current[2];

            // Destination reached
            if (row == E && col == F) {
                return steps;
            }

            // Explore all 8 knight movements
            for (int i = 0; i < 8; i++) {

                int newRow = row + moves[i][0];
                int newCol = col + moves[i][1];

                // Check board boundaries
                if (newRow >= 0 && newRow < A &&
                        newCol >= 0 && newCol < B &&
                        !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;

                    queue.offer(new int[]{
                            newRow,
                            newCol,
                            steps + 1
                    });
                }
            }
        }

        return -1;
    }
}
