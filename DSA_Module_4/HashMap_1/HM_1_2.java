package com.scaler.module_2.assignments.DSA_Module_4.HashMap_1;
import java.util.HashMap;
import java.util.List;
/*Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
Problem Constraints
1 <= |A| <= 105
Input Format
The first and only argument is an integer array A.
Output Format
Return one integer corresponding to the minimum possible distance between a special pair.
Example Input
Input 1: A = [7, 1, 3, 4, 1, 7]
Input 2: A = [1, 1]
Example Output
Output 1: 3
Output 2: 1*/
public class HM_1_2 {
    public int solve(List<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            if (map.containsKey(num)) {
                int previousIndex = map.get(num);
                int distance = i - previousIndex;
                minDistance = Math.min(minDistance, distance);
            }
            map.put(num, i);
        }
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance;
    }
}
