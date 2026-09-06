package com.scaler.module_2.assignments.DSA_Module_2.Strings;
import java.util.ArrayList;
/*Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 105
Input Format
The first argument is an integer array A.
Output Format
Return an integer array that is the sorted array A.
Example Input
Input 1: A = [1, 3, 1]
Input 2: A = [4, 2, 1, 3]
Example Output
Output 1: [1, 1, 3]
Output 2: [1, 2, 3, 4]*/
public class Strings4 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int max = 0;
        // Find maximum element
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
        }
        // Frequency array
        int[] count = new int[max + 1];
        // Count frequency of each element
        for (int i = 0; i < A.size(); i++) {
            count[A.get(i)]++;
        }
        // Build sorted result
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                result.add(i);
                count[i]--;
            }
        }
        return result;
    }
}
