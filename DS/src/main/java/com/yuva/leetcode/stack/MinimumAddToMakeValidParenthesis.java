package com.yuva.leetcode.stack;

import java.util.Stack;

/**
 921. Minimum Add to Make Parentheses Valid

Given a string s of '(' and ')' parentheses, we add the minimum number of 
parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3

Example 3:
Input: s = "()"
Output: 0

Example 4:
Input: s = "()))(("
Output: 4

 * @author Yuvaraja Kanagarajan
 *
 */
public class MinimumAddToMakeValidParenthesis {

	public int minAddToMakeValid(String S) {
	     
        int open = 0;
        int close = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                open++; // stack push 
            } else if (open > 0) {
            	open --; // stack pop;
            } else {
            	close++;
            }
        }
        return open + close;    
    }
	
	public int minAddToMakeValid1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (Character ch : arr) {
            if (ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
