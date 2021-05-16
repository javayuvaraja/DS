package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
A leaf is a node with no children.

 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class RootToLeafPathSumPrint {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		hasPathSum(root, sum, result, new ArrayList<Integer>());
		return result;
	}

	private void hasPathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp) {
		if (root == null) {
			return;
		}
		temp.add(root.val);
		if (root.left == null && root.right == null && sum == root.val) {
			result.add(new ArrayList<>(temp));
			temp.remove(temp.size() - 1);
			return;
		} else {
			hasPathSum(root.left, sum - root.val, result, temp);
			hasPathSum(root.right, sum - root.val, result, temp);
		}
		temp.remove(temp.size() - 1);
	}
}
