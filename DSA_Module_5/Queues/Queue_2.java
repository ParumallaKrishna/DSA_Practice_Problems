package com.scaler.module_2.assignments.DSA_Module_5.Queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*Imagine you're an ice cream truck driver in a beachside town. The beach is divided into several sections, and each section has varying numbers of beachgoers wanting ice cream given by the array of integers A.
For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of potential customers in each section: [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the first section, 12 in the second, and so on.
You can only stop your truck in B consecutive sections at a time because of parking restrictions. To maximize sales, you want to park where the most customers are clustered together.
For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve the most customers. Return an array C, where C[i] is the busiest section in each of the B consecutive sections. Refer to the given example for clarity.
NOTE: If B > length of the array, return 1 element with the max of the array.
Problem Constraints
1 <= |A|, B <= 106
Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return an array C, where C[i] is the maximum value from A[i] to A[i+B-1].
Example Input
Input 1: A = [1, 3, -1, -3, 5, 3, 6, 7] B = 3
Input 2: A = [1, 2, 3, 4, 2, 7, 1, 3, 6] B = 6
Example Output
Output 1: [3, 3, 5, 5, 6, 7]
Output 2: [7, 7, 7, 7]*/
public class Queue_2 {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int n = A.size();
        // If window size is greater than array size
        if (B >= n) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, A.get(i));
            }
            ans.add(max);
            return ans;
        }
        for (int i = 0; i < n; i++) {
            // Remove indices outside the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - B) {
                dq.pollFirst();
            }
            // Remove smaller elements from the back
            while (!dq.isEmpty() &&
                    A.get(dq.peekLast()) <= A.get(i)) {
                dq.pollLast();
            }
            // Add current index
            dq.offerLast(i);
            // Store maximum once first window is completed
            if (i >= B - 1) {
                ans.add(A.get(dq.peekFirst()));
            }
        }
        return ans;
    }
}
