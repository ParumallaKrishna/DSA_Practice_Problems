package com.scaler.module_2.assignments.DSA_Module_2.Hashing1;

import java.util.ArrayList;
import java.util.HashMap;

/*Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
If there is no repeating element, return -1.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
Input Format
The first and only argument is an integer array A of size N.
Output Format
Return an integer denoting the first repeating element.
Example Input
Input 1: A = [10, 5, 3, 4, 3, 5, 6]
Input 2: A = [6, 10, 5, 4, 9, 120]
Example Output
Output 1: 5
Output 2: -1*/
public class Hashing2 {
    public int solve(ArrayList<Integer> A) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:A){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for(int num1:A){
            if(hm.getOrDefault(num1,0)>1){
                return num1;
            }
        }
        return -1;
    }
}
