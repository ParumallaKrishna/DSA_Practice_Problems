package com.scaler.module_2.assignments.DSA_Module_6.DP_2;

import java.util.ArrayList;

/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row

Problem Constraints

|A| <= 1000

A[i] <= 1000



Input Format

First and only argument is the vector of vector A defining the given triangle



Output Format

Return the minimum sum



Example Input

Input 1:


A = [
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:

 A = [ [1] ]


Example Output

Output 1:

 11
Output 2:

 1*/
public class DP_6 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {

        int n = a.size();

        // Copy the last row into dp
        ArrayList<Integer> dp = new ArrayList<>(a.get(n - 1));

        // Traverse from second-last row to first row
        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                int current = a.get(i).get(j);

                int left = dp.get(j);
                int right = dp.get(j + 1);

                dp.set(j, current + Math.min(left, right));
            }
        }

        return dp.get(0);
    }
}
