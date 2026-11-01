package com.scaler.module_2.assignments.DSA_Module_4.String_Pattern_Matching;
import java.util.ArrayList;
/*You are given two strings, A and B, of size N and M, respectively.
You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
Problem Constraints
1 <= N < M <= 105
Input Format
Given two arguments, A and B of type String.
Output Format
Return a single integer, i.e., number of permutations of A present in B as a substring.
Example Input
Input 1: A = "abc" B = "abcbacabc"
Input 2: A = "aca" B = "acaa"
Example Output
Output 1: 5
Output 2: 2*/
public class SP_2 {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        ArrayList<Integer> freqA = new ArrayList<>();
        ArrayList<Integer> freqB = new ArrayList<>();
        // Initialize frequency arrays for 26 characters
        for (int i = 0; i < 26; i++) {
            freqA.add(0);
            freqB.add(0);
        }
        // Calculate frequency of A
        for (int i = 0; i < n; i++) {
            int index = A.charAt(i) - 'a';
            freqA.set(index, freqA.get(index) + 1);
        }
        // Calculate frequency of first window in B
        for (int i = 0; i < n; i++) {
            int index = B.charAt(i) - 'a';
            freqB.set(index, freqB.get(index) + 1);
        }
        int count = 0;
        // Check first window
        if (freqA.equals(freqB)) {
            count++;
        }
        // Slide window through B
        for (int i = n; i < m; i++) {
            // Remove outgoing character
            int removeIndex = B.charAt(i - n) - 'a';
            freqB.set(removeIndex, freqB.get(removeIndex) - 1);

            // Add incoming character
            int addIndex = B.charAt(i) - 'a';
            freqB.set(addIndex, freqB.get(addIndex) + 1);

            // Compare frequencies
            if (freqA.equals(freqB)) {
                count++;
            }
        }
        return count;
    }
}
