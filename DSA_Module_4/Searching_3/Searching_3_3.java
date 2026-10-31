package com.scaler.module_2.assignments.DSA_Module_4.Searching_3;
import java.util.ArrayList;
/*Given an array of integers A of size N and an integer B.
The College library has N books. The ith book has A[i] number of pages.
You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.
NOTE: Return -1 if a valid assignment is not possible.
Problem Constraints
1 <= N <= 105
1 <= A[i], B <= 105
Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return that minimum possible number.
Example Input
Input 1: A = [12, 34, 67, 90] B = 2
Input 2: A = [12, 15, 78]  B = 4
Example Output
Output 1: 113
Output 2: -1*/
public class Searching_3_3 {
    public int books(ArrayList<Integer> A, int B) {
        int N = A.size();
        // Every student must get at least one book
        if (B > N) {
            return -1;
        }
        int low = 0;
        int high = 0;
        for (int i = 0; i < N; i++) {
            low = Math.max(low, A.get(i));
            high += A.get(i);
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(A, B, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean isPossible(ArrayList<Integer> A, int B, int mid) {
        int students = 1;
        int pages = 0;
        for (int i = 0; i < A.size(); i++) {
            if (pages + A.get(i) <= mid) {
                pages += A.get(i);
            } else {
                students++;
                pages = A.get(i);
            }
            if (students > B) {
                return false;
            }
        }
        return true;
    }
}
