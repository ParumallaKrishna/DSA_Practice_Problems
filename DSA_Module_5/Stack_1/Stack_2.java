package com.scaler.module_2.assignments.DSA_Module_5.Stack_1;
import java.util.Stack;
/*You have a string, denoted as A.
To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.
Problem Constraints
1 <= |A| <= 100000
Input Format
First and only argument is string A.
Output Format
Return the final string.
Example Input
Input 1: A = "abccbc"
Input 2: A = "ab"
Example Output
Output 1: "ac"
Output 2: "ab"*/
public class Stack_2 {
    public String solve(String A) {
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // Remove consecutive pair
            } else {
                stack.push(ch); // Add to stack
            }
        }
        // Convert stack to final string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();

    }
}
