package com.scaler.module_2.assignments.DSA_Module_5.Stack_1;
import java.util.ArrayList;
/*Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
Check whether A has redundant braces or not.
NOTE: A will be always a valid expression and will not contain any white spaces.
Problem Constraints
1 <= |A| <= 105
Input Format
The only argument given is string A.
Output Format
Return 1 if A has redundant braces else, return 0.
Example Input
Input 1: A = "((a+b))"
Input 2: A = "(a+(a+b))"
Example Output
Output 1: 1
Output 2: 0
Example Explanation
Explanation 1: ((a+b)) has redundant braces so answer will be 1.
Explanation 2: (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
*/
public class Stack_4 {
    public int braces(String A) {
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch != ')') {
                stack.add(ch);
            } else {
                boolean operatorFound = false;
                while (stack.size() > 0 &&
                        stack.get(stack.size() - 1) != '(') {
                    char top = stack.remove(stack.size() - 1);
                    if (top == '+' || top == '-' ||
                            top == '*' || top == '/') {
                        operatorFound = true;
                    }
                }
                // Remove opening bracket
                stack.remove(stack.size() - 1);
                if (!operatorFound) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
