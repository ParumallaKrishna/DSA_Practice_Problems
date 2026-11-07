package com.scaler.module_2.assignments.DSA_Module_6.DP_5;

import java.util.ArrayList;

/*Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


Problem Constraints

1 <= length(A), length(B) <= 450



Input Format

The first argument of input contains a string, A.
The second argument of input contains a string, B.



Output Format

Return an integer, representing the minimum number of steps required.



Example Input

Input 1:

 A = "abad"
 B = "abac"
Input 2:

 A = "Anshuman"
 B = "Antihuman


Example Output

Output 1:

 1
Output 2:

 2*/
public class DP_1 {
    public int minDistance(String A, String B) {

        int n = A.length();
        int m = B.length();

        ArrayList<Integer> prev = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();

        // Initialize first row
        for (int j = 0; j <= m; j++) {
            prev.add(j);
            curr.add(0);
        }

        for (int i = 1; i <= n; i++) {

            // Convert first i characters of A to empty string
            curr.set(0, i);

            for (int j = 1; j <= m; j++) {

                if (A.charAt(i - 1) == B.charAt(j - 1)) {

                    curr.set(j, prev.get(j - 1));

                } else {

                    int insert = curr.get(j - 1);
                    int delete = prev.get(j);
                    int replace = prev.get(j - 1);

                    int minOperations = Math.min(
                            insert,
                            Math.min(delete, replace)
                    );

                    curr.set(j, minOperations + 1);
                }
            }

            // Move current row to previous row
            ArrayList<Integer> temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev.get(m);
    }
}
