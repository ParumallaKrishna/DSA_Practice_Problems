package com.scaler.module_2.assignments.DSA_Module_2.Hashing1;

import java.util.ArrayList;
import java.util.HashSet;

/*Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1, else return 0.
Problem Constraints
1 <= |A| <= 100000
-10^9 <= A[i] <= 10^9
Input Format
The only argument given is the integer array A.
Output Format
Return whether the given array contains a subarray with a sum equal to 0.
Example Input
Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [4, -1, 1]
Example Output
Output 1: 0
Output 2: 1*/
public class Hashing3 {
    public int solve(ArrayList<Integer> A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        HashSet<Long> hs = new HashSet<>();
        long PrefixSum= 0;
        hs.add(PrefixSum);
        for(int sum:A){
            PrefixSum= PrefixSum+sum;
            if(hs.contains(PrefixSum)){
                return 1;
            }else{
                hs.add(PrefixSum);
            }

        }
        return 0;
    }
}
