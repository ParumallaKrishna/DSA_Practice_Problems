package com.scaler.module_2.assignments.DSA_Module_5.Heap_1;

import java.util.Comparator;
import java.util.PriorityQueue;

/*Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.
Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.
Problem Constraints
1 <= N <= 104
0 <= B <= 104
1 <= A[i] <= 104
Input Format
The first argument is an integer array A.
The second argument is an integer B.
Output Format
Return an integer denoting the minimum possible largest element after B operations.
Example Input
Input 1: A = [1, 2, 3, 4]  B = 3
Input 2: A = [5, 1, 4, 2]  B = 5
Example Output
Output 1: 4
Output 2: 5*/
public class Heap_5 {
    public int solve(int[] A, int B) {
        PriorityQueue < Pair > pq = new PriorityQueue(new CustomComp());
        int s = A.length;
        //Let's keep a state array to keep track of the value of every element in the array after K operations.
        //Initially state array will be the same as the inital array.
        int[] state = new int[s];
        for (int i = 0; i < s; i++){
            state[i] = A[i];
        }
        //Consider a min heap. And initially push the next state of every element in the heap.
        //Note that you need to keep track of the indices of every element in the heap, present in the initial array.
        for (int i = 0; i < s; i++){
            pq.offer(new Pair(2 * A[i], i));
        }
        while(B-- > 0) {
            Pair top = pq.poll();
            //Pick the top element, and change the state of that element, in the state array.
            state[top.ss] = top.ff;
            pq.offer(new Pair(A[top.ss] + top.ff, top.ss));
        }
        int mx = state[0];
        for (int i = 0; i < s; i++) mx = Math.max(mx, state[i]);
        return mx;
    }
}
class Pair {
    int ff;
    int ss;
    public Pair(int c, int d) {
        this.ff = c;
        this.ss = d;
    }
}
class CustomComp implements Comparator< Pair > {
    @Override
    public int compare(Pair a, Pair b) {
        return a.ff - b.ff;
    }
}
