package com.scaler.module_2.assignments.DSA_Module_2.Strings;

import java.util.ArrayList;

/*You are given a function to_upper() consisting of a character array A.
Convert each character of A into Uppercase character if it exists. If the Uppercase of a character does not exist, it remains unmodified.
The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.
Return the uppercase version of the given character array.
Problem Constraints
1 <= |A| <= 105
Input Format
Only argument is a character array A.
Output Format
Return the uppercase version of the given character array.
Example Input
Input 1:  A = ['S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
Input 2: A = ['S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0']*/
public class Strings2 {
    public ArrayList<Character> to_upper(ArrayList<Character> A) {
        for(int i= 0;i<A.size();i++){
            if(A.get(i)>='a' && A.get(i)<='z'){
                Character upperCase =(char)(A.get(i)-32);
                A.set(i,upperCase);
            }
        }
        return A;
    }
}
