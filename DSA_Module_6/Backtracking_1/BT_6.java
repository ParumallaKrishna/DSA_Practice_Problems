package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_1;

import java.util.ArrayList;

/*Given a digit string A, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
NOTE: Make sure the returned strings are lexicographically sorted.
Problem Constraints
1 <= |A| <= 10
Input Format
The only argument is a digit string A.
Output Format
Return a string array denoting the possible letter combinations.
Example Input
Input 1: A = "23"
Input 2:A = "012"
Example Output
Output 1: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2: ["01a", "01b", "01c"]*/
public class BT_6 {
    String[] mapping = {
            "0", "1", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    ArrayList<String> result;

    public String[] letterCombinations(String A) {

        result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        generate(A, 0, current);

        return result.toArray(new String[0]);
    }

    private void generate(String A, int index,
                          StringBuilder current) {

        // All digits have been processed
        if (index == A.length()) {
            result.add(current.toString());
            return;
        }

        int digit = A.charAt(index) - '0';

        String letters = mapping[digit];

        for (int i = 0; i < letters.length(); i++) {

            // Choose a letter
            current.append(letters.charAt(i));

            // Process next digit
            generate(A, index + 1, current);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }
}
