package com.scaler.module_2.assignments.DSA_Module_5.Tries_1;

import java.util.ArrayList;

/*We want to make a custom contacts finder applications as part of our college project. The application must perform two types of operations:
Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. This must store B[i] as a new contact in the application.
Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search the application for. It must count the number of contacts starting with B[i].
You have been given sequential add and find operations. You need to perform each operation in order.
And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .
Problem Constraints
1 <= |A| <= 10000
1 <= |length of strings in B| <= 10
Input Format
First argument is the vector A, which denotes the type of query.
Second argument is the vector B, which denotes the string for corresponding query.
Output Format
Return an array of integers, denoting answers for each query of type 1.
Example Input
Input 1: A = [0, 0, 1, 1] B = ["hack", "hacker", "hac", "hak"]
Input 2: A = [0, 1] B = ["abcde", "abc"]
Example Output
Output 1: [2, 0]
Output 2: [1]*/
public class Tries_4 {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }
    public int[] solve(int[] A, String[] B) {
        TrieNode root = new TrieNode();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            String word = B[i];
            TrieNode curr = root;
            if (A[i] == 0) {
                // Add contact
                for (int j = 0; j < word.length(); j++) {
                    int pos = word.charAt(j) - 'a';
                    if (curr.children[pos] == null) {
                        curr.children[pos] = new TrieNode();
                    }
                    curr = curr.children[pos];
                    curr.count++;
                }
            } else {
                // Find prefix count
                boolean found = true;
                for (int j = 0; j < word.length(); j++) {
                    int pos = word.charAt(j) - 'a';
                    if (curr.children[pos] == null) {
                        found = false;
                        break;
                    }
                    curr = curr.children[pos];
                }
                if (found) {
                    result.add(curr.count);
                } else {
                    result.add(0);
                }
            }
        }
        // Convert ArrayList to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
