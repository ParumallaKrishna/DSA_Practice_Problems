package com.scaler.module_2.assignments.DSA_Module_1.Bit_Manipulation;
/*Given a decimal number A and a base B, convert it into its equivalent number in base B.
Problem Constraints
0 <= A <= 512
2 <= B <= 10
Input Format
The first argument will be decimal number A.
The second argument will be base B.
Output Format
Return the conversion of A in base B.
Example Input
Input 1: A = 4 B = 3
Input 2: A = 4 B = 2
Example Output
Output 1: 11
Output 2: 100*/
public class BM2 {
    public int DecimalToAnyBase(int A, int B) {
        int ans=0;
        int power =1;
        while(A>0){
            int rem = A%B;
            ans +=rem*power;
            power *=10;
            A =A/B;

        }
        return ans;
    }
}
