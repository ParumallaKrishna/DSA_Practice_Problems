package com.scaler.module_2.assignments.DSA_Module_1.Intro_to_Array;
/*Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.
Problem Constraints
1 <= N <= 105
1 <= A[i] <=109
1 <= B <= 109
Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return the array A after rotating it B times to the right
Example Input
Input 1:
A = [1, 2, 3, 4]
B = 2
Input 2:
A = [2, 5, 6]
B = 1
Example Output
Output 1:
[3, 4, 1, 2]
Output 2:
[6, 2, 5]*/
public class Arrays_5 {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        B = B % n;
        reverse(A, 0, n - 1);
        reverse(A, 0, B - 1);
        reverse(A, B, n - 1);
        return A;
    }
    private void reverse(int[] A, int left, int right) {
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }
}
