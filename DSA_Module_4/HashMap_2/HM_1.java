package com.scaler.module_2.assignments.DSA_Module_4.HashMap_2;
import java.util.HashMap;
/*Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
NOTE: The answer may be large so return the answer modulo (109 + 7).
Problem Constraints
1 <= N <= 105
0 <= A[i], B[i] <= 109
Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.
Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).
Example Input
Input 1: A = [1, 1, 2] B = [1, 2, 1]
Input 2: A = [1, 1, 2, 3, 3] B = [1, 2, 1, 2, 1]
Example Output
Output 1: 1
Output 2: 6*/
public class HM_1 {
    public int solve(int[] A, int[] B) {
        long MOD = 1000000007;
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        int n = A.length;
        // Count frequency of X and Y coordinates
        for (int i = 0; i < n; i++) {
            xMap.put(A[i], xMap.getOrDefault(A[i], 0) + 1);
            yMap.put(B[i], yMap.getOrDefault(B[i], 0) + 1);
        }
        long answer = 0;
        // Count right-angled triangles
        for (int i = 0; i < n; i++) {
            long sameX = xMap.get(A[i]) - 1;
            long sameY = yMap.get(B[i]) - 1;
            answer = (answer + (sameX * sameY) % MOD) % MOD;
        }
        return (int) answer;
    }
}
