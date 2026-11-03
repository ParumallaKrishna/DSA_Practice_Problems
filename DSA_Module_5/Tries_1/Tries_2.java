package com.scaler.module_2.assignments.DSA_Module_5.Tries_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*There is a dictionary A of N words, and ith word has a unique weight Wi.
Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.
Output the words in decreasing order of their weight.
NOTE: If there is no word that starts with the given prefix output -1.
Problem Constraints
1 <= T <= 5
1 <= N <= 20000
1 <= M <= 10000
1 <= Wi <= 106
1 <= length of any string either in A or B <= 30
Input Format
First line is an integer T denoting the number of test cases.
For each test case,
First line denotes two space seperated integer N and M.
Second line denotes N space seperated strings denoting the words in dictionary.
Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
Fourth line denotes M space seperated integers denoting the prefixes.
Output Format
For every prefix B[i], print the space seperated output on a new line.
NOTE: After every output there should be a space.
Example Input
Input 1:
 1
 6 3
 abcd aecd abaa abef acdcc acbcc
 2 1 3 4 6 5
 ab abc a
Input 2:
 1
 5 3
 aaaa aacd abaa abaa aadcc
 3 4 1 2 6
 aa aba abc
Example Output
Output 1:
 abef abaa abcd
 abcd
 acdcc acbcc abef abaa abcd
Output 2:
 aadcc aacd aaaa
 abaa abaa
 -1 */
public class Tries_2 {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        ArrayList<Integer> top = new ArrayList<>();
    }
    static class Word {
        String word;
        int weight;
        Word(String word, int weight) {
            this.word = word;
            this.weight = weight;
        }
    }
    static TrieNode root;
    static void insert(String word, int index) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (curr.children[pos] == null) {
                curr.children[pos] = new TrieNode();
            }
            curr = curr.children[pos];
            if (curr.top.size() < 5) {
                curr.top.add(index);
            }
        }
    }
    static ArrayList<Integer> search(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if (curr.children[pos] == null) {
                return new ArrayList<>();
            }
            curr = curr.children[pos];
        }
        return curr.top;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Word[] words = new Word[N];
            for (int i = 0; i < N; i++) {
                words[i] = new Word(sc.next(), 0);
            }
            for (int i = 0; i < N; i++) {
                words[i].weight = sc.nextInt();
            }
            String[] prefixes = new String[M];
            for (int i = 0; i < M; i++) {
                prefixes[i] = sc.next();
            }
            // Sort indices by decreasing weight
            Integer[] order = new Integer[N];
            for (int i = 0; i < N; i++) {
                order[i] = i;
            }
            Arrays.sort(order, (a, b) ->
                    Integer.compare(words[b].weight, words[a].weight)
            );
            // Build Trie
            root = new TrieNode();
            for (int i = 0; i < N; i++) {
                insert(words[order[i]].word, order[i]);
            }
            // Answer prefix queries
            for (int i = 0; i < M; i++) {
                ArrayList<Integer> ans = search(prefixes[i]);
                if (ans.isEmpty()) {
                    System.out.print("-1 ");
                } else {

                    for (int index : ans) {
                        System.out.print(words[index].word + " ");
                    }
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
