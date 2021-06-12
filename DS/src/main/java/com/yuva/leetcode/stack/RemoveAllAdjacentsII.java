package com.yuva.leetcode.stack;

import java.util.Stack;

/**

Leetcode 1209. Remove All Adjacent Duplicates in String II

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent 
and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

Last 6 months : Bloomberg 34, Facebook 10, Amazon 6, Microsoft 3, Google 2, Goldman Sachs 2, Roblox 2, ByteDance 2

 * @author Yuvaraja Kanagarajan
 *
 */

public class RemoveAllAdjacentsII {
	public String removeDuplicates(String s, int k) {
		Stack<CharNode> stack = new Stack<>();
		char[] charArr = s.toCharArray();
		for (char ch : charArr) {
			if (!stack.isEmpty() && stack.peek().ch == ch) {
				stack.push(new CharNode(ch, stack.peek().count + 1));
				if (stack.peek().count == k) {
					while (!stack.isEmpty() && stack.peek().ch == ch) {
						stack.pop();
					}
				}
			} else {
				stack.push(new CharNode(ch, 1));
			}
		}

		StringBuffer buff = new StringBuffer();
		while (!stack.isEmpty()) {
			buff.append(stack.pop().ch);
		}
		return buff.reverse().toString();
	}
}

