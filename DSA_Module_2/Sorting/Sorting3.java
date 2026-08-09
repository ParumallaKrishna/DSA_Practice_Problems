package com.scaler.module_2.assignments.DSA_Module_2.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.
Note: You cannot use any extra space
Problem Constraints
1 <= N <= 104
1 <= A[i] <= 104
Input Format
First argument A is an array of integers.
Output Format
Return an array of integers.
Example Input
Input 1: A = [6, 8, 9]
Input 2: A = [2, 4, 7]
Example Output
Output 1: [9, 6, 8]
Output 2: [2, 7, 4]*/
public class Sorting3 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        Collections.sort(A, new FactorComparer());
        return A;
    }
}
class FactorComparer implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2) {
        int c1 = NumFact(o1);
        int c2 = NumFact(o2);
        if (c1 != c2) {
            return Integer.compare(c1, c2); // Compare based on the number of factors
        } else {
            return Integer.compare(o1, o2); // If the number of factors is the same, compare the values
        }
    }
    public static int NumFact(Integer i1)
    {
        int count=0;
        for(int i=1; i<=Math.floor(i1/2); i++)
        {
            if(i1 % i ==0)
            {
                count++;
            }
        }
        return count;
    }
}
