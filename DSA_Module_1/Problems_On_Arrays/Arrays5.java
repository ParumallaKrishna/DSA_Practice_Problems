package com.scaler.module_2.assignments.DSA_Module_1.Problems_On_Arrays;
import java.util.List;
/*You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.
Note: Read-only array means that the input array should not be modified in the process of solving the problem
Problem Constraints
1 <= N <= 7*105
1 <= A[i] <= 109
Input Format
The only argument is an integer array A.
Output Format
Return an integer.
Example Input
Input 1: [1 2 3 1 1]
Input 2: [1 2 3]
Example Output
Output 1: 1
Output 2: -1*/
public class Arrays5 {
    public int repeatedNumber(final List<Integer> A) {
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;
        // Step 1: Find two possible candidates
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            if (candidate1 == num) {
                count1++;
            }
            else if (candidate2 == num) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
        }
        int n = A.size();
        if (count1 > n / 3) {
            return candidate1;
        }
        if (count2 > n / 3) {
            return candidate2;
        }
        return -1;
    }
}
