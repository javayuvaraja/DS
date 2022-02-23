package com.yuva.leetcode.general;

import java.util.Stack;

/**
 * 224. Basic Calculator
 * 
 * Given a string s representing an expression, implement a basic calculator to
 * evaluate it.
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "1 + 1" Output: 2 Example 2:
 * 
 * Input: s = " 2-1 + 2 " Output: 3 Example 3:
 * 
 * Input: s = "(1+(4+5+2)-3)+(6+8)" Output: 23
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class BasicCalculatorI {


	public static int calculate(String s) {
		int len = s.length(), sign = 1, result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop(); // operation
				result =+ stack.pop();  // prev result
			}

		}
		return result;
	}
	
	
	
}
