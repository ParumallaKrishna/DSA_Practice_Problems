package com.scaler.module_2.assignments.DSA_Module_6.Greedy;
/*The monetary system in DarkLand is really simple and systematic. The locals-only use coins. The coins come in different values. The values used are:
 1, 5, 25, 125, 625, 3125, 15625, ...
Formally, for each K >= 0 there are coins worth 5K.
Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).
Problem Constraints
1 <= A <= 2×109
Input Format
The only argument given is integer A.
Output Format
Return the smallest number of coins necessary to pay exactly the cost of the item.
Example Input
Input 1: A = 47
Input 2: A = 9
Example Output
Output 1: 7
Output 2: 5
*/
public class Greedy_4 {
    public int solve(int A) {

        int count = 0;

        while (A > 0) {

            int coin = 1;

            // Find the largest power of 5 <= A
            while (coin <= A / 5) {
                coin *= 5;
            }

            // Use as many coins of this denomination as possible
            count += A / coin;

            // Update remaining amount
            A = A % coin;
        }

        return count;
    }
}
