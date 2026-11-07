package com.scaler.module_2.assignments.DSA_Module_6.DP_4;

import java.util.ArrayList;

/*You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).


Problem Constraints

1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000



Input Format

First argument is an integer array A representing the set.
Second argument is an integer B.



Output Format

Return an integer denoting the number of ways.



Example Input

Input 1:

 A = [1, 2, 3]
 B = 4
Input 2:

 A = [10]
 B = 10


Example Output

Output 1:

 4
Output 2:

 1*/
public class DP_3 {
    public int coinchange2(int[] A, int B) {

        int MOD = 1000007;

        ArrayList<Long> dp = new ArrayList<>();

        for (int i = 0; i <= B; i++) {
            dp.add(0L);
        }

        dp.set(0, 1L);

        for (int coin : A) {

            for (int sum = coin; sum <= B; sum++) {

                long ways = (dp.get(sum) + dp.get(sum - coin)) % MOD;

                dp.set(sum, ways);
            }
        }

        return dp.get(B).intValue();
    }
}
