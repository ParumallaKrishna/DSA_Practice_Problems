package com.scaler.module_2.assignments.DSA_Module_2.Bit_Manipulation2;
/*Given an integer A. Unset B bits from the right of A in binary.
For example, if A = 93 and B = 4, the binary representation of A is 1011101.
If we unset the rightmost 4 bits, we get the binary number 1010000, which is equal to the decimal value 80.
Problem Constraints
1 <= A <= 1018
1 <= B <= 60
Input Format
The first argument is a single integer A.
The second argument is a single integer B.
Output Format
Return the number with B unset bits from the right.
Example Input
Input 1:- A = 25 B = 3
Input 2:- A = 37 B = 3
Example Output
Output 1:- 24
Output 2:- 32*/
public class BM6 {
    public Long solve(Long A, int B) {
        long mask = (1L << B) - 1;
        return A & ~mask;
    }
}
