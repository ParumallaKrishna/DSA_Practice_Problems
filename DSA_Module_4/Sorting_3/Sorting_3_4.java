package com.scaler.module_2.assignments.DSA_Module_4.Sorting_3;
import java.util.*;
/*Given an array A of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.
Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109
Input Format
The first argument is an array of integers.
Output Format
Return a string representing the largest number.
Example Input
Input 1:
 A = [3, 30, 34, 5, 9]
Input 2:
 A = [2, 3, 9, 0]
Example Output
Output 1:
 "9534330"
Output 2:
 "9320"*/
public class Sorting_3_4 {
    public String largestNumber(ArrayList<Integer> A) {
        ArrayList<String> arr = new ArrayList<>();
        // Convert integers to strings
        for (int i = 0; i < A.size(); i++) {
            arr.add(String.valueOf(A.get(i)));
        }
        // Custom sorting
        Collections.sort(arr, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        // If largest number is 0,
        // all numbers are zero
        if (arr.get(0).equals("0")) {
            return "0";
        }
        // Build answer
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            ans.append(arr.get(i));
        }
        return ans.toString();
    }
}
