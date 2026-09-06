package com.scaler.module_2.assignments.DSA_Module_2.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/*You are given a string A of size N consisting of lowercase alphabets.
You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
Find the minimum number of distinct characters in the resulting string.
Problem Constraints
1 <= N <= 100000
0 <= B <= N
Input Format
The first argument is a string A.
The second argument is an integer B.
Output Format
Return an integer denoting the minimum number of distinct characters in the string.
Example Input
A = "abcabbccd"
B = 3
Example Output
2*/
public class Strings11 {
    public int solve(String A, int B) {
        if(A.length()==1){
            return 1;
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch:A.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer> al = new ArrayList<>(hm.values());
        Collections.sort(al);
        int distinctCount=al.size();
        for(int a :al){
            if(B>=a){
                B=B-a;
                distinctCount--;
            }
            else {
                break;
            }
        }
        return distinctCount;
    }
}
