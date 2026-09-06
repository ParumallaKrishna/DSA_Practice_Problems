package com.scaler.module_2.assignments.DSA_Module_2.Strings;
/*You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.
Problem Constraints
1 <= N <= 105
A[i] ∈ ['a'-'z', 'A'-'Z']
Input Format
First and only argument is a character string A.
Output Format
Return a character string.
Example Input
Input 1:
 A = "Hello"
Input 2:
 A = "tHiSiSaStRiNg"
Example Output
Output 1:
 hELLO
Output 2:
 ThIsIsAsTrInG*/
public class Strings3 {
    public String solve(String A) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                // Uppercase to lowercase
                result.append((char)(ch + 32));
            } else {
                // Lowercase to uppercase
                result.append((char)(ch - 32));
            }
        }
        return result.toString();
    }
}
