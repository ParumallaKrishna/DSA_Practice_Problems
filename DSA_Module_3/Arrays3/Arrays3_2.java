package com.scaler.module_2.assignments.DSA_Module_3.Arrays3;
import java.util.*;
import java.util.ArrayList;

/*Given a collection of intervals, merge all overlapping intervals.
Problem Constraints
1 <= Total number of intervals <= 100000.
Input Format
First argument is a list of intervals.
Output Format
Return the sorted list of intervals after merging all the overlapping intervals.
Example Input
Input 1: [1,3],[2,6],[8,10],[15,18]
Example Output
Output 1: [1,6],[8,10],[15,18]*/
public class Arrays3_2 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            return result;
        }
        // Sort intervals based on start time
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        // Start with the first interval
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {

            Interval current = intervals.get(i);

            // Overlapping interval
            if (current.start <= end) {
                end = Math.max(end, current.end);
            }
            // Non-overlapping interval
            else {
                result.add(new Interval(start, end));

                start = current.start;
                end = current.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));

        return result;
    }
}
 class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
  }
