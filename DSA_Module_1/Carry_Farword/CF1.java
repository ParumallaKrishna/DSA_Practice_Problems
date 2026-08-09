package com.scaler.module_2.assignments.DSA_Module_1.Carry_Farword;
import java.util.*;
import java.util.ArrayList;

/*Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.
NOTE: The rightmost element is always a leader.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 108
Input Format
There is a single input argument which a integer array A
Output Format
Return an integer array denoting all the leader elements of the array.
Example Input
Input 1: A = [16, 17, 4, 3, 5, 2]
Input 2: A = [5, 4]
Example Output
Output 1: [17, 2, 5]
Output 2: [5, 4]*/
public class CF1 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxRight = Integer.MIN_VALUE;
        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i) > maxRight) {
                result.add(A.get(i));
                maxRight = A.get(i);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
