package com.scaler.module_2.assignments.DSA_Module_1.Prefix_Sum;
import java.util.ArrayList;
/*You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109
0 <= L <= R < N
Input Format
The first argument is the integer array A.
The second argument is the 2D integer array B.
Output Format
Return an integer array of length M where ith element is the answer for ith query in B.
Example Input
Input 1: A = [1, 2, 3, 4, 5] B = [[0, 3], [1, 2]]
Input 2: A = [2, 2, 2] B = [[0, 0], [1, 2]]
Example Output
Output 1: [10, 5]
Output 2: [2, 4]*/
public class Prefix_Sum1 {
    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        int m = B.size();
        ArrayList<Long> prefix = new ArrayList<>();
        // Build prefix sum
        prefix.add((long) A.get(0));
        for (int i = 1; i < n; i++) {
            long sum = prefix.get(i - 1) + A.get(i);
            prefix.add(sum);
        }
        // Store answers
        ArrayList<Long> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int L = B.get(i).get(0);
            int R = B.get(i).get(1);
            long sum;
            if (L == 0) {
                sum = prefix.get(R);
            } else {
                sum = prefix.get(R) - prefix.get(L - 1);
            }
            result.add(sum);
        }
        return result;
    }
}

