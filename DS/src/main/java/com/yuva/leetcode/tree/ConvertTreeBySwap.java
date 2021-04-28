package com.yuva.leetcode.tree;

/**
 * Determine if a binary tree can be converted to another by doing any number of
 * swaps of children
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ConvertTreeBySwap {

	public static boolean isConvert(TreeNode node1, TreeNode node2) {
		// base case: both trees are the same (handles the case when both trees
		// are empty)
		if (node1 == node2) {
			return true;
		}

		return (node1 != null && node2 != null) && (node1.val == node2.val)
				&& ((isConvert(node1.left, node2.left) && isConvert(node1.right, node2.right))
				||  (isConvert(node1.right, node2.left) && isConvert(node1.left, node2.right)));
	}

	public static void main(String[] args) {
		// construct the first tree
		TreeNode X = new TreeNode(6);
		X.left = new TreeNode(3);
		X.right = new TreeNode(8);
		X.left.left = new TreeNode(1);
		X.left.right = new TreeNode(7);
		X.right.left = new TreeNode(4);
		X.right.right = new TreeNode(2);
		X.right.left.left = new TreeNode(1);
		X.right.left.right = new TreeNode(7);
		X.right.right.right = new TreeNode(3);

		// construct the second tree
		TreeNode Y = new TreeNode(6);
		Y.left = new TreeNode(8);
		Y.right = new TreeNode(3);
		Y.left.left = new TreeNode(2);
		Y.left.right = new TreeNode(4);
		Y.right.left = new TreeNode(7);
		Y.right.right = new TreeNode(1);
		Y.left.left.left = new TreeNode(3);
		Y.left.right.left = new TreeNode(1);
		Y.left.right.right = new TreeNode(7);

		if (isConvert(X, Y)) {
			System.out.print("Binary tree can be converted");
		} else {
			System.out.print("Binary tree cannot be converted");
		}
	}
}
