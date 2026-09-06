package com.scaler.module_2.assignments.DSA_Module_2.Strings;

import java.util.ArrayList;

/*Problem Description
You are given a function isalpha() consisting of a character array A.
Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.
Problem Constraints
1 <= |A| <= 105
Input Format
Only argument is a character array A.
Output Format
Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.
Example Input
Input 1: A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
Input 2: A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']
¨C49C
Example Output
Output 1: 1
Output 2: 0*/
public class Strings9 {
    public int solve(ArrayList<Character> A) {
        for(int i=0;i<A.size();i++){
            if(A.get(i)>='A' && A.get(i)<='Z'){
                continue;
            }
            else if( A.get(i)>='a' && A.get(i)<='z') {
                continue;
            }
            else if(A.get(i)>='0' && A.get(i)<='9'){
                continue;
            }
            else {
                return 0;
            }
        }
        return 1;
    }
}
