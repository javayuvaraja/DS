package com.yuva.leetcode.stack;

/**
 * 
678. Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "(*)"
Output: true

Example 3:
Input: s = "(*))"
Output: true

 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidateParenthesisString {

	public boolean checkValidString(String s) {
        int minParenCount = 0, maxParenCount = 0; // open parentheses count in range [cmin, cmax]
        for (char c : s.toCharArray()) {
            if (c == '(') {
                maxParenCount++;
                minParenCount++;
            } else if (c == ')') {
                maxParenCount--;
                minParenCount--;
            } else if (c == '*') {
                maxParenCount++; // if `*` become `(` then openCount++
                minParenCount--; // if `*` become `)` then openCount--
                // if `*` become `` then nothing happens
                // So openCount will be in new range [cmin-1, cmax+1]
            }
            // Currently, don't have enough open parentheses to match close parentheses-> Invalid
            // For example: ())(
            if (maxParenCount < 0) {
            	return false; 
            }
            minParenCount = Math.max(minParenCount, 0);   
            // It's invalid if open parentheses count < 0 that's why cmin can't be negative
        }
        return minParenCount == 0; // Return true if can found `openCount == 0` in range [cmin, cmax]
    }
}
