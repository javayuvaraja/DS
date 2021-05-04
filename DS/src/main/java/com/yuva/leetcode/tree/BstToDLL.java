package com.yuva.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * Convert a BST to a sorted circular doubly-linked list in-place
 * @author Yuvaraja Kanagarajan
 *
 */
public class BstToDLL {

	/**
	 * Logic : Inorder iterative traversal. 
	 * @param root
	 * @return
	 */
	public TreeNode treeToDoublyLinkedList(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode prev= null;
		TreeNode head = null;
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			if (prev == null) {
				head = root;
			} else {
				prev.right = root;
				root.left = prev;
			}
			
			prev = root;
			root = root.right;
		}
		prev.right = head;
		head.left = prev;
		
		return head;
	}
}
