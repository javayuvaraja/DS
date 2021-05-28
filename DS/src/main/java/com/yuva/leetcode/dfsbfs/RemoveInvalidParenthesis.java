package com.yuva.leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
Google question
301. Remove Invalid Parentheses
Given a string s that contains parentheses and letters, remove the minimum number
 of invalid parentheses to make the input string valid.

Return all the possible results. You may return the answer in any order.

Example 1:
Input: s = "()())()"
Output: ["(())()","()()()"]

Example 2:
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]

 * @author Yuvaraja Kanagarajan
 *
 */

public class RemoveInvalidParenthesis {

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		// sanity check
		if (s == null)
			return res;

		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		// initialize
		queue.add(s);
		visited.add(s);

		boolean found = false;

		while (!queue.isEmpty()) {
			s = queue.poll();

			if (isValid(s)) {
				res.add(s);
				found = true;
			}

			if (found) {  // no need to visit the next level
				continue;
			}

			// generate all possible states
			for (int i = 0; i < s.length(); i++) {
				// try to remove left or right paren
				if (s.charAt(i) != '(' && s.charAt(i) != ')') {
					continue;
				}

				String t = s.substring(0, i) + s.substring(i + 1);
				if (!visited.contains(t)) {
					// for each state, if it's not visited, add it to the queue
					queue.add(t);
					visited.add(t);
				}
			}
		}

		return res;
	}

	// helper function checks if string s contains valid parantheses
	boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				count++;
			if (c == ')') {
				if (count == 0) { // there is no open braces
					return false; 
				} else {
					count--;
				}
			}
				
		}
		return count == 0;
	}
}
