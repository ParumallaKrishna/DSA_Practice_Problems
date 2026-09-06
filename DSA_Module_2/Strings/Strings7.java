package com.scaler.module_2.assignments.DSA_Module_2.Strings;
/*Given a string A of size N, find and return the longest palindromic substring in A.
Substring of string A is A[i...j] where 0 <= i <= j < len(A)
Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
Incase of conflict, return the substring which occurs first ( with the least starting index).
Problem Constraints
1 <= N <= 6000
Input Format
First and only argument is a string A.
Output Format
Return a string denoting the longest palindromic substring of string A.
Example Input
Input 1: A = "aaaabaaa"
Input 2: A = "abba
Example Output
Output 1: "aaabaaa"
Output 2: "abba"*/
public class Strings7 {
    public String longestPalindrome(String A) {
        int MaxLength =1;
        int start=0;
        for(int i=0;i<A.length();i++){
            int len1 = expand(A,i,i);
            int len2 = expand(A,i,i+1);
            int len = Math.max(len1,len2);
            if(len>MaxLength){
                MaxLength=len;
                start =i-(len-1)/2;
            }
        }
        return A.substring(start,start+MaxLength);
    }
    int expand(String A,int left,int right){
        while(left>=0 && right<A.length() && A.charAt(left)==A.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
