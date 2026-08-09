package com.scaler.module_2.assignments.DSA_Module_1.Problems_On_Arrays;

import java.util.ArrayList;

/*You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
For every query, the task is to calculate the sum of all odd indices in the range A[B[i][0]…B[i][1]].
Note : Use 0-based indexing
Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= A[i] <= 100
0 <= B[i][0] <= B[i][1] < N
Input Format
First argument A is an array of integers.
Second argument B is a 2D array of integers.
Output Format
Return an array of integers.
Example Input
Input 1: A = [1, 2, 3, 4, 5] B = [   [0,2] [1,4]   ]
Input 2: A = [2, 1, 8, 3, 9] B = [   [0,3]  [2,4]   ]
Example Output
Output 1: [2, 6]
Output 2: [4, 3]*/
public class Arrays2 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        // Prefix sum of elements at odd indices
        int[] prefix = new int[n];
        // Index 0 is even, so don't add A[0]
        prefix[0] = 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if (i % 2 != 0) {
                prefix[i] += A.get(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        // Process each query
        for (int i = 0; i < B.size(); i++) {
            int left = B.get(i).get(0);
            int right = B.get(i).get(1);
            int sum;
            if (left == 0) {
                sum = prefix[right];
            } else {
                sum = prefix[right] - prefix[left - 1];
            }
            result.add(sum);
        }
        return result;
    }
}
