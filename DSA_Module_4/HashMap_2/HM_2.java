package com.scaler.module_2.assignments.DSA_Module_4.HashMap_2;
/*Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
Note:
If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
Problem Constraints
1 <= size(A), size(B) <= 106
Input Format
The first argument is a string A.
The second argument is a string B.
Output Format
Return a string denoting the minimum window.
Example Input
Input 1: A = "ADOBECODEBANC" B = "ABC"
Input 2: A = "Aa91b" B = "ab"
Example Output
Output 1: "BANC"
Output 2: "a91b"*/
public class HM_2 {
    public String minWindow(String A, String B) {
        int[] freq = new int[256];
        // Store frequency of characters in B
        for (int i = 0; i < B.length(); i++) {
            freq[B.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        int required = B.length();
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        while (right < A.length()) {
            char ch = A.charAt(right);
            if (freq[ch] > 0) {
                required--;
            }
            freq[ch]--;
            // All characters are included
            while (required == 0) {
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    startIndex = left;
                }
                char leftChar = A.charAt(left);
                freq[leftChar]++;
                if (freq[leftChar] > 0) {
                    required++;
                }
                left++;
            }
            right++;
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return A.substring(startIndex, startIndex + minLength);
    }
}
