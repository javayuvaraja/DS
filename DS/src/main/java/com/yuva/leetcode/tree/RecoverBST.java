package com.yuva.leetcode.tree;

/**
99. Recover Binary Search Tree
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
Recover the tree without changing its structure.

Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.

 * @author Yuvaraja Kanagarajan
 *
 */
public class RecoverBST {

	TreeNode firstElement;
	TreeNode secondElement;
	TreeNode prevElement;

	public void recoverTree(TreeNode root) {

		// In order traversal to find the two elements
		traverse(root);

		// Swap the values of the two nodes
		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;
	}

	private void traverse(TreeNode root) {

		if (root == null)
			return;

		traverse(root.left);

		// Start of "do some business",
		// If first element has not been found, assign it to prevElement (refer to 6 in
		// the example above)
		if (firstElement == null && (prevElement == null  || prevElement.val >= root.val)) {
			firstElement = prevElement;
		}

		// If first element is found, assign the second element to the root (refer to 2
		// in the example above)
		if (firstElement != null && (prevElement == null  || prevElement.val >= root.val)) {
			secondElement = root;
		}
		prevElement = root;

		// End of "do some business"

		traverse(root.right);
	}
}
