package com.yuva.leetcode.tree;

public class KthSmallestInBST {

	int count = 0;
	int kthSmall = 0;

	public int kthSmallest(TreeNode root, int k) {
		inorder(root, k);
		return kthSmall;
	}

	public void inorder(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		inorder(root.left, k);
		if (++count == k) {
			kthSmall = root.val;
			return;
		}
		inorder(root.right, k);
	}
}
