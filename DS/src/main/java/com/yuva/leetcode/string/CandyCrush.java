package com.yuva.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an string, if it has 3 or more consecutive same character, they can
 * cancel each other, then concatenate the left and right , and keep cancel if
 * new concatenated string has 3 or more consecutive items.
 * 
 * example: in : acaaaacc [acaaaacc] -> [accc] -> [a] out : a
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class CandyCrush {

	public String getFinalString(String str) {
		int len = str.length();
		
		Deque<Letter> stack = new ArrayDeque<Letter>();
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if (!stack.isEmpty() && stack.peek().val == ch) {
				stack.peek().count++;
			} else {
				if (!stack.isEmpty() && stack.peek().count >= 3) {
					stack.pop();
				}
				if (!stack.isEmpty() && stack.peek().val == ch) {
					stack.peek().count++;
				} else {
					stack.push(new Letter(ch, 1));
				}
			}
		}
		if (stack.peek().count >= 3) {
			stack.pop();
		}

		StringBuilder strBuilder = new StringBuilder();
		while (!stack.isEmpty()) {
			Letter character = stack.pop();
			for (int i = 0; i < character.count; i++) {
				strBuilder.append(character.val);
			}
		}
		return strBuilder.reverse().toString();
	}

	public static void main(String[] args) {

		CandyCrush candyCrush = new CandyCrush();
		System.out.println(candyCrush.getFinalString("aaabbbc"));
		System.out.println(candyCrush.getFinalString("aabbbacd"));
		System.out.println(candyCrush.getFinalString("aabbccddeeedcba"));
		System.out.println(candyCrush.getFinalString("aaabbbacd"));
		System.out.println(candyCrush.getFinalString("aaaaaaaa"));

	}

}

class Letter {
	char val;
	int count;

	public Letter(char val, int count) {
		this.val = val;
		this.count = count;
	}
}