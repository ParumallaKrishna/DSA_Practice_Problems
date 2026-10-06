package com.scaler.module_2.assignments.DSA_Module_4.Searching_1;
import java.util.*;
/*You are given a 2D matrix C of size A x B.
Build a new 1D array X of size A by picking exactly one element from each row of C. The element picked from row i becomes X[i] (with rows and arrays 0-indexed).
The cost of the built array X is defined as the minimum absolute difference between any two adjacent elements:
cost(X) = min |X[i] - X[i + 1]| over all i in [0, A - 2].
Determine the minimum possible cost over all valid choices of X.
Problem Constraints
2 <= A <= 1000
2 <= B <= 1000
Size of C = A x B
1 <= C[i][j] <= 106
Input Format
The first argument is an integer A, the number of rows.
The second argument is an integer B, the number of columns.
The third argument is a 2D integer array C of size A x B.
Output Format
Return a single integer representing the minimum possible cost of the built array.
Example Input
Input 1: A = 2 B = 2
C = [[8, 4],
     [6, 8]]
Input 2: A = 3 B = 2
C = [[7, 3],
     [2, 1],
     [4, 9]]
Example Output
Output 1: 0
Output 2: 1*/
public class Searching_1_6 {
    public int solve(int A, int B, ArrayList<ArrayList<Integer>> C) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < A - 1; i++) {
            ArrayList<Integer> row1 = C.get(i);
            ArrayList<Integer> row2 = C.get(i + 1);
            Collections.sort(row1);
            Collections.sort(row2);
            int p1 = 0;
            int p2 = 0;
            while (p1 < B && p2 < B) {
                int value1 = row1.get(p1);
                int value2 = row2.get(p2);
                int difference = Math.abs(value1 - value2);
                answer = Math.min(answer, difference);
                if (answer == 0) {
                    return 0;
                }
                if (value1 < value2) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }
        return answer;
    }
}
