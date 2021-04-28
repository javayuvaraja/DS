package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 199
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes 
 * you can see ordered from top to bottom.

	Example:
	
	Input: [1,2,3,null,5,null,4]
	Output: [1, 3, 4]
	Explanation:
	
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---

 * @author Yuvaraja Kanagarajan
 *
 *
 *  Approach :
 *  1. Level order traversal, print the last node of each level
 *  2. Based on the level size and result size comparision, add the first node of the each level.
 */
public class RightViewTree {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		populateRightView(root, result, 0);
		return result;
    }
	
	private void populateRightView (TreeNode node, List<Integer> result, int currLevel) {
		
		if (node == null) {
			return;
		}
		
		if (currLevel == result.size()) {
			result.add(node.val);
		}
		
		populateRightView(node.right, result, currLevel+1);
		populateRightView(node.left, result, currLevel+1);
	}
}
