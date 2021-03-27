package com.yuva.leetcode.general;

import java.util.Stack;

/**
 * 1209. Remove All Adjacent Duplicates in String II
 * 
 * Given a string s, a k duplicate removal consists of choosing k adjacent and
 * equal letters from s and removing them causing the left and the right side of
 * the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * Example 1:
 * 
 * Input: s = "abcd", k = 2 Output: "abcd" Explanation: There's nothing to
 * delete. Example 2:
 * 
 * Input: s = "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete
 * "eee" and "ccc", get "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete
 * "ddd", get "aa"
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class RemoveAllAdjacentDuplicatesII {

	public String removeDuplicates(String s, int k) {
		Stack<CharNode> stack = new Stack<>();
		char []charArr = s.toCharArray();
		for (char ch: charArr) {
			if (!stack.isEmpty() && stack.peek().ch==ch) {
				stack.peek().count++;				
			} else {
				stack.push(new CharNode(ch, 1));
			}
			if (stack.peek().count==k) {
				stack.pop();
			}
		}
		
		StringBuffer buff = new StringBuffer();
		while (!stack.isEmpty()) {
			buff.append(stack.pop().ch);
		}
		return buff.reverse().toString();
	}
	
	public static void main(String[] args) {
		String str = "pbbcggttciiippooaais";
		RemoveAllAdjacentDuplicatesII obj = new RemoveAllAdjacentDuplicatesII();
		System.out.println(obj.removeDuplicates(str, 2));
	}
}

class CharNode {
	public CharNode(char ch, int i) {
		this.ch = ch;
		this.count = i;
	}
	char ch;
	int count;
}
