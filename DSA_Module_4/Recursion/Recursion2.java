package com.scaler.module_2.assignments.DSA_Module_4.Recursion;

import java.util.ArrayList;

/*Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
Problem Constraints
1 <= A <= 10
Input Format
First and only argument is integer A.
Output Format
Return a sorted list of all possible parenthesis.
Example Input
Input 1: A = 3
Input 2: A = 1
Example Output
Output 1: [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2: [ "()" ]*/
public class Recursion2 {
    ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> generateParenthesis(int A) {
        result.clear();
        backtrack(A, 0, 0, "");
        return result;
    }
    private void backtrack(int A, int open, int close, String current) {
        // If the string has 2*A characters, it is complete
        if (current.length() == 2 * A) {
            result.add(current);
            return;
        }
        // We can add '(' if we haven't used all A opening brackets
        if (open < A) {
            backtrack(
                    A,
                    open + 1,
                    close,
                    current + "("
            );
        }
        // We can add ')' only when there is an unmatched '('
        if (close < open) {
            backtrack(
                    A,
                    open,
                    close + 1,
                    current + ")"
            );
        }
    }
}
