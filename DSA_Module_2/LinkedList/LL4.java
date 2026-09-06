package com.scaler.module_2.assignments.DSA_Module_2.LinkedList;
/*Construct a class Rectangle that represents a rectangle.
The class should support the following functionalities:-
perimeter() -> returns the perimeter of the rectangle
area() -> returns the area of the rectangle
Input format:
First argument A is an integer representing the number of testcases.
For each case, x (length) and y (breadth) are taken as input in new lines.
Output format:
The perimeter and area of the constructed rectangle are printed.
Sample Input:
1 # number of test-cases
1 # length of the rectangle in test case - 1
2 # breadth of the rectangle in test case - 1
Sample output:
6 #perimeter of rectangle
2 #area of rectangle*/
public class LL4 {
    int length;
    int breadth;
    LL4(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    int perimeter() {
        return 2 * (length + breadth);
    }
    int area() {
        return length * breadth;
    }
}
