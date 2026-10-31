package com.scaler.module_2.assignments.DSA_Module_4.two_pointers;
import java.util.ArrayList;
/*Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single integer "-1".
First sub-array means the sub-array for which starting index in minimum.
Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109
Input Format
The first argument given is the integer array A.
The second argument given is integer B.
Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".
Example Input
Input 1: A = [1, 2, 3, 4, 5] B = 5
Input 2: A = [5, 10, 20, 100, 105] B = 110
Example Output
Output 1: [2, 3]
Output 2: [-1]*/
public class TP_1 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0;
        long sum = 0;
        for (int end = 0; end < A.size(); end++) {
            sum += A.get(end);
            while (sum > B && start <= end) {
                sum -= A.get(start);
                start++;
            }
            if (sum == B) {
                for (int i = start; i <= end; i++) {
                    ans.add(A.get(i));
                }
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }
}
