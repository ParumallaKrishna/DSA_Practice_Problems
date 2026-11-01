package com.scaler.module_2.assignments.DSA_Module_5.Stack_1;
import java.util.ArrayList;
/*Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Refer to the examples for more clarity.
Problem Constraints
1 <= |A| <= 100
Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.
Output Format
Return 0 if the parenthesis sequence is not balanced.
Return 1 if the parenthesis sequence is balanced.
Example Input
Input 1: A = {([])}
Input 2: A = (){
Input 3: A = ()[]
Example Output
Output 1: 1
Output 2: 0
Output 3: 1 */
public class Stack_1 {
    public int solve(String A) {
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } else {
                if (stack.size() == 0) {
                    return 0;
                }
                char top = stack.get(stack.size() - 1);
                if (ch == ')' && top != '(') {
                    return 0;
                }
                if (ch == '}' && top != '{') {
                    return 0;
                }
                if (ch == ']' && top != '[') {
                    return 0;
                }
                stack.remove(stack.size() - 1);
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }
}
