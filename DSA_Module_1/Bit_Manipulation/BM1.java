package com.scaler.module_2.assignments.DSA_Module_1.Bit_Manipulation;
/*You are given a number A. You are also given a base B. A is a number on base B.
You are required to convert the number A into its corresponding value in decimal number system.
Problem Constraints
0 <= A <= 109
2 <= B <= 9
Input Format
First argument A is an integer.
Second argument B is an integer.
Output Format
Return an integer.
Example Input
Input 1: A = 1010 B = 2
Input 2: A = 22  B = 3
Example Output
Output 1: 10
Output 2: 8*/
public class BM1 {
    public int solve(int A, int B) {
        int ans=0;
        int power=0;
        while(A>0){
            int rem = A%10;
            ans += rem*Math.pow(B,power);
            power +=1;
            A=A/10;
        }
        return ans;
    }
}
