package com.yuva.leetcode.stack;

import java.util.Stack;

/**
Leetcode 1047. Remove All Adjacent Duplicates In String

Given a string S of lowercase letters, a duplicate removal consists of choosing 
two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, 
and this is the only possible move.  The result of this move is that the string is "aaca", 
of which only "aa" is possible, so the final string is "ca".
 
 * @author Yuvaraja Kanagarajan
 *
 */

public class RemoveAllAdjacents {
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

