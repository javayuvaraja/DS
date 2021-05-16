package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class ReverseLevelOrderRecursive {

	public List<List<Integer>> levelOrderBottomRec(TreeNode root) {
		List<List<Integer>> resultList = new ArrayList<>();
		int height = getHeight(root);
		
		for (int i=height; i>0; i--) {
			List<Integer> currLevelList = new ArrayList<>();
			printGivenLevel(root, i, 1, currLevelList);
			resultList.add(currLevelList);
		}
		return resultList;
	}
	
	private void printGivenLevel (TreeNode root, int givenLevel, int currLevel, List<Integer> currLevelList) {
		if (root == null) {
			return;
		}
		if (currLevel == givenLevel) {
			currLevelList.add(root.val);
		}
		printGivenLevel(root.left, givenLevel, currLevel+1, currLevelList);
		printGivenLevel(root.right, givenLevel, currLevel+1, currLevelList);
	}
    public int getHeight (TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		
		return 1+ Math.max(leftHeight, rightHeight);
	}
}
