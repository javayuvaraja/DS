package com.yuva.leetcode.general;

/**
Leetcode 50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000

 * @author Yuvaraja Kanagarajan
 *
 */
public class PowerOfN {

	public double myPow(double x, int n) {
        boolean isNegative = false;
        if (n < 0){
            isNegative = true;
        }
        double result = myPow1(x, n);
         return isNegative ? 1/result : result;
    }
    public double myPow1(double x, int n) {
        if (n==0 ) {
            return 1;
        }   
        if (n%2==0) {
            return myPow1(x, n/2) * myPow1(x, n/2);
        } else {
            return x*myPow1(x, n/2) * myPow1(x, n/2);
        }
    }
    
    public double myPowIterative(double x, int n) {
        double result = 1.0;
        for(int i = n; i != 0; ) {
        	if( i % 2 != 0 ) {
                result *= x;
            }
        	i=i/2;
        	x = x *x;
        }
        return n < 0 ? 1.0 / result : result;
      }
    
    public static void main(String[] args) {
		int x = 2;
		int n = 3;
		
		PowerOfN obj = new PowerOfN();
		System.out.println(obj.myPow(x, n));
		System.out.println(obj.myPowIterative(x, n));
		
	}
}
