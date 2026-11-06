package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_1;

import java.util.ArrayList;
import java.util.Arrays;

/*Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
NOTE: No 2 entries in the permutation sequence should be the same.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
Problem Constraints
1 <= |A| <= 9
0 <= A[i] <= 10
Input Format
Only argument is an integer array A of size N.
Output Format
Return a 2-D array denoting all possible unique permutation of the array.
Example Input
Input 1:A = [1, 1, 2]
Input 2:A = [1, 2]
Example Output
Output 1:

[ [1,1,2]
  [1,2,1]
  [2,1,1] ]
Output 2:

[ [1, 2]
  [2, 1] ]*/
public class BT_3 {
    ArrayList<ArrayList<Integer>> result;

    public int[][] permute(int[] A) {

        Arrays.sort(A);

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

        if (current.size() == A.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < A.length; i++) {

            if (visited[i]) {
                continue;
            }

            // Skip duplicate elements
            if (i > 0 && A[i] == A[i - 1]
                    && !visited[i - 1]) {
                continue;
            }

            // Choose
            current.add(A[i]);
            visited[i] = true;

            // Explore
            generate(A, current, visited);

            // Backtrack
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
