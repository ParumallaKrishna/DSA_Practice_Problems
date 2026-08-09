package com.scaler.module_2.assignments.DSA_Module_1.Carry_Farword;
/*You are given a string S, and you have to find all the amazing substrings of S.
An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
Input
Only argument given is string S.
Output
Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
Constraints
1 <= length(S) <= 1e6
S can have special characters
Example
Input : ABEC
Output :6*/
public class CF5 {
    public int solve(String S) {
        int n = S.length();
        long count = 0;
        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' ||
                    ch == 'O' || ch == 'U') {
                count = (count + (n - i)) % 10003;
            }
        }
        return (int) count;
    }
}
