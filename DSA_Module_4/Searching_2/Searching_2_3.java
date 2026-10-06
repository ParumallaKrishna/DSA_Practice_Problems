package com.scaler.module_2.assignments.DSA_Module_4.Searching_2;

import java.util.List;

/*There are two sorted arrays A and B of sizes N and M respectively.
Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
NOTE:
The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
Problem Constraints
1 <= N + M <= 2*106
Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.
Output Format
Return the median of the two sorted arrays as a decimal value, rounded to one decimal place.
Example Input
Input 1: A = [1, 4, 5] B = [2, 3]
Input 2: A = [1, 2, 3] B = [4]
Example Output
Output 1: 3.0
Output 2: 2.5*/
public class Searching_2_3 {
    public double findMedianSortedArrays(
            final List<Integer> A,
            final List<Integer> B) {
        if (A.size() > B.size()) {
            return findMedianSortedArrays(B, A);
        }
        int n = A.size();
        int m = B.size();
        int low = 0;
        int high = n;
        while (low <= high) {
            int partitionA = low + (high - low) / 2;
            int partitionB = (n + m + 1) / 2 - partitionA;
            int leftA;
            int rightA;
            int leftB;
            int rightB;
            if (partitionA == 0) {
                leftA = Integer.MIN_VALUE;
            } else {
                leftA = A.get(partitionA - 1);
            }
            if (partitionA == n) {
                rightA = Integer.MAX_VALUE;
            } else {
                rightA = A.get(partitionA);
            }
            if (partitionB == 0) {
                leftB = Integer.MIN_VALUE;
            } else {
                leftB = B.get(partitionB - 1);
            }
            if (partitionB == m) {
                rightB = Integer.MAX_VALUE;
            } else {
                rightB = B.get(partitionB);
            }
            if (leftA <= rightB && leftB <= rightA) {
                int leftMax = Math.max(leftA, leftB);
                if ((n + m) % 2 == 1) {
                    return leftMax;
                } else {
                    int rightMin = Math.min(rightA, rightB);
                    return (leftMax + rightMin) / 2.0;
                }
            } else if (leftA > rightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }
        return 0.0;
    }
}
