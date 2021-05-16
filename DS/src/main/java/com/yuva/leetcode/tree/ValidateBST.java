package com.yuva.leetcode.tree;

import java.util.Stack;

/**
 * 
 98. Validate Binary Search Tree
 Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidateBST {

	public boolean isValidBST(TreeNode root) {
		int minVal = Integer.MIN_VALUE;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currNode = root;
		while (currNode != null || !stack.isEmpty()) {
			stack.push(currNode);
			if (currNode.val < minVal) {
				return false;
			}

			if (currNode.left != null) {
				currNode = currNode.left;
			} else {
				minVal = stack.pop().val;
			}

		}

		return true;
	}
	
	public boolean isValidBSTRecursion(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) {
        	return false;
        }
        return isValidBST(root.left, minVal, root.val) && 
        	   isValidBST(root.right, root.val, maxVal);
    }
}
