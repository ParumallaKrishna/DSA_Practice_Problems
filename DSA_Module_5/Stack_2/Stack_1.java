package com.scaler.module_2.assignments.DSA_Module_5.Stack_2;
import java.util.ArrayList;
import java.util.Stack;
/*Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
More formally,
G[i] for an element A[i] = an element A[j] such that
j is maximum possible AND
j < i AND
A[j] < A[i]
Elements for which no smaller element exist, consider the next smaller element as -1.
Problem Constraints
1 <= |A| <= 100000
-109 <= A[i] <= 109
Input Format
The only argument given is integer array A.
Output Format
Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.
Example Input
Input 1: A = [4, 5, 2, 10, 8]
Input 2: A = [3, 2, 1]
Example Output
Output 1: [-1, 4, -1, 2, 2]
Output 2: [-1, -1, -1]*/
public class Stack_1 {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            // Remove elements greater than or equal to current element
            while (!stack.isEmpty() && stack.peek() >= A.get(i)) {
                stack.pop();
            }
            // Nearest smaller element
            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }
            // Push current element
            stack.push(A.get(i));
        }
        return ans;
    }
}
