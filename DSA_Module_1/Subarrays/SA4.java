package com.scaler.module_2.assignments.DSA_Module_1.Subarrays;
import java.util.ArrayList;
/*You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array
Note : The order of the subarrays in the resulting 2D array does not matter.
Problem Constraints
1 <= N <= 100
1 <= A[i] <= 105
Input Format
First argument A is an array of integers.
Output Format
Return a 2D array of integers in any order.
Example Input
Input 1:A = [1, 2, 3]
Input 2: A = [5, 2, 1, 4]
Example Output
Output 1: [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Output 2: [[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]*/
public class SA4 {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = A.size();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> subarray = new ArrayList<>();
            for (int j = i; j < n; j++) {
                subarray.add(A.get(j));
                result.add(new ArrayList<>(subarray));
            }
        }
        return result;
    }
}
