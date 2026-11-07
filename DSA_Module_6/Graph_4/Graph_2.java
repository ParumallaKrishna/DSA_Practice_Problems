package com.scaler.module_2.assignments.DSA_Module_6.Graph_4;
/*You are given an integer A, the number of vertices of a cycle graph.

The vertices are labelled 0 to A - 1 and the edges join 0 to 1, 1 to 2, and so on up to A - 2 to A - 1, and finally A - 1 back to 0. So the graph is a single closed loop, every vertex has exactly two neighbours, and there are exactly A edges.

Assign a color to every vertex so that no edge joins two vertices of the same color. Such an assignment is called a proper coloring.

Return the smallest number of distinct colors for which a proper coloring of the loop exists.


Problem Constraints

3 <= A <= 109


Input Format

The only argument is the integer A, the number of vertices in the cycle graph.


Output Format

Return a single integer, the minimum number of colors needed to properly color the graph.


Example Input

Input 1:
A = 5
Input 2:
A = 4


Example Output

Output 1:
3
Output 2:
2*/
public class Graph_2 {
    public int solve(int A) {

        if (A % 2 == 0) {
            return 2;
        }

        return 3;
    }
}
