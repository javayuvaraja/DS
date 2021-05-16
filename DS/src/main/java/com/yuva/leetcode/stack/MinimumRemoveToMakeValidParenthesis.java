package com.yuva.leetcode.stack;

import java.util.Stack;

/**
Leetcode 1249. Minimum Remove to Make Valid Parentheses

Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"

 * @author Yuvaraja Kanagarajan
 *
 */
public class MinimumRemoveToMakeValidParenthesis {

	 public String minRemoveToMakeValid(String str) {
		 StringBuffer buff = new StringBuffer();
		 Stack<Integer> stack =  new Stack<>();
		 for (int i =0; i < str.length(); i++) {
			 if (str.charAt(i)=='(') {
				 stack.push(i);
			 } else if (str.charAt(i)==')') {
				 if (!stack.isEmpty() && str.charAt(stack.peek()) == '(') {
					 stack.pop();
				 } else {
					 stack.push(i);
				 }
			 }
			 buff.append(str.charAt(i));
		 }
		 
		 while (!stack.isEmpty()) {
			 buff.deleteCharAt(stack.pop());
		 }
		 return buff.toString();
	 }
}
