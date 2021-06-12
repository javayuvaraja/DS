package com.yuva.leetcode.general;

import java.util.Stack;

/**
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestValidParenthesis {

	public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0){
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }
	
	public int longestValidParentheses_stack(String s) {
        int maxLen = 0;
    	Stack<Integer> stack = new Stack<>();
    	stack.push(-1);
    	for (int i=0; i < s.length(); i++) {
    		if (s.charAt(i)=='(') {
    			stack.push(i);
    		} else {
    			stack.pop();
    			if (!stack.isEmpty()) {
    				maxLen = Math.max(maxLen, i-stack.peek());
    			} else {
    				stack.push(i);
    			}
    			
    		}
    	}
    	return maxLen;
    }
	
	public static void main(String[] args) {
		String str = ")()())";
		LongestValidParenthesis obj = new LongestValidParenthesis();
		obj.longestValidParentheses(str);
		obj.longestValidParentheses_stack(str);
		
	}
}
