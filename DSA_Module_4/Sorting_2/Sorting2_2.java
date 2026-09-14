package com.scaler.module_2.assignments.DSA_Module_4.Sorting_2;

import java.util.ArrayList;

/*Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.
What is the most number of chunks we could have made?
Problem Constraints
1 <= N <= 100000
0 <= A[i] < N
Input Format
The only argument given is the integer array A.
Output Format
Return the maximum number of chunks that we could have made.
Example Input
Input 1: A = [1, 2, 3, 4, 0]
Input 2: A = [2, 0, 1, 3]
Example Output
Output 1: 1
Output 2: 2*/
public class Sorting2_2 {
    public int solve(ArrayList<Integer> A) {
        int chunks = 0;
        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
            if (max == i) {
                chunks++;
            }
        }
        return chunks;
    }
}
