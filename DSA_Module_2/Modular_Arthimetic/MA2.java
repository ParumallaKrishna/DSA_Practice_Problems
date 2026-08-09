package com.scaler.module_2.assignments.DSA_Module_2.Modular_Arthimetic;
/*You are given a large number in the form of a array A of size N where each element denotes a digit of the number.
You are also given a number B. You have to find out the value of A % B and return it.
Problem Constraints
1 <= N <= 105
0 <= Ai <= 9
1 <= B <= 109
Input Format
The first argument is an integer array A.
The second argument is an integer B.
Output Format
Return a single integer denoting the value of A % B.
Example Input
Input 1: A = [1, 4, 3] B = 2
Input 2: A = [4, 3, 5, 3, 5, 3, 2, 1] B = 47
Example Output
Output 1: 1
Output 2: 20*/
public class MA2 {
    public int solve(int[] A, int B) {
        long rem = 0;
        for (int i = 0; i < A.length; i++) {
            rem = (rem * 10 + A[i]) % B;
        }
        return (int) rem;
    }
}
