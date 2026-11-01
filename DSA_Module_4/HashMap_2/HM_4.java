package com.scaler.module_2.assignments.DSA_Module_4.HashMap_2;
import java.util.ArrayList;
/*Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest substring that contains no repeating characters. The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.
Your task is to return an integer representing the "GOOD"ness of string A.
Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.
Problem Constraints
1 <= size(A) <= 106
String consists of lowerCase,upperCase characters and digits are also present in the string A.
Input Format
Single Argument representing string A.
Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.
Example Input
Input 1: A = "abcabcbb"
Input 2:  A = "AaaA"
Example Output
Output 1: 3
Output 2: 2*/
public class HM_4 {
    public int lengthOfLongestSubstring(String A) {
        ArrayList<Integer> lastIndex = new ArrayList<>();
        // Initialize 62 positions with -1
        for (int i = 0; i < 62; i++) {
            lastIndex.add(-1);
        }
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < A.length(); right++) {
            char ch = A.charAt(right);
            int index;
            // Map character to index from 0 to 61
            if (ch >= 'a' && ch <= 'z') {
                index = ch - 'a';
            } else if (ch >= 'A' && ch <= 'Z') {
                index = ch - 'A' + 26;
            } else {
                index = ch - '0' + 52;
            }
            // If character was already seen inside window
            if (lastIndex.get(index) >= left) {
                left = lastIndex.get(index) + 1;
            }
            lastIndex.set(index, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
