package com.scaler.module_2.assignments.DSA_Module_6.Graph_2;
/*You are the trainer of a gym and there are A people who come to your gym.

Some of them are friends because they walk together, and some of them are friends because they talk together.
But people become possessive about each other, so a person cannot walk with one friend and talk with another. Although he can walk with two or more people or talk with two or more people.

You being the trainer, decided to suggest each one of the 2 possible diets. But friends, being friends will always have the same diet as all the other friends are having.

Find and return the number of ways you can suggest each of them a diet.

As the number of ways can be huge, return the answer modulo 109+7.

NOTE: If there is any person who walks with one person and talks with the another person, then you may return 0.



Problem Constraints

1 <= A, N, M <= 105

1 <= B[i][0], B[i][1], C[i][0], C[i][1] <= A



Input Format

The first argument contains an integer A, representing the number of people.
The second argument contains a 2-D integer array B of size N x 2, where B[i][0] and B[i][1] are friends because they walk together.
The third argument contains a 2-D integer array C of size M x 2, where C[i][0] and C[i][1] are friends because they talk together.



Output Format

Return an integer representing the number of ways to suggest one of the two diets to the people.



Example Input

Input 1:

 A = 4
 B = [
       [1, 2]
     ]
 C = [
       [3, 4]
     ]
Input 2:

 A = 3
 B = [
       [1, 2]
     ]
 C = [
       [1, 3]
     ]


Example Output

Output 1:

 4
Output 2:

 0*/
public class Graph_4 {
    int[] parent;
    int[] size;

    static final int MOD = 1000000007;

    public int solve(int A, int[][] B, int[][] C) {

        parent = new int[A + 1];
        size = new int[A + 1];

        boolean[] walk = new boolean[A + 1];
        boolean[] talk = new boolean[A + 1];

        // Initialize DSU
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Process walking relationships
        for (int i = 0; i < B.length; i++) {

            int u = B[i][0];
            int v = B[i][1];

            walk[u] = true;
            walk[v] = true;

            union(u, v);
        }

        // Process talking relationships
        for (int i = 0; i < C.length; i++) {

            int u = C[i][0];
            int v = C[i][1];

            // A person cannot walk with one person
            // and talk with another person
            if (walk[u] || walk[v]) {
                return 0;
            }

            talk[u] = true;
            talk[v] = true;

            union(u, v);
        }

        // Count connected components
        int components = 0;

        for (int i = 1; i <= A; i++) {
            if (find(i) == i) {
                components++;
            }
        }

        // Calculate 2^components % MOD
        long answer = 1;

        for (int i = 0; i < components; i++) {
            answer = (answer * 2) % MOD;
        }

        return (int) answer;
    }

    // Find with path compression
    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Union by size
    private void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (size[rootX] < size[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parent[rootY] = rootX;
        size[rootX] += size[rootY];
    }
}
