package com.scaler.module_2.assignments.DSA_Module_2.Hashing1;

import java.util.ArrayList;
import java.util.HashMap;

/*SCALER organizes a series of contests aimed at helping learners enhance their coding skills. Each learner can participate in multiple contests, and their participation is represented by integers in an array. The goal is to identify how frequently each learner has participated in these contests. This information will help SCALER determine which learners are participating the least, allowing them to provide targeted support and encouragement.
Given an array A that represents the participants of various contests, where each integer corresponds to a specific learner, and an array B containing the learners for whom you want to check participation frequency, your task is to find the frequency of each learner from array B in the array A and return a list containing all these frequencies
Problem Constraints
1 <= |A| <= 105
1 <= |B| <= 105
1 <= A[i] <= 105
1 <= B[i] <= 105
Input Format
First argument A is an array of integers.
Second argument B is an array of integers denoting the queries.
Output Format
Return an array of integers containing the frequency of each learner in B as found in array A.
Example Input
Input 1: A = [1, 2, 1, 1] B = [1, 2]
Input 2: A = [2, 5, 9, 2, 8] B = [3, 2]
Example Output
Output 1: [3, 1]
Output 2: [0, 2]*/
public class Hashing1 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer,Integer> hashmap =new HashMap<>();
        for(int i :A){
            hashmap.put(i,hashmap.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int num:B){
            //int j =B.get(i);
            al.add(hashmap.getOrDefault(num,0));
        }
        return al;
    }
}
