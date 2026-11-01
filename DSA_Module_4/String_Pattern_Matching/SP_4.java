package com.scaler.module_2.assignments.DSA_Module_4.String_Pattern_Matching;
import java.util.ArrayList;
/*Given two strings A and B, determine if they are isomorphic.
A and B are called isomorphic strings if all occurrences of each character in A can be replaced with another character to get B and vice-versa.
Problem Constraints
1 <= |A| <= 100000
1 <= |B| <= 100000
A and B contain only lowercase characters.
Input Format
The first Argument is string A.
The second Argument is string B.
Output Format
Return 1 if strings are isomorphic, 0 otherwise.
Example Input
Input 1: A = "aba" B = "xyx"
Input 2: A = "cvv" B = "xyx"
Example Output
Output 1: 1
Output 2: 0*/
public class SP_4 {
    public int solve(String A, String B) {
        if (A.length() != B.length()) {
            return 0;
        }
        ArrayList<Integer> mapAB = new ArrayList<>();
        ArrayList<Integer> mapBA = new ArrayList<>();
        // Initialize mappings with -1
        for (int i = 0; i < 26; i++) {
            mapAB.add(-1);
            mapBA.add(-1);
        }
        for (int i = 0; i < A.length(); i++) {
            int chA = A.charAt(i) - 'a';
            int chB = B.charAt(i) - 'a';
            // Check existing mapping from A to B
            if (mapAB.get(chA) != -1 &&
                    mapAB.get(chA) != chB) {
                return 0;
            }
            // Check reverse mapping from B to A
            if (mapBA.get(chB) != -1 &&
                    mapBA.get(chB) != chA) {
                return 0;
            }
            // Store both mappings
            mapAB.set(chA, chB);
            mapBA.set(chB, chA);
        }
        return 1;
    }
}
