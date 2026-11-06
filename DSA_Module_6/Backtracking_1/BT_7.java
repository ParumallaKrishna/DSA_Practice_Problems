package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_1;

import java.util.ArrayList;
import java.util.Arrays;

/*Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Problem Constraints
0 <= N <= 16
Input Format
Only argument is an integer array A of size N.
Output Format
Return a 2-D vector denoting all the possible subsets.
Example Input
Input 1: A = [1, 2, 2]
Input 2: A = [1, 1]
Example Output
Output 1:
 [
    [],
    [1],
    [1, 2],
    [1, 2, 2],
    [2],
    [2, 2]
 ]
Output 2:
 [
    [],
    [1],
    [1, 1]
 ]
*/
public class BT_7 {
    ArrayList<ArrayList<Integer>> result;

    public int[][] subsetsWithDup(int[] A) {
        Arrays.sort(A);

        result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        generate(A, 0, current);

        int[][] ans = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> list = result.get(i);

            ans[i] = new int[list.size()];

            for (int j = 0; j < list.size(); j++) {
                ans[i][j] = list.get(j);
            }
        }

        return ans;
    }

    private void generate(int[] A, int start,
                          ArrayList<Integer> current) {

        // Store the current subset
        result.add(new ArrayList<>(current));

        for (int i = start; i < A.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && A[i] == A[i - 1]) {
                continue;
            }

            current.add(A[i]);

            generate(A, i + 1, current);

            // Backtracking
            current.remove(current.size() - 1);
        }
    }
}
