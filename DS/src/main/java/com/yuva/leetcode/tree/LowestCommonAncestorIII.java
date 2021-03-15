package com.yuva.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).

Return null If any of the nodes is not in the tree.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes arenotguaranteed to be in the binary tree
 * @author Yuvaraja Kanagarajan
 *
 */
public class LowestCommonAncestorIII {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		TreeNode ans = helper(root, one, two);
		if (ans != one && ans != two) {
			return ans;
		}
		boolean exist = false;
		if (ans == one) {
			exist = find(one, two);
		} else {
			exist = find(two, one);
		}
		return exist ? ans : null;
	}

	private TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		TreeNode left = helper(root.left, one, two);
		TreeNode right = helper(root.right, one, two);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	private boolean find(TreeNode root, TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == node) {
				return true;
			}
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
		return false;
	}
}
