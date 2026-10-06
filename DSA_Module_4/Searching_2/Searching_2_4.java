package com.scaler.module_2.assignments.DSA_Module_4.Searching_2;
/*You are given three positive integers, A, B, and C.
Any positive integer is magical if divisible by either B or C.
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
Note: Ensure to prevent integer overflow while calculating.
Problem Constraints
1 <= A <= 109
2 <= B, C <= 40000
Input Format
The first argument given is an integer A.
The second argument given is an integer B.
The third argument given is an integer C.
Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
Example Input
Input 1: A = 1 B = 2 C = 3
Input 2: A = 4 B = 2 C = 3
Example Output
Output 1: 2
Output 2: 6*/
public class Searching_2_4 {
    public int solve(int A, int B, int C) {
        long MOD = 1000000007L;
        long lcm = ((long) B / gcd(B, C)) * C;
        long low = 1;
        long high = (long) A * Math.min(B, C);
        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = mid / B
                    + mid / C
                    - mid / lcm;
            if (count < A) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) (low % MOD);
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
