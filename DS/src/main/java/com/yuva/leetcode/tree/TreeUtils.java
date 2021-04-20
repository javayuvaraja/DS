package com.yuva.leetcode.tree;

public class TreeUtils {

	public static int getHeight(TreeNode root ) {
		if (root == null) {
			return 0;
		}
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	
	public static void printPreorder(TreeNode root) {
		if (root==null) {
			return;
		}
		
		
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	public static void printPostOrder(TreeNode root) {
		if (root==null) {
			return;
		}
		
		printPreorder(root.left);
		printPreorder(root.right);
		System.out.print(root.val + " ");
	}
	
	public static void printInorder(TreeNode root) {
		if (root==null) {
			return;
		}
		
		printPreorder(root.left);
		printPreorder(root.right);
		System.out.print(root.val + " ");
	}
}
