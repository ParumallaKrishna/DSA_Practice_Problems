package com.scaler.module_2.assignments.DSA_Module_5.Stack_2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/*Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
More formally:
G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.
Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 107
Input Format
The first and the only argument of input contains the integer array, A.
Output Format
Return an integer array representing the next greater element for each index in A.
Example Input
Input 1: A = [4, 5, 2, 10]
Input 2: A = [3, 2, 1]
Example Output
Output 1: [5, 10, 10, -1]
Output 2: [-1, -1, -1] */
public class Stack_4 {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= A.get(i)) {
                stack.pop();
            }
            // Find next greater element
            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }
            // Push current element
            stack.push(A.get(i));
        }
        // Reverse because we traversed from right to left
        Collections.reverse(ans);
        return ans;
    }
}
