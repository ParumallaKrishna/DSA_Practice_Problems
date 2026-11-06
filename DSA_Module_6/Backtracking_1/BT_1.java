package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_1;

import java.util.ArrayList;
import java.util.Arrays;

/*Given a set of distinct integers A, return all possible subsets.
NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The initial list is not necessarily sorted.
Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX
Input Format
First and only argument of input contains a single integer array A.
Output Format
Return a vector of vectors denoting the answer.
Example Input
Input 1:A = [1]
Input 2:A = [1, 2, 3]
Example Output
Output 1:
[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]*/
public class BT_1 {
    ArrayList<ArrayList<Integer>> result;

    public int[][] subsets(int[] A) {

        Arrays.sort(A);

        result = new ArrayList<>();

        ArrayList<Integer> current = new ArrayList<>();

        generate(A, 0, current);

        int[][] answer = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {

            ArrayList<Integer> list = result.get(i);

            answer[i] = new int[list.size()];

            for (int j = 0; j < list.size(); j++) {
                answer[i][j] = list.get(j);
            }
        }

        return answer;
    }

    private void generate(int[] A, int index,
                          ArrayList<Integer> current) {

        // Add current subset
        result.add(new ArrayList<>(current));

        for (int i = index; i < A.length; i++) {

            current.add(A[i]);

            generate(A, i + 1, current);

            // Backtracking
            current.remove(current.size() - 1);
        }
    }
}
