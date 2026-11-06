package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_2;
/*Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
A sudoku puzzle,
and its solution numbers marked in red.
Problem Constraints
N = 9
Input Format
First argument is an array of array of characters representing the Sudoku puzzle.
Output Format
Modify the given input to the required answer.
Example Input
Input 1:
A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
Example Output
Output 1:
[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
*/
public class BT_2 {
    public void solveSudoku(char[][] A) {
        solve(A);
    }

    private boolean solve(char[][] A) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (A[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(A, row, col, num)) {

                            A[row][col] = num;

                            if (solve(A)) {
                                return true;
                            }

                            // Backtracking
                            A[row][col] = '.';
                        }
                    }

                    // No valid number found
                    return false;
                }
            }
        }

        // All cells are filled
        return true;
    }

    private boolean isValid(char[][] A, int row,
                            int col, char num) {

        // Check row and column
        for (int i = 0; i < 9; i++) {

            if (A[row][i] == num) {
                return false;
            }

            if (A[i][col] == num) {
                return false;
            }
        }

        // Find starting position of 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Check 3x3 box
        for (int i = startRow; i < startRow + 3; i++) {

            for (int j = startCol; j < startCol + 3; j++) {

                if (A[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
