package com.scaler.module_2.assignments.DSA_Module_4.two_pointers;

import java.util.ArrayList;

/*Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9
Input Format
The first argument given is the integer array A.
The second argument given is integer B.
Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).
Example Input
Input 1: A = [1, 1, 1] B = 2
Input 2: A = [1, 5, 7, 10] B = 8
Example Output
Output 1: 3
Output 2: 1*/
public class TP_4 {
    public int solve(ArrayList<Integer> A, int B) {
        int mod = 1000000007;
        int i = 0;
        int j = A.size() - 1;
        long count = 0;
        while (i < j) {
            long sum = (long) A.get(i) + A.get(j);
            if (sum == B) {
                // Duplicate values at both ends
                if (A.get(i).equals(A.get(j))) {
                    long n = j - i + 1;
                    count += (n * (n - 1)) / 2;
                    count %= mod;
                    break;
                }
                int leftValue = A.get(i);
                int rightValue = A.get(j);
                long leftCount = 0;
                long rightCount = 0;
                while (i < j && A.get(i) == leftValue) {
                    leftCount++;
                    i++;
                }
                while (j >= i && A.get(j) == rightValue) {
                    rightCount++;
                    j--;
                }
                count += leftCount * rightCount;
                count %= mod;
            } else if (sum < B) {
                i++;
            } else {
                j--;
            }
        }
        return (int) (count % mod);
    }
}
