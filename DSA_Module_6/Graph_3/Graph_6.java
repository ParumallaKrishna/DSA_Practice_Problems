package com.scaler.module_2.assignments.DSA_Module_6.Graph_3;

import java.util.Arrays;

/*You are the Prime Minister of a country and once you went for a world tour.
After 5 years, when you returned to your country, you were shocked to see the condition of the roads between the cities. So, you plan to repair them, but you cannot afford to spend a lot of money.

The country can be represented as a (N+1) x (M+1) grid, where Country(i, j) is a city.

The cost of repairing a road between (i, j) and (i + 1, j) is A[i]. The cost of repairing a road between (i, j) and (i, j + 1) is B[j].

Return the minimum cost of repairing the roads such that all cities can be visited from city indexed (0, 0).

As the cost can be large, return the cost modulo 109+7.



Problem Constraints

1 <= N, M <= 105

1 <= A[i], B[i] <= 103


Input Format

The first argument will be an integer array, A, of size N.
The second argument will be an integer array, B, of size M.



Output Format

Return an integer representing the minimum possible cost.



Example Input

Input 1:

 A = [1, 1, 1]
 B = [1, 1, 2]
Input 2:

 A = [1, 2, 3]
 B = [4, 5, 6]


Example Output

Output 1:

 16
Output 2:

 39*/
public class Graph_6 {
    public int solve(int[] A, int[] B) {

        long MOD = 1000000007L;

        // Sort both arrays in ascending order
        Arrays.sort(A);
        Arrays.sort(B);

        int i = A.length - 1;
        int j = B.length - 1;

        long horizontalParts = 1;
        long verticalParts = 1;

        long totalCost = 0;

        while (i >= 0 && j >= 0) {

            if (A[i] >= B[j]) {

                // Select horizontal road
                totalCost = (totalCost +
                        (A[i] * verticalParts) % MOD) % MOD;

                horizontalParts++;
                i--;

            } else {

                // Select vertical road
                totalCost = (totalCost +
                        (B[j] * horizontalParts) % MOD) % MOD;

                verticalParts++;
                j--;
            }
        }

        // Remaining horizontal roads
        while (i >= 0) {

            totalCost = (totalCost +
                    (A[i] * verticalParts) % MOD) % MOD;

            horizontalParts++;
            i--;
        }

        // Remaining vertical roads
        while (j >= 0) {

            totalCost = (totalCost +
                    (B[j] * horizontalParts) % MOD) % MOD;

            verticalParts++;
            j--;
        }

        return (int) totalCost;
    }
}
