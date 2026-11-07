package com.scaler.module_2.assignments.DSA_Module_6.Graph_1;
/*You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
Problem Constraints

1 <= N <= 100000
Input Format

First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format

Return 1 if reachable, 0 otherwise.



Example Input

Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output

Output 1:

 0
Output 2:

 1
*/
public class Graph_3 {
    public int solve(int[] A, final int B, final int C) {

        int current = B;

        while (current != C) {

            // Reached root town without finding C
            if (current == 1) {
                return 0;
            }

            current = A[current - 1];
        }

        return 1;
    }
}
