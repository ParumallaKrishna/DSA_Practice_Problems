package com.scaler.module_2.assignments.DSA_Module_4.Searching_3;
import java.util.ArrayList;
/*Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
Return the ans % 10000003.
Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106
Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.
Output Format
Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
Example Input
Input 1: A = 2 B = 5 C = [1, 10]
Input 2: A = 10 B = 1 C = [1, 8, 11, 3]
Example Output
Output 1: 50
Output 2: 11*/
public class Searching_3_1 {
    public class Solution {
        public int paint(int A, int B, ArrayList<Integer> C) {
            long low = 0;
            long high = 0;
            for (int i = 0; i < C.size(); i++) {
                low = Math.max(low, C.get(i));
                high += C.get(i);
            }
            long ans = high;
            while (low <= high) {
                long mid = low + (high - low) / 2;
                if (isPossible(C, A, mid)) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            long result = (ans * B) % 10000003;
            return (int) result;
        }
        public boolean isPossible(ArrayList<Integer> C, int A, long mid) {
            int painters = 1;
            long sum = 0;
            for (int i = 0; i < C.size(); i++) {
                if (sum + C.get(i) <= mid) {
                    sum += C.get(i);
                } else {
                    painters++;
                    sum = C.get(i);
                }
                if (painters > A) {
                    return false;
                }
            }
            return true;
        }
    }

}
