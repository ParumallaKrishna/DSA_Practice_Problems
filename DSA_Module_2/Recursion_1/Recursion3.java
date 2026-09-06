package com.scaler.module_2.assignments.DSA_Module_2.Recursion_1;
/*Write a recursive function that checks whether string A is a palindrome or Not.
Return 1 if the string A is a palindrome, else return 0.
Note: A palindrome is a string that's the same when read forward and backward.
Problem Constraints
1 <= |A| <= 50000
String A consists only of lowercase letters.
Input Format
The first and only argument is a string A.
Output Format
Return 1 if the string A is a palindrome, else return 0.
Example Input
Input 1: A = "naman"
Input 2: A = "strings"
Example Output
Output 1: 1
Output 2: 0*/
public class Recursion3 {
    public int solve(String A) {
        int j=A.length()-1;
        int i=0;
        while(i<j){
            if(A.charAt(i)!=A.charAt(j)){
                return 0;
            }
            else{
                i++;
                j--;
            }
        }
        return 1;
    }
}
