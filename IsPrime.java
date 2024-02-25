package com.scaler.module_2.assignments;
/*Given a number A. Return 1 if A is prime and return 0 if not. 
Note : 
The value of A can cross the range of Integer.
Problem Constraints
1 <= A <= 109
Input Format
The first argument is a single integer A.
Output Format
Return 1 if A is prime else return 0.
Example Input
Input 1:
A = 5
Input 2:
A = 10
Example Output
Output 1:
1
Output 2:
0 */

public class IsPrime {
    public int solve(Long A) {
        //if(countOfFactor(A)==2)
    
        //public int countOfFactor(Long A){
            int count = 0;
            for(long i=1; i*i<=A; i++){
                if(A%i==0){
                    //if(i==A/i){count  +=  1;}
                    //else{count += 2;}
                        count += (i==A/i) ? 1 : 2; 
                    }
                }
            //return count;
            if(count ==2){return 1;}
            else {return 0;}
    }
}
