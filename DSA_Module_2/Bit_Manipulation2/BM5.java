package com.scaler.module_2.assignments.DSA_Module_2.Bit_Manipulation2;
/*You are given two integers A and B.
If B-th bit in A is set, make it unset
If B-th bit in A is unset, make it set
Return the updated A value
Problem Constraints
1 <= A <= 109
0 <= B <= 30
Input Format
First argument A is an integer.
Second argument B is an integer.
Output Format
Return an integer.
Example Input
Input 1: A = 4 B = 1
Input 2: A = 5 B = 2
Example Output
Output 1: 6
Output 2: 1
*/
public class BM5 {
    public int solve(int A, int B) {
        return A ^ (1 << B);
    }
}
