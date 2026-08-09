package com.scaler.module_2.assignments.DSA_Module_1.Bit_Manipulation;

import java.util.List;

/*Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Problem Constraints
1 <= |A| <= 2000000
0 <= A[i] <= INTMAX
Input Format
The first and only argument of input contains an integer array A.
Output Format
Return a single integer denoting the single element.
Example Input
Input 1: A = [1, 2, 2, 3, 1]
Input 2: A = [1, 2, 2]
Example Output
Output 1: 3
Output 2: 1*/
public class BM3 {
    public int singleNumber(final List<Integer> A) {
        int result=0;
        for(int i =0;i<A.size();i++){
            result =result^A.get(i);
        }
        return result;
    }
}
