package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_2;

import java.util.ArrayList;
import java.util.Arrays;

/*Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.
Each number in A may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Warning:
DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.
Problem Constraints
1 <= N <= 20
Input Format
First argument is an integer array A denoting the collection of candidate numbers.
Second argument is an integer which represents the target number.
Output Format
Return all unique combinations in A where the candidate numbers sums to B.
Example Input
Input 1: A = [10, 1, 2, 7, 6, 1, 5] B = 8
Input 2: A = [2, 1, 3] B = 3
Example Output
Output 1:
 [
  [1, 1, 6 ],
  [1, 2, 5 ],
  [1, 7 ],
  [2, 6 ]
 ]
Output 2:
 [
  [1, 2 ],
  [3 ]
 ]*/
public class BT_3 {
    ArrayList<ArrayList<Integer>> result;

    public int[][] combinationSum(int[] A, int B) {

        Arrays.sort(A);

        result = new ArrayList<>();

        ArrayList<Integer> current = new ArrayList<>();

        generate(A, B, 0, current);

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

    private void generate(int[] A, int target, int start,
                          ArrayList<Integer> current) {

        // Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < A.length; i++) {

            // Skip duplicate elements at the same level
            if (i > start && A[i] == A[i - 1]) {
                continue;
            }

            // Since array is sorted, no need to continue
            if (A[i] > target) {
                break;
            }

            // Choose current element
            current.add(A[i]);

            // i + 1 because each element can be used only once
            generate(A, target - A[i], i + 1, current);

            // Backtracking
            current.remove(current.size() - 1);
        }
    }
}
