package com.scaler.module_2.assignments.DSA_Module_4.two_pointers;

import java.util.ArrayList;

/*Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
For this problem, return the indices of maximum continuous series of 1s in order.
If there are multiple possible solutions, return the sequence which has the minimum start index.
Problem Constraints
0 <= B <= 105
1 <= size(A) <= 105
0 <= A[i] <= 1
Input Format
First argument is an binary array A.
Second argument is an integer B.
Output Format
Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.
Example Input
Input 1: A = [1, 1, 0, 1, 1, 0, 0, 1, 1, 1] B = 1
Input 2: A = [1, 0, 0, 0, 1, 0, 1] B = 2
Example Output
Output 1: [0, 1, 2, 3, 4]
Output 2: [3, 4, 5, 6]*/
public class TP_6 {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int left = 0;
        int zeroCount = 0;
        int bestStart = 0;
        int bestLength = 0;
        for (int right = 0; right < A.size(); right++) {
            if (A.get(right) == 0) {
                zeroCount++;
            }
            while (zeroCount > B) {
                if (A.get(left) == 0) {
                    zeroCount--;
                }
                left++;
            }
            int currentLength = right - left + 1;
            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestStart = left;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = bestStart; i < bestStart + bestLength; i++) {
            result.add(i);
        }
        return result;
    }
}
