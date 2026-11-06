package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_2;

import java.util.ArrayList;
import java.util.Arrays;

/*The N-queens puzzle is the problem of placing N queens on an N×N chessboard such that no two queens attack each other.
Given an integer A denoting the value of N, return all distinct solutions to the N-queens puzzle.
Each solution contains a distinct board configuration of the N-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
Problem Constraints
1 <= A <= 10
Input Format
First argument is an integer A denoting the size of chessboard
Output Format
Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
Example Input
Input 1: A = 4
Input 2: A = 1
Example Output
Output 1:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:
[
 [Q]
]*/
public class BT_1 {
    ArrayList<String[]> result;

    public String[][] solveNQueens(int A) {
        result = new ArrayList<>();

        char[][] board = new char[A][A];

        for (int i = 0; i < A; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] column = new boolean[A];
        boolean[] diagonal1 = new boolean[2 * A];
        boolean[] diagonal2 = new boolean[2 * A];

        generate(0, A, board, column, diagonal1, diagonal2);

        String[][] ans = new String[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private void generate(int row, int n, char[][] board,
                          boolean[] column,
                          boolean[] diagonal1,
                          boolean[] diagonal2) {

        // All queens are placed
        if (row == n) {
            String[] solution = new String[n];

            for (int i = 0; i < n; i++) {
                solution[i] = new String(board[i]);
            }

            result.add(solution);
            return;
        }

        // Try columns from right to left
        for (int col = n - 1; col >= 0; col--) {

            int d1 = row - col + n;
            int d2 = row + col;

            if (column[col] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';

            column[col] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            generate(row + 1, n, board,
                    column, diagonal1, diagonal2);

            // Backtracking
            board[row][col] = '.';

            column[col] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}
