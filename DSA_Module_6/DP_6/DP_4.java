package com.scaler.module_2.assignments.DSA_Module_6.DP_6;
/*Given a string A consisting of lowercase English alphabets. Your task is to find how many substrings of A are palindrome.

The substrings with different start indexes or end indexes are counted as different substrings even if they consist of same characters.

Return the count of palindromic substrings.

Note: A string is palindrome if it reads the same from backward and forward.


Input Format

The only argument given is string A.
Output Format

Return the count of palindromic substrings.
Constraints

1 <= length of the array <= 1000
For Example

Input 1:
    A = "abab"
Output 1:
    6
Explanation 1:
    6 palindromic substrings are:
    "a", "aba", "b", "bab", "a" and "b".

Input 2:
    A = "ababa"
Output 2:
    9
Explanation 9:
    9 palindromic substrings are:
    "a", "a", "a", "b", "b" , "aba" ,"bab", "aba" and "ababa".*/
public class DP_4 {
    public int solve(String A) {

        int n = A.length();
        int count = 0;

        for (int i = 0; i < n; i++) {

            // Odd length palindromes
            int left = i;
            int right = i;

            while (left >= 0 && right < n &&
                    A.charAt(left) == A.charAt(right)) {

                count++;
                left--;
                right++;
            }

            // Even length palindromes
            left = i;
            right = i + 1;

            while (left >= 0 && right < n &&
                    A.charAt(left) == A.charAt(right)) {

                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
