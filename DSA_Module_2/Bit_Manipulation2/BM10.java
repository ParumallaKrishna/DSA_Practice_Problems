package com.scaler.module_2.assignments.DSA_Module_2.Bit_Manipulation2;
/*Reverse the bits of an 32 bit unsigned integer A.
Problem Constraints
0 <= A <= 232
Input Format
First and only argument of input contains an integer A.
Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.
Example Input
Input 1: 0
Input 2: 3
Example Output
Output 1: 0
Output 2: 3221225472*/
public class BM10 {
    public long reverse(long A) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            // Get the last bit of A
            long bit = A & 1;
            // Shift result left to make space
            result = result << 1;
            // Add the extracted bit
            result = result | bit;
            // Move to the next bit of A
            A = A >> 1;
        }
        return result;
    }
}
