package com.scaler.module_2.assignments.DSA_Module_2.Hashing1;

import java.util.ArrayList;
import java.util.HashMap;

/*You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
Input Format
First argument A is an array of integers.
Output Format
Return an integer.
Example Input
Input 1:
A = [3, 4, 3, 6, 6]
Input 2:
A = [3, 3, 3, 9, 0, 1, 0]
Example Output
Output 1: 1
Output 2: 2*/
public class Hashing8 {
    public int solve(ArrayList<Integer> A) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num :A){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        int count=0;
        ArrayList<Integer> al = new ArrayList<>(hm.values());
        for(int num : al){
            if(num==1){
                count++;
            }
        }
        return count;
    }
}
