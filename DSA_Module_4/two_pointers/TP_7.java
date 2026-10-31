package com.scaler.module_2.assignments.DSA_Module_4.two_pointers;
import java.util.ArrayList;
import java.util.Collections;
/*Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
Assume that there will only be one solution.
Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108
Input Format
First argument is an integer array A of size N.
Second argument is an integer B denoting the sum you need to get close to.
Output Format
Return a single integer denoting the sum of three integers which is closest to B.
Example Input
Input 1: A = [-1, 2, 1, -4] B = 1
Input 2: A = [1, 2, 3] B = 6
Example Output
Output 1: 2
Output 2: 6*/
public class TP_7 {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        int closestSum = A.get(0) + A.get(1) + A.get(2);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = A.get(i) + A.get(left) + A.get(right);
                if (Math.abs(sum - B) < Math.abs(closestSum - B)) {
                    closestSum = sum;
                }
                if (sum == B) {
                    return sum;
                }
                else if (sum < B) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
