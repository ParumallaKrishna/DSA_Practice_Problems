package com.scaler.module_2.assignments.DSA_Module_6.Greedy;

import java.util.ArrayList;

/*There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.
In one jump a person can move to the adjacent seat (if available).
NOTE: 1. Return your answer modulo 107 + 3.
Problem Constraints
1 <= N <= 1000000
A[i] = 'x' or '.'
Input Format
The first and only argument is a string A of size N.
Output Format
Return an integer denoting the minimum number of jumps required.
Example Input
Input 1: A = "....x..xx...x.."
Input 2: A = "....xxx"
Example Output
Output 1: 5
Output 2: 0*/
public class Greedy_6 {
    public int seats(String A) {

        int MOD = 10000003;

        ArrayList<Integer> positions = new ArrayList<>();

        // Store positions of occupied seats
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                positions.add(i);
            }
        }

        int n = positions.size();

        // No movement required
        if (n <= 1) {
            return 0;
        }

        // Find median occupied position
        int median = n / 2;
        int medianPosition = positions.get(median);

        long jumps = 0;

        // Move people to consecutive seats around the median
        for (int i = 0; i < n; i++) {

            int targetPosition = medianPosition - median + i;

            jumps += Math.abs(positions.get(i) - targetPosition);
            jumps %= MOD;
        }

        return (int) jumps;
    }

}
