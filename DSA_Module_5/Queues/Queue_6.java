package com.scaler.module_2.assignments.DSA_Module_5.Queues;
import java.util.LinkedList;
import java.util.Queue;
/*Imagine you're a teacher. You ask students to call out a letter one by one. After each letter, you jot down the very first letter that's only been called out once. If all letters have been repeated, you write "#".
Here's a scenario:
A student says "a". It's the first letter. You write "a".
Next, a student says "b", "a" is still unique, so you add "a". Now it's "aa".
A student says "a" again. Now, "b" is the unique one. You add "b", making it "aab".
A student says "b". All letters so far are repeated. You add "#". It becomes "aab#".
A student says "c". "c" is unique. You add "c". The final is "aab#c".
Your task? Given the sequence the students call out A, determine the string on the board.
Problem Constraints
1 <= |A| <= 100000
Input Format
The only argument given is string A.
Output Format
Return a string after processing the stream of lowercase alphabets A.
Example Input
Input 1: A = "abadbc"
Input 2: A = "abcabc"
Example Output
Output 1:"aabbdd"
Output 2: "aaabc#"*/
public class Queue_6 {
    public String solve(String A) {
        int[] freq = new int[26];
        Queue<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            // Update frequency
            freq[ch - 'a']++;
            // Add character to queue
            queue.offer(ch);
            // Remove repeated characters from front
            while (!queue.isEmpty() &&
                    freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            // Append first non-repeating character
            if (queue.isEmpty()) {
                ans.append('#');
            } else {
                ans.append(queue.peek());
            }
        }
        return ans.toString();
    }
}
