package com.scaler.module_2.assignments.DSA_Module_2.Bit_Manipulation2;
/*Write a function that takes an integer and returns the number of 1 bits present in its binary representation.
Problem Constraints
1 <= A <= 109
Input Format
First and only argument contains integer A
Output Format
Return an integer
Example Input
Input 1: 11
Input 2: 6
Example Output
Output 1: 3
Output 2: 2*/
public class BM2 {
    public int numSetBits(int A) {
        int count =0;
        for(int i=0;i<32;i++){
            if(((A>>i)&1)==1)
                count++;
        }
        return count;
    }
}
