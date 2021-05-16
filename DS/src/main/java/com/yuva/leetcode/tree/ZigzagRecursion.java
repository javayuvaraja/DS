package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagRecursion {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> sol = new ArrayList<>();
		traverse(root, sol, 0);
		return sol;
	}

	private void traverse(TreeNode curr, List<List<Integer>> result, int currLevel) {
		if (curr == null)
			return;

		if (result.size() <= currLevel) {
			List<Integer> newLevel = new LinkedList<>();
			result.add(newLevel);
		}

		List<Integer> collection = result.get(currLevel);
		if (currLevel % 2 == 0)
			collection.add(curr.val);
		else
			collection.add(0, curr.val);

		traverse(curr.left, result, currLevel + 1);
		traverse(curr.right, result, currLevel + 1);
	}
}
