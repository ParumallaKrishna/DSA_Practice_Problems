package com.scaler.module_2.assignments.DSA_Module_2.Hashing1;

import java.util.ArrayList;
import java.util.HashMap;

/*Given an array A of N integers.
Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7
Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109
Input Format
Single argument which is an integer array A.
Output Format
Return an integer.
Example Input
Input 1: A = [1, -1, -2, 2]
Input 2: A = [-1, 2, -1]
Example Output
Output 1: 3
Output 2: 1*/
public class Hashing5 {
    public int solve(ArrayList<Integer> A) {
        HashMap<Long,Integer> hs = new HashMap<>();
        long PrefixSum= 0;
        hs.put(0L,1);
        long count=0;
        for(int sum:A){
            PrefixSum= PrefixSum+sum;
            count =(count+hs.getOrDefault(PrefixSum,0))%1000000007;
            hs.put(PrefixSum,hs.getOrDefault(PrefixSum,0)+1);
        }
        return (int)count;
    }
}
