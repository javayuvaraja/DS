package com.yuva.leetcode.tree;

/**
 *

Leetcode 129. Sum Root to Leaf Numbers
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers.

A leaf node is a node with no children.
 * @author Yuvaraja Kanagarajan
 *
 */
public class RootToLeafSum {

	int sum = 0;
	
	public int sumNumbers(TreeNode root) {
		sumNumbers(root, 0);
		return sum;
    }
	public void sumNumbers(TreeNode root, int currVal) {
		if (root == null) {
			return;
		}
		
		currVal = currVal*10+root.val;
		if (root.left==null && root.right==null) {
			sum = sum + currVal;
		}
		
		sumNumbers(root.left, currVal);
		sumNumbers(root.right, currVal);
		
		
    }
}
