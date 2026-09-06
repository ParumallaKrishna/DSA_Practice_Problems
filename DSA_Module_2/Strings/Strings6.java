package com.scaler.module_2.assignments.DSA_Module_2.Strings;
/*You are given a string A of size N.
Return the string A after reversing the string word by word.
NOTE:
A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
Problem Constraints
1 <= N <= 3 * 105
Input Format
The only argument given is string A.
Output Format
Return the string A after reversing the string word by word.
Example Input
Input 1:
A = "the sky is blue"
Input 2:
A = "this is ib"
Example Output
Output 1:
"blue is sky the"
Output 2:
"ib is this"*/
public class Strings6 {
    public String solve(String A) {
        String ans = "";
        boolean firstWord = false;
        for(int i=A.length()-1;i>=0;i--){
            String revCurr = "";
            String curr="";
            // Skip spaces before extracting a word
            while (i >= 0 && A.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break; // If all spaces are skipped, stop
            if(A.charAt(i)!=' '){

                while( i>=0 && A.charAt(i)!=' '){
                    revCurr=revCurr+A.charAt(i);
                    i--;
                }
                curr= reverse(revCurr);
            }
            if(firstWord==false){
                firstWord=true;
                ans=ans+curr;
            }
            else{
                ans=ans+' ';
                ans = ans+curr;
            }
        }
        return ans;
    }
    String reverse(String rev){
        int n =rev.length()-1;
        String reverse = "";
        while(n>=0){
            reverse=reverse+rev.charAt(n);
            n--;
        }
        return reverse;
    }
}
