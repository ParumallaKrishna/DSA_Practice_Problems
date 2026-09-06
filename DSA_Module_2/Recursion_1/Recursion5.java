package com.scaler.module_2.assignments.DSA_Module_2.Recursion_1;

import java.util.Scanner;

/*Write a recursive function that takes a string, S, as input and prints the characters of S in reverse order.
Problem Constraints
1 <= |s| <= 1000
Input Format
First line of input contains a string S.
Output Format
Print the character of the string S in reverse order.
Example Input
Input 1: scaleracademy
Input 2: cool
Example Output
Output 1: ymedacarelacs
Output 2: looc*/
public class Recursion5 {
    static void reverseString(String s,int n){
        if(n<0){return;}
        System.out.print(s.charAt(n));
        reverseString(s,n-1);
    }
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        reverseString(s,s.length()-1);

    }
}
