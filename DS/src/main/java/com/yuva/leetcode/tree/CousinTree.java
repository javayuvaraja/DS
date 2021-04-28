package com.yuva.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Leetcode 993 : Cousins in Binary Tree

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class CousinTree {

	/**
	 * Logic : Level order traversal check whether the node is in the same level and not with the same parent
	 * @param root
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean isCousins(TreeNode root, int A, int B) {
	    if (root == null) return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean isAexist = false;		
			boolean isBexist = false;		
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
	            if (cur.val == A) isAexist = true;
	            if (cur.val == B) isBexist = true;
	            
	            // Checking whether child of same parent
				if (cur.left != null && cur.right != null) { 
					if (cur.left.val == A && cur.right.val == B) { 
						return false;
					}
					if (cur.left.val == B && cur.right.val == A) { 
						return false;
					}
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			// If both the nodes are available in the same level then return true
			if (isAexist && isBexist)  {
				return true;
			}
		}
		return false;
	}
}
