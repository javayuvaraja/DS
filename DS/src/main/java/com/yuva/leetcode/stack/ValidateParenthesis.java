package com.yuva.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true

 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidateParenthesis {

	static public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (stack.isEmpty() || map.get(stack.pop()) != c)
					return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String str = "{[]}";
		System.out.println(isValid(str));
	}
}
