package com.yuva.leetcode.general;

/**
 * 
680. Valid Palindrome II

Given a non-empty string s, you may delete at most one character. 
Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidPalindromeII {

	public boolean validPalindrome(String s) {
        int start=0; 
        int end= s.length()-1;
        while (start < end ) {
            if (s.charAt(start)!=s.charAt(end)) {
                return isValidPalindrome (s, start+1,end) || 
                       isValidPalindrome (s, start,end-1); 
            }
            start++;
            end--;
        }
        return true;
    }
    
    private boolean isValidPalindrome (String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start)!= str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
