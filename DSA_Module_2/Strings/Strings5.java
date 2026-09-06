package com.scaler.module_2.assignments.DSA_Module_2.Strings;
import java.util.ArrayList;
/*Given a string A, you are asked to reverse the string and return the reversed string.
Problem Constraints
1 <= |A| <= 105
String A consist only of lowercase characters.
Input Format
First and only argument is a string A.
Output Format
Return a string denoting the reversed string.
Example Input
Input 1:
 A = "scaler"
Input 2:
 A = "academy"
Example Output
Output 1:
 "relacs"
Output 2:
 "ymedaca"*/
public class Strings5 {
    public String solve(String A) {
        ArrayList<Character> result = new ArrayList<>();
        for(char ch:A.toCharArray()){
            result.add(ch);
        }
        int i=0;
        int j=result.size()-1;
        while(i<j){
            Character temp =result.get(i);
            result.set(i,result.get(j));
            result.set(j,temp);
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder(result.size());
        for(char c: result){
            sb.append(c);
        }
        return sb.toString();
    }
}
