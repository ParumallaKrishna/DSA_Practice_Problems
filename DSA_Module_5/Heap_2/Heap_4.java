package com.scaler.module_2.assignments.DSA_Module_5.Heap_2;
/*Max Heap is a special kind of complete binary tree in which, for every node, the value present in that node is greater than the value present in its children nodes.
Find the number of distinct Max Heap that can be made from A distinct integers.
In short, you have to ensure the following properties for the max heap :
Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)
Every node is greater than all its children.
NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.
Problem Constraints
1 <= A <= 100
Input Format
The first and only argument is an integer A.
Output Format
Return an integer denoting the number of distinct Max Heap.
Example Input
Input 1: A = 4
Input 2: A = 10
Example Output
Output 1: 3
Output 2: 3360*/
public class Heap_4 {
    static final int MOD = 1000000007;
    int[][] nCr = new int[101][101];
    int[] dp = new int[101];
    public int solve(int A) {
        // Calculate combinations
        for (int i = 0; i <= A; i++) {
            nCr[i][0] = 1;
            nCr[i][i] = 1;
            for (int j = 1; j < i; j++) {
                nCr[i][j] =
                        (nCr[i - 1][j - 1] + nCr[i - 1][j]) % MOD;
            }
        }
        // Initialize DP
        dp[0] = 1;
        dp[1] = 1;
        for (int n = 2; n <= A; n++) {
            int h = 0;
            while ((1 << (h + 1)) <= n) {
                h++;
            }
            int nodesBeforeLast = (1 << h) - 1;
            int nodesLastLevel = n - nodesBeforeLast;
            int maxLeftLast = 1 << (h - 1);
            int L = (maxLeftLast - 1)
                    + Math.min(nodesLastLevel, maxLeftLast);
            int R = n - 1 - L;
            long ways = nCr[n - 1][L];
            ways = (ways * dp[L]) % MOD;
            ways = (ways * dp[R]) % MOD;
            dp[n] = (int) ways;
        }
        return dp[A];
    }
}
