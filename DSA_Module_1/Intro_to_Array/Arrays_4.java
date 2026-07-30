package com.scaler.module_2.assignments.DSA_Module_1.Intro_to_Array;
/*You are given a constant array A.
You are required to return another array which is the reversed form of the input array.
Problem Constraints
1 <= A.size() <= 10000
1 <= A[i] <= 10000
Input Format
First argument is a constant array A.
Output Format
Return an integer array.
Example Input
Input 1:
A = [1,2,3,2,1]
Input 2:
A = [1,1,10]
Example Output
Output 1:
 [1,2,3,2,1]
Output 2:
 [10,1,1] */
public class Arrays_4 {

    public int[] solve(final int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            result[j++] = A[i];
        }
        return result;
    }
}
