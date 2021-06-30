package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalanceBST {
	public TreeNode balanceBST(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root);
			root = root.right;
		}

		return buildTree(list, 0, list.size() - 1);
	}

	private TreeNode buildTree(List<TreeNode> list, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(list.get(mid).val);
		node.left = buildTree(list, start, mid - 1);
		node.right = buildTree(list, mid + 1, end);
		return node;
	}
}
