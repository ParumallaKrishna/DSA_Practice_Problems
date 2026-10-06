package com.scaler.module_2.assignments.DSA_Module_4.Sorting_3;
import java.util.ArrayList;
import java.util.PriorityQueue;
/*You are developing a feature for Zomato that helps users find the nearest restaurants to their current location. It uses GPS to determine the user's location and has access to a database of restaurants, each with its own set of coordinates in a two-dimensional space representing their geographical location on a map. The goal is to identify the "B" closest restaurants to the user, providing a quick and convenient way to choose where to eat.
Given a list of restaurant locations, denoted by A (each represented by its x and y coordinates on a map), and an integer B representing the number of closest restaurants to the user. The user's current location is assumed to be at the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2).
Problem Constraints
1 <= B <= length of the list A <= 105
-105 <= A[i][0] <= 105
-105 <= A[i][1] <= 105
Input Format
The argument given is list A and an integer B.
Output Format
Return the B closest points to the origin (0, 0) in any order.
Example Input
Input 1:
 A = [
       [1, 3],
       [-2, 2]
     ]
 B = 1
Input 2:
 A = [
       [1, -1],
       [2, -1],
       [3, 3],
       [-2, 4]
    ]
 B = 3
Example Output
Output 1:
 [ [-2, 2] ]
Output 2:
 [ [1, -1], [2, -1], [3, 3] ]*/
public class Sorting_3_2 {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<ArrayList<Integer>> maxHeap =
                new PriorityQueue<>(
                        (p1, p2) -> {
                            long d1 = getDistance(p1);
                            long d2 = getDistance(p2);

                            return Long.compare(d2, d1);
                        }
                );
        for (ArrayList<Integer> point : A) {
            if (maxHeap.size() < B) {
                maxHeap.add(point);
            }
            else {
                long newDistance = getDistance(point);
                long maxDistance = getDistance(maxHeap.peek());
                if (newDistance < maxDistance) {
                    maxHeap.poll();
                    maxHeap.add(point);
                }
            }
        }
        ArrayList<ArrayList<Integer>> result =
                new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }
        return result;
    }
    private long getDistance(ArrayList<Integer> point) {
        long x = point.get(0);
        long y = point.get(1);
        return x * x + y * y;
    }
}
