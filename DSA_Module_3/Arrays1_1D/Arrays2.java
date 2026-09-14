package com.scaler.module_2.assignments.DSA_Module_3.Arrays1_1D;
import java.util.ArrayList;
/*There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
Problem Constraints
1 <= A <= 2 * 105
1 <= L <= R <= A
1 <= P <= 103
0 <= len(B) <= 105
Input Format
The first argument is a single integer A.
The second argument is a 2D integer array B.
Output Format
Return an array(0 based indexing) that stores the total number of coins in each beggars pot.
Example Input
Input 1:- A = 5 B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
Example Output
Output 1:- 10 55 45 25 25*/
public class Arrays2 {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> diff = new ArrayList<>();
        // A + 1 to safely handle R + 1
        for (int i = 0; i <= A; i++) {
            diff.add(0);
        }
        // Apply range updates
        for (ArrayList<Integer> donation : B) {
            int L = donation.get(0);
            int R = donation.get(1);
            int P = donation.get(2);
            // Convert 1-based index to 0-based
            L--;
            R--;
            diff.set(L, diff.get(L) + P);
            if (R + 1 < A) {
                diff.set(R + 1, diff.get(R + 1) - P);
            }
        }
        // Calculate prefix sum
        ArrayList<Integer> ans = new ArrayList<>();
        int current = 0;
        for (int i = 0; i < A; i++) {
            current += diff.get(i);
            ans.add(current);
        }
        return ans;
    }
}
