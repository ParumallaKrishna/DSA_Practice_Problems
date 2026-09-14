package com.scaler.module_2.assignments.DSA_Module_4.Sorting_1;

import java.util.ArrayList;
import java.util.List;

/*Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
Note: A linear time complexity is expected and you should avoid use of any library function.
Problem Constraints
-2×109 <= A[i], B[i] <= 2×109
1 <= |A|, |B| <= 5×104
Input Format
First Argument is a 1-D array representing  A.
Second Argument is also a 1-D array representing B.
Output Format
Return a 1-D vector which you got after merging A and B.
Example Input
Input 1: A = [4, 7, 9] B = [2, 11, 19]
Input 2: A = [1] B = [2]
Example Output
Output 1: [2, 4, 7, 9, 11, 19]
Output 2: [1, 2]*/
public class Sorting1 {
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> c =new ArrayList<Integer>();
        int i=0;
        int j=0;
        int k=0;
        while(i<A.size() && j<B.size()){
            if(A.get(i)<B.get(j)){
                c.add(A.get(i));
                i++;
                k++;
            }
            else{
                c.add(B.get(j));
                j++;
                k++;
            }
        }
        while(i<A.size()){
            c.add(A.get(i));
            i++;
            k++;
        }
        while(j<B.size()){
            c.add(B.get(j));
            j++;
            k++;
        }
        return c;
    }
}
