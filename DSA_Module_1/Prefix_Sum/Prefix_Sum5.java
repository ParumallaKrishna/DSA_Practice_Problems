package com.scaler.module_2.assignments.DSA_Module_1.Prefix_Sum;
import java.util.ArrayList;
/*Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
Input Format
The only argument given is the integer array A.
Output Format
Return the product array.
Constraints
2 <= length of the array <= 1000
1 <= A[i] <= 10
For Example
Input 1: A = [1, 2, 3, 4, 5]
Output 1: [120, 60, 40, 30, 24]
Input 2: A = [5, 1, 10, 1]
Output 2: [10, 50, 5, 50]*/
public class Prefix_Sum5 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> suffix = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        // Prefix products
        prefix.add(1);
        for (int i = 1; i < n; i++) {
            prefix.add(prefix.get(i - 1) * A.get(i - 1));
        }
        // Suffix products
        suffix.add(1);
        for (int i = 1; i < n; i++) {
            suffix.add(1);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix.set(i, suffix.get(i + 1) * A.get(i + 1));
        }
        // Product of left and right
        for (int i = 0; i < n; i++) {
            result.add(prefix.get(i) * suffix.get(i));
        }
        return result;
    }
}
