package com.scaler.module_2.assignments.DSA_Module_4.String_Pattern_Matching;
import java.util.ArrayList;
/*Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
If it is possible, return 1, else return -1.
Problem Constraints
1 <= Length of string B <= 1000
1 <= A <= 1000
All the alphabets of S are lower case (a - z)
Input Format
First argument is an integer A.
Second argument is a string B.
Output Format
Your function should return 1 if it is possible to re-arrange the characters of the string B so that it can be represented as a concatenation of A similar strings. If it is not, return -1.
Example Input
Input 1: A = 2 B = "bbaabb"
Input 2: A = 2 B = "bc"
Example Output
Output 1: 1
Output 2: -1*/
public class SP_3 {
    public int solve(int A, String B) {
        int n = B.length();
        // Total length must be divisible by A
        if (n % A != 0) {
            return -1;
        }
        ArrayList<Integer> freq = new ArrayList<>();
        // Initialize frequency of 26 characters
        for (int i = 0; i < 26; i++) {
            freq.add(0);
        }
        // Count character frequencies
        for (int i = 0; i < n; i++) {
            int index = B.charAt(i) - 'a';
            freq.set(index, freq.get(index) + 1);
        }
        // Every character frequency must be divisible by A
        for (int i = 0; i < 26; i++) {
            if (freq.get(i) % A != 0) {
                return -1;
            }
        }
        return 1;
    }
}
