package com.scaler.module_2.assignments.DSA_Module_4.Sorting_3;
import java.util.ArrayList;
/*Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.
Note :
Follow 0-based indexing, while returning the sub-array's starting and ending indexes.
Problem Constraints
1 <= N <= 106
1 <= A[i] <= 106
Input Format
First and only argument is an array of non-negative integers of size N.
Output Format
Return an array of length two where,
the first element denotes the starting index(0-based) and
the second element denotes the ending index(0-based) of the sub-array.
If the array is already sorted, return an array containing only one element i.e. -1.
Example Input
Input 1:
A = [1, 3, 2, 4, 5]
Input 2:
A = [1, 2, 3, 4, 5]
Example Output
Output 1: [1, 2]
Output 2: [-1]*/
public class Sorting_3_5 {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int n = A.size();
        // Step 1: Find first unsorted index
        int L = 0;
        while (L < n - 1 && A.get(L) <= A.get(L + 1)) {
            L++;
        }
        // Already sorted
        if (L == n - 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(-1);
            return result;
        }
        // Step 2: Find last unsorted index
        int R = n - 1;
        while (R > 0 && A.get(R - 1) <= A.get(R)) {
            R--;
        }
        // Step 3: Find min and max in A[L...R]
        int min = A.get(L);
        int max = A.get(L);
        for (int i = L; i <= R; i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }
        // Step 4: Expand L to the left
        while (L > 0 && A.get(L - 1) > min) {
            L--;
        }
        // Step 5: Expand R to the right
        while (R < n - 1 && A.get(R + 1) < max) {
            R++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(L);
        result.add(R);
        return result;
    }
}
