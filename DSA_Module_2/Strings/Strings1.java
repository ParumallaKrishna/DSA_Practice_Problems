package com.scaler.module_2.assignments.DSA_Module_2.Strings;

import java.util.ArrayList;

/*You are given a function to_lower() which takes a character array A as an argument.
Convert each character of A into lowercase characters if it exists. If the lowercase of a character does not exist, it remains unmodified.
The uppercase letters from A to Z are converted to lowercase letters from a to z respectively.
Return the lowercase version of the given character array.
Problem Constraints
1 <= |A| <= 105
Input Format
The only argument is a character array A.
Output Format
Return the lowercase version of the given character array.
Example Input
Input 1: A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
Input 2: A = ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']*/
public class Strings1 {
    public ArrayList<Character> to_lower(ArrayList<Character> A) {
        for (int i = 0; i < A.size(); i++) {
            char ch = A.get(i);
            if (ch >= 'A' && ch <= 'Z') {
                A.set(i, (char)(ch + 32));
            }
        }
        return A;
    }
}
