package com.scaler.module_2.assignments.DSA_Module_3.Arrays1_1D;

import java.util.ArrayList;

/*Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.
NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
Problem Constraints
1 <= size of the array <= 1000000
Input Format
First argument is an array of digits.
Output Format
Return the array of digits after adding one.
Example Input
Input 1: [1, 2, 3]
Example Output
Output 1: [1, 2, 4]*/
public class Arrays5 {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        // Remove leading zeroes
        int start = 0;
        while (start < n - 1 && A.get(start) == 0) {
            start++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i < n; i++) {
            result.add(A.get(i));
        }
        // Start adding 1 from the last digit
        for (int i = result.size() - 1; i >= 0; i--) {
            if (result.get(i) < 9) {
                result.set(i, result.get(i) + 1);
                return result;
            }
            // 9 becomes 0 and carry continues
            result.set(i, 0);
        }
        // If all digits were 9, add 1 at the beginning
        result.add(0, 1);
        return result;
    }
}
