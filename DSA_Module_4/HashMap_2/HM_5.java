package com.scaler.module_2.assignments.DSA_Module_4.HashMap_2;
import java.util.ArrayList;
import java.util.HashSet;
/*Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 109
Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.
Output Format
Return the number of unordered quadruplets that form a rectangle.
Example Input
Input 1: A = [1, 1, 2, 2] B = [1, 2, 1, 2]
Input 1: A = [1, 1, 2, 2, 3, 3] B = [1, 2, 1, 2, 1, 2]
Example Output
Output 1: 1
Output 2: 3*/
public class HM_5 {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        HashSet<Long> set = new HashSet<>();
        // Store all points
        for (int i = 0; i < n; i++) {
            long key = (long) A.get(i) * 1000000001L + B.get(i);
            set.add(key);
        }
        long count = 0;
        // Select every pair of points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Diagonal points must differ in both coordinates
                if (A.get(i).equals(A.get(j)) ||
                        B.get(i).equals(B.get(j))) {
                    continue;
                }
                // Find the remaining two corners
                long point1 = (long) A.get(i) * 1000000001L + B.get(j);
                long point2 = (long) A.get(j) * 1000000001L + B.get(i);
                if (set.contains(point1) && set.contains(point2)) {
                    count++;
                }
            }
        }
        // Each rectangle is counted twice
        return (int) (count / 2);
    }
}
