package com.scaler.module_2.assignments.DSA_Module_6.Backtracking_2;

import java.util.ArrayList;
import java.util.Collections;

/*Given a string A, partition A such that every string of the partition is a palindrome.
Return all possible palindrome partitioning of A.
Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
(len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
Problem Constraints
1 <= len(A) <= 15
Input Format
First argument is a string A of lowercase characters.
Output Format
Return a list of all possible palindrome partitioning of s.
Example Input
Input 1:
A = "aab"
Input 2:
A = "a"
Example Output
Output 1:
 [
    ["a","a","b"]
    ["aa","b"],
  ]
Output 2:
 [
    ["a"]
  ]*/
public class BT_4 {
    ArrayList<ArrayList<String>> result;

    public ArrayList<ArrayList<String>> partition(String a) {

        result = new ArrayList<>();

        ArrayList<String> current = new ArrayList<>();

        generate(a, 0, current);

        // Sort according to substring lengths
        Collections.sort(result, (list1, list2) -> {

            int size = Math.min(list1.size(), list2.size());

            for (int i = 0; i < size; i++) {

                if (list1.get(i).length() != list2.get(i).length()) {
                    return Integer.compare(
                            list1.get(i).length(),
                            list2.get(i).length()
                    );
                }
            }

            return Integer.compare(list1.size(), list2.size());
        });

        return result;
    }

    private void generate(String a, int start,
                          ArrayList<String> current) {

        // Entire string is partitioned
        if (start == a.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < a.length(); end++) {

            String substring = a.substring(start, end + 1);

            if (isPalindrome(substring)) {

                current.add(substring);

                generate(a, end + 1, current);

                // Backtracking
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
