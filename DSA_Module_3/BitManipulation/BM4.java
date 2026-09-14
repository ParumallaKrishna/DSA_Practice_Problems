package com.scaler.module_2.assignments.DSA_Module_3.BitManipulation;
import java.util.List;
/*Given an array of integers, every element appears thrice except for one, which occurs once.
Find that element that does not appear thrice.
NOTE: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
Problem Constraints
2 <= |A| <= 5*106
0 <= A[i] <= INTMAX
Input Format
First and only argument of input contains an integer array A.
Output Format
Return a single integer.
Example Input
Input 1: A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2: A = [0, 0, 0, 1]
Example Output
Output 1: 4
Output 2: 1*/
public class BM4 {
    public int singleNumber(final List<Integer> A) {
        int ans = 0;
        // INTMAX is positive, so bits 0 to 30 are enough
        for (int bit = 0; bit <= 30; bit++) {
            int count = 0;
            for (int i = 0; i < A.size(); i++) {
                if ((A.get(i) & (1 << bit)) != 0) {
                    count++;
                }
            }
            // If count is not divisible by 3,
            // this bit belongs to the unique number
            if (count % 3 != 0) {
                ans = ans | (1 << bit);
            }
        }
        return ans;
    }
}
