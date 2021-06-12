package com.yuva.leetcode.tree;

/**
 * 
124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of 
adjacent nodes in the sequence has an edge connecting them. 
A node can only appear in the sequence at most once. 
Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any path.

 * @author Yuvaraja Kanagarajan
 *
 */
public class FindMaxSumPath {
	
	int maxValue =  Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxSum (root); 
        return maxValue;
    }
    
    private int findMaxSum (TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left =  findMaxSum(node.left);
		int right =  findMaxSum(node.right);
		// Max is either node only, or node with any one of the child or node with both the child
		int maxWithOneChild = Math.max(Math.max(left, right)+node.val, node.val);
		int maxWithTwoChild = Math.max(maxWithOneChild, node.val+left+right);
		
		if (maxValue < maxWithTwoChild) {
			maxValue = maxWithTwoChild;
		}
		// returning node with one child to the parent because if returning sum 
		//with two child then parent cant participate in the path.
		// so have to return with max with the one child.
		return maxWithOneChild;
	}
}
