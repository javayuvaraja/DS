package com.yuva.leetcode.general;

/**
9. Palindrome Number

Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

Example 1:
Input: x = 121
Output: true

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 * @author Yuvaraja Kanagarajan
 *
 */
public class CheckPalindromeNumber {

	public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        
        int revNumber = 0;
        int remain = x;
        while (remain > 0) {
            int temp = remain%10;
            remain = remain/10;
            revNumber = (revNumber*10) + temp;            
        }
        
        return revNumber==x;
    }
}
