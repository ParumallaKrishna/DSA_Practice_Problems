package com.scaler.module_2.assignments.DSA_Module_2.Bit_Manipulation2;
/*Alex has a cat named Boomer. He decides to put his cat to the test for eternity.
He starts on day 1 with one stash of food unit, every next day, the stash doubles.
If Boomer is well behaved during a particular day, only then she receives food worth equal to the stash produced on that day.
Boomer receives a net worth of A units of food. What is the number of days she received the stash?
Problem Constraints
1 <= A <= 231-1
Input Format
First and only argument is an integer A.
Output Format
Return an integer denoting the number of days Boomer was well behaved.
Example Input
Input 1: A = 5
Input 2: A = 8
Example Output
Output 1: 2
Output 2: 1*/
public class BM8 {
    public int solve(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                count++;
            }
            A = A >> 1;
        }
        return count;
    }
}
