package com.yuva.leetcode.tree;

public class CheckSumTree {

	public static boolean isSumTree(TreeNode node) {
		int ls, rs;

		// If node is NULL or it's a leaf
		// node then return true
		if (node == null || (node.left == null && node.right == null)) {
			return true;
		}

		// Get sum of nodes in left and
		// right subtrees
		ls = sum(node.left);
		rs = sum(node.right);

		// If the node and both of its
		// children satisfy the property 
		// return 1 else 0
		if ((node.val == ls + rs) && isSumTree(node.left) && isSumTree(node.right)) {
			return true;
		}
		return false;
	}

	static int sum(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return (sum(node.left) + node.val + sum(node.right));
	}

	/**
	 * 
	 * 1) If the node is a leaf node then the sum of the subtree rooted with this
	 * node is equal to the value of this node. 2) If the node is not a leaf node
	 * then the sum of the subtree rooted with this node is twice the value of this
	 * node (Assuming that the tree rooted with this node is SumTree).
	 */

	/*
	 * returns 1 if SumTree property holds for the given tree
	 */
	
	boolean isLeaf(TreeNode node) {
		return node==null || (node.left==null && node.right==null);
	}
	boolean isSumTree1(TreeNode node) {
		int ls; // for sum of nodes in left subtree
		int rs; // for sum of nodes in right subtree

		/*
		 * If node is NULL or it's a leaf node then return true
		 */
		if (node == null || (node.left==null && node.right==null))
			return true;

		if (isSumTree1(node.left) && isSumTree(node.right)) {
			// Get the sum of nodes in left subtree
			if (node.left == null)
				ls = 0;
			else if (isLeaf(node.left))
				ls = node.left.val;
			else
				ls = 2 * (node.left.val);

			// Get the sum of nodes in right subtree
			if (node.right == null)
				rs = 0;
			else if (isLeaf(node.right))
				rs = node.right.val;
			else
				rs = 2 * (node.right.val);

			/*
			 * If root's data is equal to sum of nodes in left and right subtrees then
			 * return 1 else return 0
			 */
			if ((node.val == rs + ls))
				return true;
			else
				return false;
		}

		return false;
	}
}
