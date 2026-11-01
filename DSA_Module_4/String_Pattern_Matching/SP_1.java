package com.scaler.module_2.assignments.DSA_Module_4.String_Pattern_Matching;
/*Given two string A and B of length N and M respectively consisting of lowercase letters. Find the number of occurrences of B in A.
Problem Constraints
1 <= M <= N <= 105
Input Format
Two argument A and B are strings
Output Format
Return an integer denoting the number of occurrences of B in A
Example Input
Input 1: A = "acbac" B = "ac"
Input 2: A = "aaaa" B = "aa"
Example Output
Output 1: 2
Output 2: 3*/
public class SP_1 {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        // Build LPS array
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (B.charAt(i) == B.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        // Search pattern B in string A
        int count = 0;
        int j = 0;
        i = 0;
        while (i < n) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                count++;
                // Continue searching for overlapping matches
                j = lps[j - 1];
            } else if (i < n && A.charAt(i) != B.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
