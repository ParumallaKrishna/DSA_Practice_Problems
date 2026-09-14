package com.scaler.module_2.assignments.DSA_Module_3.Arrays1_1D;
import java.util.ArrayList;
/*You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
Problem Constraints
1 <= size of string <= 100000
Input Format
First and only argument is a string A.
Output Format
Return an array of integers denoting the answer.
Example Input
Input 1: A = "010"
Input 2: A = "111"
Example Output
Output 1: [1, 1]
Output 2: []*/
public class Arrays6 {
    public ArrayList<Integer> flip(String A) {
        int n = A.length();
        int currentSum = 0;
        int maxSum = 0;
        int currentStart = 0;
        int bestL = -1;
        int bestR = -1;
        for (int i = 0; i < n; i++) {
            int value = (A.charAt(i) == '0') ? 1 : -1;
            currentSum += value;
            // Found a better subarray
            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestL = currentStart;
                bestR = i;
            }
            // If sum becomes negative, start a new subarray
            if (currentSum < 0) {
                currentSum = 0;
                currentStart = i + 1;
            }
        }
        // No positive gain possible
        if (bestL == -1) {
            return new ArrayList<>();
        }
        // Convert 0-based indices to 1-based
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(bestL + 1);
        ans.add(bestR + 1);
        return ans;
    }
}
