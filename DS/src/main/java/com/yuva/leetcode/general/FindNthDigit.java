package com.yuva.leetcode.general;
/**
 * Leetcode 400. Nth Digit
 * Given an integer n, return the nth digit of the infinite 
 * integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 * 
Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

 * @author Yuvaraja Kanagarajan
 *
 */
public class FindNthDigit {

	/*
	 * Logic :
	    1 ~ 9 include 9 one digit number;
		10 ~ 99 include 90 two digits number;
		100 ~ 999 include 900 three digits number;
		1000 ~ 9999 include 9000 four digits number;
		...
		len is how many digits:1 or 2 or 3 ..., range is 9 or 90 or 900 ...
	 */
	public int findNthDigit(int n) {
		int digitLen = 1, digitCount = 1;
		long range = 9;
		while(n > digitLen * range){
			n -= digitLen * range;
			digitLen++;
			range *= 10;
			digitCount *= 10;
		}
		digitCount += (n - 1) / digitLen;
		String s = Integer.toString(digitCount);
		return Character.getNumericValue(s.charAt((n - 1) % digitLen));
	}
	
	public static void main(String[] args) {
		int n=27;
		FindNthDigit obj = new FindNthDigit();
		System.out.println(obj.findNthDigit(n));
	}
}
