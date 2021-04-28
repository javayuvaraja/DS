package com.yuva.leetcode.tree;


/**
 * Given a BST, transform it into a greater sum tree where each node contains sum of all nodes greater than that node
 * 
 * https://www.geeksforgeeks.org/transform-bst-sum-tree/
 * @author Yuvaraja Kanagarajan
 *
 */
public class GreaterSumBST {

	static int sum = 0;
	public static void convertGreaterSumBST(TreeNode root) {
		if (root == null) {
			return ;
		}
		
		convertGreaterSumBST(root.right);
		int currVal = root.val;
		root.val = sum;
		sum = sum+currVal;
		convertGreaterSumBST(root.left);
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.left = new TreeNode(2);
		root.right = new TreeNode(29);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(40);
		root.right.right.left = new TreeNode(35);
		convertGreaterSumBST(root);
		TreeUtils.printPreorder(root);
	}
}
