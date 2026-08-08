package com.scaler.module_2.assignments.DSA_Module_1.Prefix_Sum;
import java.util.ArrayList;
/*You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
Each query consists of two integers B[i][0] and B[i][1].
For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].
Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= A[i] <= 109
0 <= B[i][0] <= B[i][1] < N
Input Format
First argument A is an array of integers.
Second argument B is a 2D array of integers.
Output Format
Return an array of integers.
Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = [   [0, 2] [2, 4] [1, 4]   ]
Input 2:
A = [2, 1, 8, 3, 9, 6]
B = [   [0, 3] [3, 5] [1, 3][2, 4]   ]
Example Output
Output 1: [1, 1, 2]
Output 2: [2, 1, 1, 1]
*/
public class Prefix_Sum4 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        // Create prefix array
        ArrayList<Integer> prefix = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) % 2 == 0) {
                count++;
            }
            prefix.add(count);
        }
        // Store answers
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            int L = B.get(i).get(0);
            int R = B.get(i).get(1);
            int evenCount;
            if (L == 0) {
                evenCount = prefix.get(R);
            } else {
                evenCount = prefix.get(R) - prefix.get(L - 1);
            }
            result.add(evenCount);
        }
        return result;
    }
}
