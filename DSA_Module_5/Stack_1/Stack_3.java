package com.scaler.module_2.assignments.DSA_Module_5.Stack_1;
import java.util.ArrayList;
/*An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each string may be an integer or an operator.
Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
Problem Constraints
1 <= N <= 105
Input Format
The only argument given is string array A.
Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.
Example Input
Input 1: A =   ["2", "1", "+", "3", "*"]
Input 2: A = ["4", "13", "5", "/", "+"]
Example Output
Output 1: 9
Output 2: 6*/
public class Stack_3 {
    public int evalRPN(ArrayList<String> A) {
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            String ch = A.get(i);
            if (ch.equals("+") || ch.equals("-") ||
                    ch.equals("*") || ch.equals("/")) {
                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);
                int result = 0;
                if (ch.equals("+")) {
                    result = a + b;
                }
                else if (ch.equals("-")) {
                    result = a - b;
                }
                else if (ch.equals("*")) {
                    result = a * b;
                }
                else if (ch.equals("/")) {
                    result = a / b;
                }
                stack.add(result);
            } else {
                stack.add(Integer.parseInt(ch));
            }
        }
        return stack.get(stack.size() - 1);
    }
}
