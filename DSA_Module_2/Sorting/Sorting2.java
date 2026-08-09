package com.scaler.module_2.assignments.DSA_Module_2.Sorting;

import java.util.ArrayList;
import java.util.Collections;

/*Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
Problem Constraints
1 <= |A| <= 2*105
-108 <= A[i] <= 108
Input Format
First and only argument is an integer array A.
Output Format
Return 1 if any such integer p is present else, return -1.
Example Input
Input 1: A = [3, 2, 1, 3]
Input 2: A = [1, 1, 3, 3]
Example Output
Output 1: 1
Output 2: -1*/
public class Sorting2 {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int ans = 0;
        //int countSmaller=0;
        if(A.get(A.size()-1)==0){ans=ans+1;}
        for(int i=0;i<A.size()-1;i++){
            if(((A.size()-1)-i==A.get(i)) && (A.get(i)!=A.get(i+1))){
                ans++;
            }
        }
        if(ans>0){
            return 1;
        }
        else{
            return -1;
        }
    }
}
