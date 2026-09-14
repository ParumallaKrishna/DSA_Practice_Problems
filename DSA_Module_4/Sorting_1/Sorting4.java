package com.scaler.module_2.assignments.DSA_Module_4.Sorting_1;

import java.util.*;

/*Given an array of integers A of size N where N is even.
Divide the array into two subsets such that
1.Length of both subset is equal.
2.Each element of A occurs in exactly one of these subset.
Magic number = sum of absolute difference of corresponding elements of subset.
Note: You can reorder the position of elements within the subset to find the value of the magic number.
For Ex:-
subset 1 = {1, 5, 1},
subset 2 = {1, 7, 11}
Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.
Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109
N is even
Input Format
The first argument given is the integer array A.
Output Format
Return an array B of size 2, where B[0] = maximum possible value of Magic number % 109 + 7,B[1] = minimum possible value of a Magic number % 109 + 7.
Example Input
Input 1: A = [3, 11, -1, 5]
Input 2: A = [2, 2]
Example Output
Output 1: [14, 10]
Output 2: [0, 0]*/
public class Sorting4 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        final long MOD = 1000000007L;
        int n = A.size();
        int k = n / 2;
        // Sort the array
        Collections.sort(A);
        long maxMagic = 0;
        long minMagic = 0;
        // Minimum Magic Number
        // Pair adjacent elements
        for (int i = 0; i < n; i += 2) {
            long diff = (long) A.get(i + 1) - A.get(i);
            minMagic = (minMagic + diff) % MOD;
        }
        // Maximum Magic Number
        // Pair first half with second half
        for (int i = 0; i < k; i++) {
            long diff = (long) A.get(n - 1 - i) - A.get(i);
            maxMagic = (maxMagic + diff) % MOD;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) maxMagic);
        result.add((int) minMagic);
        return result;
    }
}
