package com.scaler.module_2.assignments.DSA_Module_1.Carry_Farword;

import java.util.ArrayList;

/*A wire connects N light bulbs.
Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
You can press the same switch multiple times.
Note: 0 represents the bulb is off and 1 represents the bulb is on.
Problem Constraints
0 <= N <= 5×105
0 <= A[i] <= 1
Input Format
The first and the only argument contains an integer array A, of size N.
Output Format
Return an integer representing the minimum number of switches required.
Example Input
Input 1: A = [0, 1, 0, 1]
Input 2: A = [1, 1, 1, 1]
Example Output
Output 1: 4
Output 2: 0*/
public class CF7 {
    public int solve(ArrayList<Integer> A) {
        int count = 0;
        int flip = 0;
        for (int i = 0; i < A.size(); i++) {
            int current = A.get(i);
            // If previous switches flipped the state
            if (flip % 2 == 1) {
                current = 1 - current;
            }
            // If bulb is OFF, we must press this switch
            if (current == 0) {
                count++;
                flip++;
            }
        }
        return count;
    }
}
