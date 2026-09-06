package com.scaler.module_2.assignments.DSA_Module_2.Strings;
import java.util.ArrayList;
/*Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
Problem Constraints
0 <= sum of length of all strings <= 1000000
Input Format
The only argument given is an array of strings A.
Output Format
Return the longest common prefix of all strings in A.
Example Input
Input 1: A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2: A = ["abab", "ab", "abcd"];
Example Output
Output 1: "a"
Output 2: "ab"
*/
public class Strings8 {
    public String longestCommonPrefix(ArrayList<String> A) {
        if (A == null || A.size() == 0) {
            return "";
        }
        String prefix = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            String current = A.get(i);
            int j = 0;
            // Compare characters of prefix and current string
            while (j < prefix.length()
                    && j < current.length()
                    && prefix.charAt(j) == current.charAt(j)) {
                j++;
            }
            // Keep only the common part
            prefix = prefix.substring(0, j);
            // No common prefix
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }
}
