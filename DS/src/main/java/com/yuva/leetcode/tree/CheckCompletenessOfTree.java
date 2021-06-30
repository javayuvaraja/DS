package com.yuva.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfTree {

	/**
	 *  Logic : Level Order traversal
	 *  		1. when left child is null check right child is present if found return false
	 *  		2. Break the loop when left or right is null
	 *  		3. Check remaining nodes is queue whether any node having child
	 */
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (true) {
			TreeNode node = queue.poll();
			if (node.left == null) {  // left child is null but right child is not null then return false
				if (node.right != null)
					return false;
				break;
			}
			queue.offer(node.left);
			if (node.right == null)
				break;
			queue.offer(node.right);
		}
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null || node.right != null)
				return false;
		}
		return true;
	}
}
