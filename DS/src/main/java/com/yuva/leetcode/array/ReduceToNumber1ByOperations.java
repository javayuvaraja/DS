package com.yuva.leetcode.array;

/**
 * 
Given a number N. The task is to reduce the given number N to 1 in the minimum number of steps. 
You can perform any one of the below operations in each step.

Operation 1: If the number is even then you can divide the number by 2.
Operation 2: If the number is odd then you are allowed to perform either (n+1) or (n-1).

You need to print the minimum number of steps required to reduce the number N to 1 by performing the above operations.

Examples:  

Input : n = 15
Output : 5
 15 is odd 15+1=16    
 16 is even 16/2=8     
 8  is even 8/2=4 
 4  is even 4/2=2     
 2  is even 2/2=1     

Input : n = 7
Output : 4
    7->6    
    6->3 
    3->2    
    2->1
    
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReduceToNumber1ByOperations {

	static int countways(int n) {
		if (n == 1)
			return 0;
		else if (n % 2 == 0)
			return 1 + countways(n / 2);
		else
			return 1 + Math.min(countways(n - 1), countways(n + 1));
	}

	public static int countSteps(int n) {
		int count = 0;

		while (n > 1) {
			count++;

			// num even, divide by 2
			if (n % 2 == 0)
				n /= 2;

			// num odd, n%4 == 1
			// or n==3(special edge case),
			// decrement by 1
			else if (n % 4 == 1 || n == 3)
				n -= 1;

			// num odd, n%4 == 3, increment by 1
			else
				n += 1;
		}
		return count;
	}
 
    // Driver code
    public static void main(String args[])
    {
        int n = 15;
 
        System.out.println(countways(n));
    }
}
