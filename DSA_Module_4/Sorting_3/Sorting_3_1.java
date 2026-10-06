package com.scaler.module_2.assignments.DSA_Module_4.Sorting_3;

import java.util.*;

/*Given an integer array, A of size N. You have to find all possible non-empty subsequences of the array of numbers and then,
for each subsequence, find the difference between the largest and smallest number in that subsequence.
Then add up all the differences to get the number.
As the number may be large, output the number modulo 1e9 + 7 (1000000007).
NOTE: Subsequence can be non-contiguous.
Problem Constraints
1 <= N <= 10000
1<= A[i] <=1000
Input Format
First argument is an integer array A.
Output Format
Return an integer denoting the output.
Example Input
Input 1: A = [1, 2]
Input 2: A = [3, 5, 10]
Example Output
Output 1: 1
Output 2: 21*/
public class Sorting_3_1 {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        long MOD = 1000000007L;
        Collections.sort(A);
        long ans = 0;
        long power = 1;
        // 2^i
        ArrayList<Long> pow2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pow2.add(power);
            power = (power * 2) % MOD;
        }
        for (int i = 0; i < n; i++) {
            long maxContribution =
                    (A.get(i) * pow2.get(i)) % MOD;
            long minContribution =
                    (A.get(i) * pow2.get(n - i - 1)) % MOD;
            ans = (ans + maxContribution - minContribution) % MOD;
        }
        if (ans < 0) {
            ans += MOD;
        }
        return (int) ans;
    }
}
