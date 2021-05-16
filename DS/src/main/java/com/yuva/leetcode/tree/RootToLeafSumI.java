package com.yuva.leetcode.tree;

public class RootToLeafSumI {

	private int totalSum = 0;
	
	public int rootToLeafSum(TreeNode node) {
		totalSum = 0;
		rootToLeafSum(node, 0);
		return totalSum;
	}
	private void rootToLeafSum(TreeNode node, int currSum) {
		if (node == null) {
			return ;
		}
		currSum += node.val;

		if (node.left == null && node.right == null) {
			totalSum += currSum;
			return;
		}
		
		rootToLeafSum(node.left, currSum);
		rootToLeafSum(node.right, currSum);
	}
	
	public static void main(String[] args) {

		/**
		 *       10
		 *      /   \
		 *     5     4
		 *    / \     \
		 *   3   2     8
		 *            / \
		 *           6   9

		 *   
		 *   10+5+3 = 18
		 *   10+5+2 = 17
		 *   10+4+8+6 = 28
		 *   10+4+8+9 = 31
		 *   
		 *   Total  = 94
		 */          
		
		TreeNode root =  new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(6);
		root.right.right.right = new TreeNode(9);
		
		RootToLeafSumI obj =  new RootToLeafSumI();
		System.out.println(obj.rootToLeafSum(root));
	}
	
	
}
