package com.yuva.leetcode.general;

/**
66. Plus One

Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

 * @author Yuvaraja Kanagarajan
 *
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
	    
        int carry = 1; 
        for (int i = digits.length-1; i >= 0 && carry > 0; i--) {
            int sum = digits[i]+carry;
            digits[i] = sum%10;
            carry = sum/10;
        }
        if (carry>0) {
            digits = new int[digits.length+1];
            digits[0] =1;            
        }
        return digits;
    }
}
