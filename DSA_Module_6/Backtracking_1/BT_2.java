package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_1;

import java.util.ArrayList;

/*Given an integer array A of size N denoting collection of numbers , return all possible permutations.
NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
Problem Constraints
1 <= N <= 9
Input Format
Only argument is an integer array A of size N.
Output Format
Return a 2-D array denoting all possible permutation of the array.
Example Input
A = [1, 2, 3]
Example Output
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3]
  [2, 3, 1]
  [3, 1, 2]
  [3, 2, 1] ]*/
public class BT_2 {
    ArrayList<ArrayList<Integer>> result;

    public int[][] permute(int[] A) {

        result = new ArrayList<>();

        ArrayList<Integer> current = new ArrayList<>();

        boolean[] visited = new boolean[A.length];

        generate(A, current, visited);

        int[][] answer = new int[result.size()][A.length];

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < A.length; j++) {
                answer[i][j] = result.get(i).get(j);
            }
        }

        return answer;
    }

    private void generate(int[] A,
                          ArrayList<Integer> current,
                          boolean[] visited) {

        // If permutation contains all elements
        if (current.size() == A.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < A.length; i++) {

            if (!visited[i]) {

                // Choose element
                current.add(A[i]);
                visited[i] = true;

                // Explore next position
                generate(A, current, visited);

                // Backtrack
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}
