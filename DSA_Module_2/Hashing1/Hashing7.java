package com.scaler.module_2.assignments.DSA_Module_2.Hashing1;

import java.util.HashSet;

/*Given a number A, find if it is COLORFUL number or not.
If number A is a COLORFUL number return 1 else, return 0.
What is a COLORFUL Number:
A number can be broken into different consecutive sequence of digits.
The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
Problem Constraints
1 <= A <= 2 * 109
Input Format
The first and only argument is an integer A.
Output Format
Return 1 if integer A is COLORFUL else return 0.
Example Input
Input 1:
 A = 23
Input 2:
 A = 236
Example Output
Output 1:1
Output 2: 0*/
public class Hashing7 {
    public int colorful(int A) {
        String numStr = String.valueOf(A);
        int n = numStr.length();
        HashSet<Integer> products = new HashSet<>();
        // Generate all contiguous subsequences
        for (int i = 0; i < n; i++) {
            int product = 1; // Reset for each new subsequence
            for (int j = i; j < n; j++) {
                product *= (numStr.charAt(j) - '0'); // Convert char to int and multiply
                if (products.contains(product)) {
                    return 0; // Not colorful
                }
                products.add(product);
            }
        }
        return 1;
    }
}
