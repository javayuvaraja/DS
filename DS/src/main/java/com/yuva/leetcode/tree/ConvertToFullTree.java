package com.yuva.leetcode.tree;

/**
 * 
 * @author Yuvaraja Kanagarajan
 *
 *
 *Logic :
 Use post-order traversal to solve this problem efficiently. 
 We first process the left children, then right children, and finally the node itself.
  So we form the new tree bottom up, starting from the leaves towards the root. By the time we process the current node, both its left and right subtrees were already processed. Below is the implementation of this idea
 */
public class ConvertToFullTree {

	// Logic : Post order traversal
	TreeNode removeHalfNodes(TreeNode node) {
		if (node == null)
			return null;

		node.left = removeHalfNodes(node.left);
		node.right = removeHalfNodes(node.right);

		if (node.left == null && node.right == null)
			return node;

		/*
		 * if current nodes is a half node with left child NULL left, 
		 * then it's right child is returned and replaces it in the given tree
		 */
		if (node.left == null) {
			TreeNode new_root = node.right;
			return new_root;
		}

		/*
		 * if current nodes is a half node with right child NULL right, 
		 * then it's right.Child is returned and replaces it in the given tree
		 */
		if (node.right == null) {
			TreeNode new_root = node.left;
			return new_root;
		}

		return node;
	}
}
