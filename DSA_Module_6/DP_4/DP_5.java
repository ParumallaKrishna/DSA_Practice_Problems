package com.scaler.module_2.assignments.DSA_Module_6.DP_4;

import java.util.ArrayList;
import java.util.HashMap;

/*Given a strictly increasing array A of positive integers forming a sequence.

A sequence X1, X2, X3, ..., XN is fibonacci like if


N > =3
Xi + Xi+1 = Xi+2 for all i+2 <= N
Find and return the length of the longest Fibonacci-like subsequence of A.

If one does not exist, return 0.

NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.



Problem Constraints

3 <= length of the array <= 1000

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return the length of the longest Fibonacci-like subsequence of A.
If one does not exist, return 0.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5, 6, 7, 8]
Input 2:

 A = [1, 3, 7, 11, 12, 14, 18]


Example Output

Output 1:

 5
Output 2:

 3*/
public class DP_5 {
    public int solve(int[] A) {

        int n = A.length;

        // Store value -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }

        // DP table
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(2);
            }

            dp.add(row);
        }

        int maxLength = 0;

        for (int j = 0; j < n; j++) {

            for (int i = 0; i < j; i++) {

                int required = A[j] - A[i];

                if (map.containsKey(required)) {

                    int k = map.get(required);

                    if (k < i) {

                        int length = dp.get(k).get(i) + 1;

                        dp.get(i).set(j, length);

                        maxLength = Math.max(maxLength, length);
                    }
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }
}
