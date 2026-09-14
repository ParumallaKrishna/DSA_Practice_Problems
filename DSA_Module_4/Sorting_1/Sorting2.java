package com.scaler.module_2.assignments.DSA_Module_4.Sorting_1;
import java.util.ArrayList;
import java.util.List;
/*Find the Bth smallest element in given array A .
NOTE: Users should try to solve it in less than equal to B swaps.
Problem Constraints
1 <= |A| <= 100000
1 <= B <= min(|A|, 500)
1 <= A[i] <= 109
Input Format
The first argument is an integer array A.
The second argument is integer B.
Output Format
Return the Bth smallest element in given array.
Example Input
Input 1: A = [2, 1, 4, 3, 2] B = 3
Input 2: A = [1, 2] B = 2
Example Output
Output 1: 2
Output 2: 2*/
public class Sorting2 {
    public int kthsmallest(final List<Integer> A, int B) {
        // Create a mutable copy
        ArrayList<Integer> arr = new ArrayList<>(A);
        int n = arr.size();
        // Find first B smallest elements
        for (int i = 0; i < B; i++) {
            int minIndex = i;
            // Find minimum element from i to n-1
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Swap
            if (minIndex != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }
        return arr.get(B - 1);
    }
}
