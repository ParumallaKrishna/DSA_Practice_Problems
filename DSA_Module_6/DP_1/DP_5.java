package com.scaler.module_2.assignments.DSA_Module_6.DP_1;
/*You are given an array A of N integers and three integers B, C, and D.
You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
Problem Constraints
1 <= N <= 105
-10000 <= A[i], B, C, D <= 10000
Input Format
First argument is an array A
Second argument is an integer B
Third argument is an integer C
Fourth argument is an integer D
Output Format
Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.
Example Input
Input 1:
 A = [1, 5, -3, 4, -2]
 B = 2
 C = 1
 D = -1
Input 2:
 A = [3, 2, 1]
 B = 1
 C = -10
 D = 3
Example Output
Output 1:
 18
Output 2:
 -4
*/
public class DP_5 {
    public int solve(int[] A, int B, int C, int D) {

        int n = A.length;

        int first = A[0] * B;

        int second = first + A[0] * C;

        int third = second + A[0] * D;

        for (int i = 1; i < n; i++) {

            // Maximum A[i] * B
            first = Math.max(first, A[i] * B);

            // Maximum A[i] * B + A[j] * C
            second = Math.max(second, first + A[i] * C);

            // Maximum A[i] * B + A[j] * C + A[k] * D
            third = Math.max(third, second + A[i] * D);
        }

        return third;
    }
}
