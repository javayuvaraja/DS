package com.yuva.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the root of a binary tree, return true if you can partition the tree 
 * into two trees with equal sums of values after removing exactly one edge on the original tree.
 * @author Yuvaraja Kanagarajan
 *
 */
public class EqualTreePartition {

	public boolean checkEqualTree(TreeNode root) {
		Map<Integer, Integer> sumMap = new HashMap<>();
		int sum = getSum(root, sumMap);
		if (sum == 0) {
			return sumMap.get(0) > 1;
		}

		return sum % 2 == 0 && sumMap.containsKey(sum / 2);
	}

	private int getSum(TreeNode root, Map<Integer, Integer> sumMap) {
		if (root == null) {
			return 0;
		}

		int sum = root.val + getSum(root.left, sumMap) + getSum(root.right, sumMap);
		sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
		return sum;

	}
}
