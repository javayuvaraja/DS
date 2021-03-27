package com.yuva.leetcode.tree;

public class CountUniValueTree {

	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;
		isUnival(root);
		return count;
	}

	private boolean isUnival(TreeNode root) {
		if (root == null)
			return true;
		if (isUnival(root.left) && isUnival(root.right)) {
			if (root.left != null && root.left.val != root.val)
				return false;
			if (root.right != null && root.right.val != root.val)
				return false;
			count++;
			return true;
		}
		return false;
	}
}
