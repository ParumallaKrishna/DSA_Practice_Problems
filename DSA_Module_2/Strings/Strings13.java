package com.scaler.module_2.assignments.DSA_Module_2.Strings;

import java.util.Arrays;

/*Problem Description
You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.
Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.
Problem Constraints
1 <= N <= 105
A and B are lowercase strings
Input Format
Both arguments A and B are a string.
Output Format
Return 1 if they are anagrams and 0 if not
Example Input
Input 1:
A = "cat"
B = "bat"
Input 2:
A = "secure"
B = "rescue"
Example Output
Output 1: 0
Output 2: 1*/
public class Strings13 {
    public int solve(String A, String B) {
        if (A.length() != B.length()) {
            return 0; // Different lengths cannot be anagrams
        }
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        return Arrays.equals(arrA, arrB) ? 1 : 0;
    }
}
