package com.yuva.leetcode.general;
/**
 Leetcode 9. Palindrome Number
 
 Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. 
For example, 121 is palindrome while 123 is not.

 * @author Yuvaraja Kanagarajan
 *
 */
public class CheckPalindrome {

	public boolean isPalindrome(int num) {
        if (num < 0){
            return false;
        }
        
        int revNumber = reverseNumber(num);
        return revNumber == num;
    }

	private int reverseNumber(int num) {
		int revNumber = 0;
        int remain = num;
        while (remain > 0) {
        	int temp = remain%10;
        	remain = remain/10;
        	revNumber = (revNumber*10) + temp;            
        }
		return revNumber;
	}
}
