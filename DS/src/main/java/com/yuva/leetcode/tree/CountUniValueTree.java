package com.yuva.leetcode.tree;

/**
 * 
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example: Given binary tree,

 * @author Yuvaraja Kanagarajan
 *
 */
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
		boolean leftVal = isUnival(root.left);
		boolean rightVal = isUnival(root.right);
		if (leftVal && rightVal) {
			if ((root.left != null && root.left.val != root.val)  ||
				 (root.right != null && root.right.val != root.val)) {
				return false;
			}
			count++;
			return true;
		}
		return false;
	}
}
