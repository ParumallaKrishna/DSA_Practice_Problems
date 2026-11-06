package com.scaler.module_2.assignments.DSA_Module_6.Greedy;

import java.util.Arrays;

/*N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.
The positions of Mice are denoted by array A, and the position of holes is denoted by array B.
A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consume 1 minute.
Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
Problem Constraints
1 <= N <= 105
-109 <= A[i], B[i] <= 109
Input Format
The first argument is an integer array A.
The second argument is an integer array B.
Output Format
Return an integer denoting the minimum time when the last nouse gets inside the holes.
Example Input
Input 1: A = [-4, 2, 3] B = [0, -2, 4]
Input 2: A = [-2] B = [-6]
Example Output
Output 1: 2
Output 2: 4*/
public class Greedy_5 {
    public int mice(int[] A, int[] B) {

    Arrays.sort(A);
    Arrays.sort(B);

    int maxTime = 0;

    for (int i = 0; i < A.length; i++) {

        int time = Math.abs(A[i] - B[i]);

        maxTime = Math.max(maxTime, time);
    }

    return maxTime;
}
}
