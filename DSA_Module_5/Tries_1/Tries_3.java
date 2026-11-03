package com.scaler.module_2.assignments.DSA_Module_5.Tries_1;
/*Given a list of N words, find the shortest unique prefix to represent each word in the list.
NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
Problem Constraints
1 <= Sum of length of all words <= 106
Input Format
First and only argument is a string array of size N.
Output Format
Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.
Example Input
Input 1: A = ["zebra", "dog", "duck", "dove"]
Input 2: A = ["apple", "ball", "cat"]
Example Output
Output 1: ["z", "dog", "du", "dov"]
Output 2: ["a", "b", "c"]*/
public class Tries_3 {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }
    static TrieNode root;
    static void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (curr.children[pos] == null) {
                curr.children[pos] = new TrieNode();
            }
            curr = curr.children[pos];
            curr.count++;
        }
    }
    static String findPrefix(String word) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            curr = curr.children[pos];
            prefix.append(word.charAt(i));
            if (curr.count == 1) {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }
    public String[] prefix(String[] A) {
        root = new TrieNode();
        // Step 1: Insert all words
        for (int i = 0; i < A.length; i++) {
            insert(A[i]);
        }
        // Step 2: Find shortest unique prefixes
        String[] ans = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            ans[i] = findPrefix(A[i]);
        }
        return ans;
    }
}
