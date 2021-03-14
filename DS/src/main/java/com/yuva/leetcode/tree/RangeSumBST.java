package com.yuva.leetcode.tree;

import java.util.Stack;

/**
 * LeetCode 938
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
	
	

	Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
	Output: 32
 * @author Yuvaraja Kanagarajan
 *
 */
public class RangeSumBST {

	public int rangeSum = 0;
	
	public int rangeSumBST(TreeNode root, int low, int high) {
		inOrder(root, low, high);
		return rangeSum;
    }
	
	public void inOrder(TreeNode root, int low, int high) {
		
		if (root == null) {
			return;
		}
		
		inOrder(root.left, low, high);
		if (root.val >=low && root.val <=high) {
			rangeSum = rangeSum + root.val;
		}
		inOrder(root.right, low, high);
		
	}
	
	public int iterateRangeSumBST (TreeNode root, int low, int high) {
		Stack<TreeNode> stack = new Stack <>();
		stack.push(root);
		int rangeSum = 0;
		while (!stack.isEmpty()) {
			TreeNode currNode = stack.pop();
			
			if (currNode.val > low && currNode.left!=null) {
				stack.push(currNode.left);
			}
			
			if (currNode.val < high && currNode.right!=null) {
				stack.push(currNode.right);
			}
			
			if (currNode.val>=low && currNode.val<=high) {
				rangeSum += currNode.val; 
			}
		}
		return rangeSum;
	}
	
	 public int rangeSumBST1(TreeNode root, int low, int high) {
	        if (root == null) return 0; // base case.
	        if (root.val < low) return rangeSumBST1(root.right, low, high); // left branch excluded.
	        if (root.val > high) return rangeSumBST1(root.left, low, high); // right branch excluded.
	        return root.val + rangeSumBST1(root.right, low, high) + rangeSumBST1(root.left, low, high); // count in both children.
	    }
}
