package com.scaler.module_2.assignments.DSA_Module_5.Stack_1;

import java.util.ArrayList;
/*Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
NOTE:
All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.
Problem Constraints
1 <= Number of Function calls <= 106
It is guaranteed that, atleast one call is made to either getMin() or top().
Input Format
Functions will be called by the checker code automatically.
Output Format
Each function should return the values as defined by the problem statement.
Example Input
Input 1:
push(1)
push(2)
push(-2)
getMin()
pop()
getMin()
top()
Input 2:
getMin()
pop()
top()
Example Output
Output 1:
 -2 1 2
Output 2:
 -1 -1*/
public class Stack_6 {
    ArrayList<Integer> stack = new ArrayList<>();
    ArrayList<Integer> minStack = new ArrayList<>();
    public void push(int x) {
        stack.add(x);
        if (minStack.size() == 0) {
            minStack.add(x);
        } else {
            int min = minStack.get(minStack.size() - 1);

            minStack.add(Math.min(x, min));
        }
    }
    public void pop() {
        if (stack.size() == 0) {
            return;
        }
        stack.remove(stack.size() - 1);
        minStack.remove(minStack.size() - 1);
    }
    public int top() {
        if (stack.size() == 0) {
            return -1;
        }
        return stack.get(stack.size() - 1);
    }
    public int getMin() {

        if (minStack.size() == 0) {
            return -1;
        }
        return minStack.get(minStack.size() - 1);
    }
}
