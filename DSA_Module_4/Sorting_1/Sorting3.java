package com.scaler.module_2.assignments.DSA_Module_4.Sorting_1;
import java.util.ArrayList;
import java.util.List;
/*Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
Problem Constraints
1 <= length of the array <= 105
1 <= A[i] <= 109
Input Format
The only argument given is the integer array A.
Output Format
Return the number of inversions of A modulo (109 + 7).
Example Input
Input 1: A = [1, 3, 2]
Input 2: A = [3, 4, 1, 2]
Example Output
Output 1: 1
Output 2: 4*/
public class Sorting3 {
    static final long MOD = 1000000007L;
    public int solve(List<Integer> A) {
        ArrayList<Integer> arr = new ArrayList<>(A);
        return (int) mergeSort(arr, 0, arr.size() - 1);
    }
    private long mergeSort(ArrayList<Integer> arr, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        long count = 0;
        // Count inversions in left half
        count += mergeSort(arr, low, mid);
        // Count inversions in right half
        count += mergeSort(arr, mid + 1, high);
        // Count inversions while merging
        count += merge(arr, low, mid, high);
        return count % MOD;
    }
    private long merge(ArrayList<Integer> arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = low;
        int j = mid + 1;
        long count = 0;
        while (i <= mid && j <= high) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i));
                i++;
            } else {
                // arr[i] > arr[j]
                temp.add(arr.get(j));
                j++;
                // All remaining elements in left half
                // will form inversions with arr[j-1]
                count += (mid - i + 1);
                count %= MOD;
            }
        }
        // Remaining left elements
        while (i <= mid) {
            temp.add(arr.get(i));
            i++;
        }
        // Remaining right elements
        while (j <= high) {
            temp.add(arr.get(j));
            j++;
        }
        // Copy sorted elements back
        for (int k = 0; k < temp.size(); k++) {
            arr.set(low + k, temp.get(k));
        }
        return count;
    }
}
