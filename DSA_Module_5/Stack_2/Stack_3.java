package com.scaler.module_2.assignments.DSA_Module_5.Stack_2;
import java.util.ArrayList;
import java.util.Stack;
/*Given an array of integers A.
The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000
Input Format
The first and only argument given is the integer array A.
Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.
Example Input
Input 1: A = [1]
Input 2: A = [4, 7, 3, 8]
Example Output
Output 1: 0
Output 2: 26*/
public class Stack_3 {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        long mod = 1000000007L;
        long maxSum = 0;
        long minSum = 0;
        Stack<Integer> stack = new Stack<>();
        // Calculate sum of all subarray maximums
        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MAX_VALUE : A.get(i);
            while (!stack.isEmpty() &&
                    (i == n || A.get(stack.peek()) < curr)) {
                int index = stack.pop();
                int left = stack.isEmpty() ? index + 1 :
                        index - stack.peek();
                int right = i - index;
                maxSum = (maxSum +
                        (long) A.get(index) * left * right) % mod;
            }
            stack.push(i);
        }
        stack.clear();
        // Calculate sum of all subarray minimums
        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MIN_VALUE : A.get(i);
            while (!stack.isEmpty() &&
                    (i == n || A.get(stack.peek()) > curr)) {
                int index = stack.pop();
                int left = stack.isEmpty() ? index + 1 :
                        index - stack.peek();
                int right = i - index;
                minSum = (minSum +
                        (long) A.get(index) * left * right) % mod;
            }
            stack.push(i);
        }
        return (int) ((maxSum - minSum + mod) % mod);
    }
}
