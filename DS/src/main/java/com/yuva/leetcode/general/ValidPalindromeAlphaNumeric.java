package com.yuva.leetcode.general;

/**
125. Valid Palindrome

Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidPalindromeAlphaNumeric {

	public boolean isPalindrome(String s) {
        char charArr[] = s.toLowerCase().toCharArray();
        int start = 0; 
        int end = charArr.length-1;
        while (start < end) {
            if (!isAlphaNumeric(charArr[start])) {
                start++;
                continue;
            }
            if (!isAlphaNumeric(charArr[end])) {
                end--;
                continue;
            }
            
            if (charArr[start++] != charArr[end--]) {
                return false;
            }
        }        
        return true;
    }
    
    private boolean isAlphaNumeric (char ch) {
        if (Character.isDigit(ch) || Character.isLetter(ch)) {
            return true;
        }
        return false;
    }
}
