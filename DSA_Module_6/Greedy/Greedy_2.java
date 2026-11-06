package com.scaler.module_2.assignments.DSA_Module_6.Greedy;

import java.util.Arrays;

/*There are N jobs to be done, but you can do only one job at a time.
Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
Return the maximum number of jobs you can finish.
Problem Constraints
1 <= N <= 105
1 <= A[i] < B[i] <= 109
Input Format
The first argument is an integer array A of size N, denoting the start time of the jobs.
The second argument is an integer array B of size N, denoting the finish time of the jobs.
Output Format
Return an integer denoting the maximum number of jobs you can finish.
Example Input
Input 1: A = [1, 5, 7, 1] B = [7, 8, 8, 8]
Input 2: A = [3, 2, 6] B = [9, 8, 9]
Example Output
Output 1: 2
Output 2: 1
*/
public class Greedy_2 {
    public int solve(int[] A, int[] B) {

        int n = A.length;

        // Store start and finish times together
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = A[i];
            jobs[i][1] = B[i];
        }

        // Sort jobs by finish time
        Arrays.sort(jobs, (x, y) -> Integer.compare(x[1], y[1]));

        int count = 0;
        int lastFinish = 0;

        for (int i = 0; i < n; i++) {

            // Select job if it does not overlap
            if (jobs[i][0] >= lastFinish) {

                count++;
                lastFinish = jobs[i][1];
            }
        }

        return count;
    }
}
