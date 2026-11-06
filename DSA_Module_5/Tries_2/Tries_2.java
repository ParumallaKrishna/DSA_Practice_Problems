package com.scaler.module_2.assignments.DSA_Module_5.Tries_2;
/*Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.
NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.
Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 109
Input Format
First and only argument is an integer array A.
Output Format
Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.
Example Input
Input 1: A = [1, 4, 3]
Input 2: A = [8]
Example Output
Output 1: [2, 3]
Output 2: [1, 1]*/
public class Tries_2 {
    class Node {
        Node[] child = new Node[2];
        int index = -1;
    }
    Node root;
    void insert(int num, int index) {
        Node curr = root;
        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            if (curr.child[b] == null) {
                curr.child[b] = new Node();
            }
            curr = curr.child[b];
        }
        curr.index = index;
    }
    int query(int num) {
        Node curr = root;
        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            if (curr.child[1 - b] != null) {
                curr = curr.child[1 - b];
            } else {
                curr = curr.child[b];
            }
        }
        return curr.index;
    }
    public int[] solve(int[] A) {
        root = new Node();
        int prefixXor = 0;
        int[] prefix = new int[A.length + 1];
        int maxXor = -1;
        int bestStart = 1;
        int bestEnd = 1;
        int bestLength = Integer.MAX_VALUE;
        insert(0, 0);
        for (int i = 1; i <= A.length; i++) {
            prefixXor ^= A[i - 1];
            prefix[i] = prefixXor;
            int j = query(prefixXor);
            int currentXor = prefixXor ^ prefix[j];
            int start = j + 1;
            int end = i;
            int length = end - start + 1;
            if (currentXor > maxXor ||
                    (currentXor == maxXor && length < bestLength) ||
                    (currentXor == maxXor && length == bestLength &&
                            start < bestStart)) {
                maxXor = currentXor;
                bestStart = start;
                bestEnd = end;
                bestLength = length;
            }
            insert(prefixXor, i);
        }
        return new int[]{bestStart, bestEnd};
    }
}
