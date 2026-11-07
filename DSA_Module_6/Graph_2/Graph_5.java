package com.scaler.module_2.assignments.DSA_Module_6.Graph_2;
/*The legendary Farmer John is throwing a huge party, and animals from all over the world are hanging out at his house. His guests are hungry, so he instructs his cow Bessie to bring out the snacks! Moo!

There are A snacks flavors, numbered with integers 1,2,…,A. Bessie has A snacks, one snack of each flavor. There are M guests and every guest has exactly two favorite flavors. The procedure for eating snacks will go as follows:

First, Bessie will line up the guests in some way.
Each guest in their turn will eat all remaining snacks of their favorite flavor. In case no favorite flavors are present when a guest goes up, they become very sad.
Help Bessie to minimize the number of sad guests by lining the guests in an optimal way.



Problem Constraints

2 <= A <= 100000
1 <= M <= 100000
1 <= B[i][0] , B[i][1] <= A
B[i][0] != B[i][1]



Input Format

First argument of input contains a single integer A.
Second argument of input contains a M x 2 integer matrix B denoting favorite flavors of each guest.



Output Format

Return a single integer denoting the ,minimum possible number of sad guests.



Example Input

Input 1:

 A = 5
 B = [
       [1, 2],
       [4, 3],
       [1, 4],
       [3, 4]
     ]
Input 2:

 A = 6
 B = [
       [2, 3],
       [2, 1],
       [3, 4],
       [6, 5],
       [4, 5]
     ]


Example Output

Output 1:

 1
Output 2:

 0*/
public class Graph_5 {
    int[] parent;
    int[] size;

    public int solve(int A, int[][] B) {

        parent = new int[A + 1];
        size = new int[A + 1];

        // Initialize DSU
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int components = A;

        // Process every guest's favorite flavors
        for (int i = 0; i < B.length; i++) {

            int u = B[i][0];
            int v = B[i][1];

            int rootU = find(u);
            int rootV = find(v);

            // Merge different components
            if (rootU != rootV) {

                union(rootU, rootV);

                components--;
            }
        }

        // Minimum number of sad guests
        return B.length - A + components;
    }

    // Find with path compression
    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Union by size
    private void union(int rootU, int rootV) {

        if (size[rootU] < size[rootV]) {
            int temp = rootU;
            rootU = rootV;
            rootV = temp;
        }

        parent[rootV] = rootU;
        size[rootU] += size[rootV];
    }
}
