package com.scaler.module_2.assignments.DSA_Module_4.two_pointers;
import java.util.ArrayList;
import java.util.Collections;
/*Given an one-dimensional integer array A of size N and an integer B.
Count all distinct pairs with difference equal to B.
Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
Problem Constraints
1 <= N <= 104
0 <= A[i], B <= 105
Input Format
First argument is an one-dimensional integer array A of size N.
Second argument is an integer B.
Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.
Example Input
Input 1: A = [1, 5, 3, 4, 2] B = 3
Input 2: A = [8, 12, 16, 4, 0, 20] B = 4
Input 3: A = [1, 1, 1, 2, 2] B = 0
Example Output
Output 1: 2
Output 2: 5
Output 3: 2*/
public class TP_2 {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int i = 0;
        int j = 1;
        int count = 0;
        while (j < A.size()) {
            if (i == j) {
                j++;
                continue;
            }
            int diff = A.get(j) - A.get(i);
            if (diff == B) {
                count++;
                int x = A.get(i);
                int y = A.get(j);
                // Skip duplicates of both values
                while (i < A.size() && A.get(i) == x) {
                    i++;
                }
                while (j < A.size() && A.get(j) == y) {
                    j++;
                }
            } else if (diff < B) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }
}
