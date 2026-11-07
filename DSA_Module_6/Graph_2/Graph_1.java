package com.scaler.module_2.assignments.DSA_Module_6.Graph_2;
/*A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.

Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.

All students who know each other are placed in one batch.

Strength of a batch is equal to sum of the strength of all the students in it.

Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.

Find the number of batches selected.

NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.



Problem Constraints

1 <= A <= 105

1 <= M <= 2*105

1 <= B[i] <= 104

1 <= C[i][0], C[i][1] <= A

1 <= D <= 109



Input Format

The first argument given is an integer A.
The second argument given is an integer array B.
The third argument given is a matrix C.
The fourth argument given is an integer D.



Output Format

Return the number of batches selected in IB.



Example Input

Input 1:

 A = 7
 B = [1, 6, 7, 2, 9, 4, 5]
 C = [  [1, 2]
        [2, 3]
       `[5, 6]
        [5, 7]  ]
 D = 12
Input 2:

 A = 5
 B = [1, 2, 3, 4, 5]
 C = [  [1, 5]
        [2, 3]  ]
 D = 6


Example Output

Output 1:

 2
Output 2:

 1
*/
public class Graph_1 {

    int[] parent;
    int[] size;
    long[] strength;

    public int solve(int A, int[] B, int[][] C, int D) {

        parent = new int[A + 1];
        size = new int[A + 1];
        strength = new long[A + 1];

        // Initially, every student belongs to a separate batch
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
            size[i] = 1;
            strength[i] = B[i - 1];
        }

        // Merge students who know each other
        for (int i = 0; i < C.length; i++) {

            int u = C[i][0];
            int v = C[i][1];

            union(u, v);
        }

        // Count batches having strength >= D
        int answer = 0;

        for (int i = 1; i <= A; i++) {

            if (parent[i] == i && strength[i] >= D) {
                answer++;
            }
        }

        return answer;
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

        strength[rootX] += strength[rootY];
    }
}
