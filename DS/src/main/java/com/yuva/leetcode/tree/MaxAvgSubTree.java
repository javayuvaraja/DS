package com.yuva.leetcode.tree;

public class MaxAvgSubTree {
	double res = Integer.MIN_VALUE;

	public double maximumAverageSubtree(TreeNode root) {
		dfs(root);
		return res;
	}

	private int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 }; // storing the sum and count
		}
		int left[] = dfs(root.left);
		int right[] = dfs(root.right);
		int sum = left[0] + right[0] + root.val;
		int count = left[1] + right[1] + 1;
		res = Math.max(sum / count, res);
		return new int[] { sum, count };
	}

}
