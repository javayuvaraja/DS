package com.yuva.leetcode.tree;

public class LetterCombination {

	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// Function to print all leaf nodes of the binary tree
	public static void print(TreeNode node) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			System.out.print(node.val + " ");
		} else {
			print(node.right);
			print(node.left);
		}
	}

	// Function to construct a binary tree where each leaf node contains
	// one unique combination of words formed
	public static void construct(TreeNode root, int[] digit, int i) {
		// Base case: empty tree
		if (root == null || i == digit.length) {
			return;
		}

		// check if `digit[i+1]` exists
		if (i + 1 < digit.length) {
			// process current and next digit
			int sum = 10 * digit[i] + digit[i + 1];

			// if both digits can form a valid character, create the left child from it
			if (sum <= 26) {
				root.left = new TreeNode(root.val + alphabet.charAt(sum - 1));
			}

			// construct the left subtree by remaining digits
			construct(root.left, digit, i + 2);
		}

		// process the current digit and create the right child from it
		root.right = new TreeNode(root.val + alphabet.charAt(digit[i] - 1));

		// construct the right subtree by remaining digits
		construct(root.right, digit, i + 1);
	}

	public static void main(String[] args) {
		int[] digit = { 1, 2, 2, 1 };

		// create an empty root
		TreeNode root = new TreeNode(0);

		// construct binary tree
		construct(root, digit, 0);

		print(root);
	}
}
