package com.scaler.module_2.assignments.DSA_Module_4.HashMap_2;
import java.util.ArrayList;
import java.util.TreeSet;
/*Given a binary string A of size N. There are Q queries given by the 2-D array B of size Q x 2.
Each query has 2 integers :-
First integer denotes the type of query. Type of query can be either 1 or 2.
Second integer denotes index x.
If type = 1, Flip the value at index x.
If type = 2, Find the index of the nearest 1 to the left or right of index x in the array. If there are multiple indices has the same distance from x, return the index with the lower value. If there is no occurrence of 1 in the array, return -1.
Note :
We use 1-based indexing
Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= B[i][0] <= 2
1 <= B[i][1] <= N
Input Format
First argument A is a string.
Second argument B is a 2D array of integers describing the queries.
Output Format
Return an array of integers denoting the answers to each query of type 2.
Example Input
Input 1: A = "10010"
B = [[1, 2]
     [2, 3]]
Input 2: A = "010000100"
B = [[2, 5]
     [1, 7]
     [2, 9]]
Example Output
Output 1: [2]
Output 2: [7, 2]*/
public class HM_3 {
    public ArrayList<Integer> solve(String A, ArrayList<ArrayList<Integer>> B) {
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        // Store positions of all 1's (1-based indexing)
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1') {
                set.add(i + 1);
            }
        }
        // Process queries
        for (int i = 0; i < B.size(); i++) {
            int type = B.get(i).get(0);
            int x = B.get(i).get(1);
            if (type == 1) {
                // Flip operation
                if (set.contains(x)) {
                    set.remove(x);
                } else {
                    set.add(x);
                }
            } else {
                // Find nearest 1 on left and right
                Integer left = set.floor(x);
                Integer right = set.ceiling(x);
                if (left == null && right == null) {
                    result.add(-1);
                }
                else if (left == null) {
                    result.add(right);
                }
                else if (right == null) {
                    result.add(left);
                }
                else {
                    int leftDistance = x - left;
                    int rightDistance = right - x;
                    // If distances are equal, choose smaller index
                    if (leftDistance <= rightDistance) {
                        result.add(left);
                    } else {
                        result.add(right);
                    }
                }
            }
        }
        return result;
    }
}
