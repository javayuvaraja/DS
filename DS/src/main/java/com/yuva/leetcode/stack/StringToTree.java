package com.yuva.leetcode.stack;

import java.util.Stack;

import com.yuva.leetcode.tree.TreeNode;

public class StringToTree {

	public TreeNode str2tree(String str) {
		int index = 0;
		Stack<TreeNode> stack = new Stack<>();

		while (index < str.length()) {
			char ch = str.charAt(index++);

			if (ch == '-' || Character.isDigit(ch)) {
				int sign = 1, num = 0;
				if (ch == '-') {
					sign = -1;
				} else {
					num = ch - '0';
				}
				
				while (index < str.length() && Character.isDigit(str.charAt(index))) {
					num = 10 * num + str.charAt(index) - '0';
					index++;
				}
				
				TreeNode cur = new TreeNode(num * sign);
				if (!stack.isEmpty()) {
					TreeNode parent = stack.peek();
					if (parent.left == null) {
						parent.left = cur;
					} else {
						parent.right = cur;
					}
				}
				stack.push(cur);
			} else if (ch == ')') {
				stack.pop();
			}
		}
		return stack.isEmpty() ? null : stack.pop();
	}
}
