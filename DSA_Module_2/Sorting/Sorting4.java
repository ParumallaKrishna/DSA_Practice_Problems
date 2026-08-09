package com.scaler.module_2.assignments.DSA_Module_2.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
Input 1: A = [3, 30, 34, 5, 9]
Input 2: A = [2, 3, 9, 0]
Example Output
Output 1: "9534330"
Output 2: "9320"*/
public class Sorting4 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
//boundary problem. if all the numbers in the array are 0 just return 0
        if(A.stream().mapToInt(Integer::intValue).sum() == 0){
            return "0";
        }
// using Java Streams we are mapping each integer to its string value and collecting them in a new array
        ArrayList<String> list = A.stream().map(i -> String.valueOf(i)).collect(Collectors.toCollection(ArrayList::new));
//Using inbuilt sort with custom comparator.
        Collections.sort(list,(i, j) -> -1*Long.compare(Long.parseLong(i+j),Long.parseLong(j+i)));
        // System.out.println(list);
// as they are arranged in required order, join them with a delimitter.
        return String.join("",list);
    }
}
