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
		TreeNode curr = root;
		while (!stack.isEmpty() || curr != null) {
			while (curr != null) {
				stack.push(curr);
				curr = root.left;
			}
			
			curr = stack.pop();
			if (prev == null) {
				head = curr;
			} else {
				prev.right = curr;
				curr.left = prev;
			}
			
			prev = curr;
			curr = curr.right;
		}
		prev.right = head;
		head.left = prev;
		
		return head;
	}
}
