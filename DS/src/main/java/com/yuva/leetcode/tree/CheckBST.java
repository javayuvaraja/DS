package com.yuva.leetcode.tree;

import java.util.Stack;

/**
 * Leetcode 98. Validate Binary Search Tree
 * 
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

 * @author Yuvaraja Kanagarajan
 *
 */
public class CheckBST {

	/*
	 * Logic : Using inorder iterative traversal.
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (prev != null && root.val <= prev.val) {
				return false;
			}
			prev = root;
			root = root.right;
		}
		return true;
	}
	
	
	public boolean isValidBSTRecursive(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidBST(root.left, min, root.val) && 
			   isValidBST(root.right, root.val, max);
	}
}
