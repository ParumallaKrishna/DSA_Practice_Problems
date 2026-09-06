package com.scaler.module_2.assignments.DSA_Module_2.Recursion_1;
/*You are given an integer A, print 1 to A using using recursion.
Note :- After printing all the numbers from 1 to A, print a new line.
Problem Constraints
1 <= A <= 104
Input Format
First argument A is an integer.
Output Format
Print A space-separated integers 1 to A.
Note: There should be exactly one space after each integer. After printing all the integers, print a new line
Example Input
Input 1: A = 10
Input 2: A = 5
Example Output
Output 1: 1 2 3 4 5 6 7 8 9 10
Output 2: 1 2 3 4 5 */
public class Recursion4 {
    public void solve(int A) {
        printNumber(1,A);
        System.out.println();
    }
    void printNumber(int start, int end){
        if(start>end){
            return;
        }
        System.out.print(start+" ");
        printNumber(start+1,end);
    }
}
