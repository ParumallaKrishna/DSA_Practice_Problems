package com.scaler.module_2.assignments.DSA_Module_5.Stack_1;
import java.util.ArrayList;
/*Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
Find and return the postfix expression of A.
NOTE:
^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.
Problem Constraints
1 <= length of the string <= 500000
Input Format
The only argument given is string A.
Output Format
Return a string denoting the postfix conversion of A.
Example Input
Input 1: A = "x^y/(a*z)+b"
Input 2: A = "a+b*(c^d-e)^(f+g*h)-i"
Example Output*/
//Output 1: "xy^az*/b+"
//Output 2: "abcd^e-fgh*+^*+i-"*/
public class Stack_5 {
    public String solve(String A) {
        ArrayList<Character> stack = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            // If operand, append to result
            if (ch >= 'a' && ch <= 'z') {
                ans.append(ch);
            }
            // Opening bracket
            else if (ch == '(') {
                stack.add(ch);
            }
            // Closing bracket
            else if (ch == ')') {
                while (!stack.isEmpty() &&
                        stack.get(stack.size() - 1) != '(') {
                    ans.append(stack.remove(stack.size() - 1));
                }
                if (!stack.isEmpty()) {
                    stack.remove(stack.size() - 1);
                }
            }
            // Operator
            else {
                while (!stack.isEmpty()) {
                    char top = stack.get(stack.size() - 1);
                    if (top == '(') {
                        break;
                    }
                    if (precedence(top) > precedence(ch) ||
                            (precedence(top) == precedence(ch) && ch != '^')) {
                        ans.append(stack.remove(stack.size() - 1));
                    } else {
                        break;
                    }
                }
                stack.add(ch);
            }
        }
        // Pop remaining operators
        while (!stack.isEmpty()) {
            ans.append(stack.remove(stack.size() - 1));
        }
        return ans.toString();
    }
    private int precedence(char ch) {
        if (ch == '^') {
            return 3;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        if (ch == '+' || ch == '-') {
            return 1;
        }
        return 0;
    }
}
