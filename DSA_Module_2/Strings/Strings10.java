package com.scaler.module_2.assignments.DSA_Module_2.Strings;
/*Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:
Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.
NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
Problem Constraints
1<=N<=100000
Input Format
First argument is a string A of size N.
Output Format
Return the resultant string.
Example Input
Input 1: A="aeiOUz"
Input 2: A="AbcaZeoB"
Example Output
Output 1: "###z###z"
Output 2: "bc###bc###"*/
public class Strings10 {
    public String solve(String A) {
        StringBuilder result = new StringBuilder();
        // A is concatenated with itself,
        // so process every character twice
        for (int repeat = 0; repeat < 2; repeat++) {
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                // Delete uppercase letters
                if (ch >= 'A' && ch <= 'Z') {
                    continue;
                }
                // Replace lowercase vowels with '#'
                if (ch == 'a' || ch == 'e' || ch == 'i'
                        || ch == 'o' || ch == 'u') {
                    result.append('#');
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}
