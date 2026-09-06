package com.scaler.module_2.assignments.DSA_Module_2.LinkedList;
/*Construct a class called Matrix which stores a 2D Array. It should store
The number of rows
The number of columns
The 2D Array itself
Implement the following functionalities inside this class :-
input() -> Reads the input from the user. This method should read the input from the user and populate the entire array. Each row will be in a new line and all the elements in a row will be space-separated.
add(Matrix) -> Returns the sum of two matrices. Assume the matrices provided have the same dimensions.
subtract(Matrix) -> Returns the sum of two matrices. Assume the matrices provided have the same dimensions.
transpose() -> Returns a new matrix containing the transpose of the given original matrix.
print() -> prints the entire matrix row by row. Each row will be in a new line and values in each row should be separated by a single space.
You may define any properties in the class as you see appropriate.*/
public class LL7 {
    int rows;
    int columns;
    int[][] data;
    LL7(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }
    void input(java.util.Scanner sc) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = sc.nextInt();
            }
        }
    }
    LL7 add(LL7 other) {

        LL7 result = new LL7(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    LL7 subtract(LL7 other) {

        LL7 result = new LL7(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = data[i][j] - other.data[i][j];
            }
        }

        return result;
    }

    LL7 transpose() {

        LL7 result = new LL7(columns, rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[j][i] = data[i][j];
            }
        }

        return result;
    }

    void print() {

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }

            System.out.println();
        }
    }
}
