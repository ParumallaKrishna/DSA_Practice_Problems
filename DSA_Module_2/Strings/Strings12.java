package com.scaler.module_2.assignments.DSA_Module_2.Strings;
/*You are given a string A of lowercase English letters. Count the number of times the substring "bob" appears in A.
Overlapping matches are counted separately (for instance, "bobob" contains two occurrences: positions 0 and 2).
Problem Constraints
1 <= |A| <= 1000
Input Format
The only argument is the string A.
Output Format
Return a single integer, the number of times "bob" occurs in A.
Example Input
Input 1: A = "abobc"
Input 2: A = "bobob"
Example Output
Output 1: 1
Output 2: 2*/
public class Strings12 {
    public int solve(String A) {
        int count=0;
        for(int i=0;i<A.length()-2;i++){
            if(A.substring(i,i+3).equals("bob")){
                count++;
            }
        }
        return count;
    }
}
