package com.scaler.module_2.assignments.DSA_Module_6.DP_1;
/*Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible.
NOTE: Answer will fit in 32-bit integer value.
Problem Constraints
1 <= N <= 5 * 105
-100 <= A[i] <= 100
Input Format
First and only argument is an integer array A.
Output Format
Return an integer corresponding to the maximum product possible.
Example Input
Input 1:
 A = [4, 2, -5, 1]
Input 2:
 A = [-3, 0, -5, 0]
Example Output
Output 1:
 8
Output 2:
 0
*/
public class DP_6 {
    public int maxProduct(final int[] A) {

        int maxProduct = A[0];
        int minProduct = A[0];

        int answer = A[0];

        for (int i = 1; i < A.length; i++) {

            int current = A[i];

            // Negative number swaps max and min
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(
                    current,
                    maxProduct * current
            );

            minProduct = Math.min(
                    current,
                    minProduct * current
            );

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}
