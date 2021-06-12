package com.yuva.leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


Follow Up:

Imagine you know have not only three types of parenthesis, but a huge amount of different types:
"<>", "aA", "\ /", "bB", ..., where every pair corresponds to open and closed parenthesis. How would you solve it ?

int[] positionsOpen = new int[256]

Using Map <Open character, Close Character>

 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidateParenthesis {

	static public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
		List<Character> closedParenthesis = new ArrayList<>();
		closedParenthesis.add(')');
		closedParenthesis.add('}');
		closedParenthesis.add(']');
		
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			//} else if (c == ')' || c == '}' || c == ']') {
			} else if (closedParenthesis.contains(c)) {
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
