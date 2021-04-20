package com.yuva.leetcode.tree;

/**
 * 
Leetcode : 226. Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.
 * @author Yuvaraja Kanagarajan
 *
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
	}
	
	
	public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
	       root.left = new TreeNode(2);
	       root.right = new TreeNode(3);
	       root.left.left = new TreeNode(4);
	       root.left.right = new TreeNode(5);
	  
	}
}
