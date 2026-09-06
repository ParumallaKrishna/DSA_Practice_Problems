package com.scaler.module_2.assignments.DSA_Module_2.Hashing2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
Since the answer can be very large, return the remainder after dividing the count with 109+7.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109
Input Format
First argument A is an array of integers and second argument B is an integer.
Output Format
Return an integer.
Example Input
Input 1: A = [3, 5, 1, 2] B = 4
Input 2: A = [1, 2, 1, 2] B = 1
Example Output
Output 1: 1
Output 2: 4*/
public class Hashing2_5 {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        long count = 0;
        int MOD = 1000000007;

        for (int num : A) {
            count = (count + freqMap.getOrDefault(num - B, 0)) % MOD;
            count = (count + freqMap.getOrDefault(num + B, 0)) % MOD;
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        return (int) count;
    }
}
