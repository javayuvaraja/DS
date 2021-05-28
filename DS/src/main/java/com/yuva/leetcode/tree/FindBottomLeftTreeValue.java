package com.yuva.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 513. Find Bottom Left Tree Value
 * 
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 * 
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindBottomLeftTreeValue {

	/*
	 * Logic : Level order traversal. Add the right node first in the queue because
	 *  we need the last node at the end
	 */
	public int findBottomLeftValue(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode currNode = null;
		while (!queue.isEmpty()) {
				currNode =  queue.poll();
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
				if (currNode.left!=null) {
					queue.add(currNode.left);
				}
		}
		
		return currNode.val;
	}
}
