package com.yuva.leetcode.tree;

public class PrintPathGivenSum {

	public static boolean printPathSum(TreeNode node, int sum ) {
		
		if (sum ==0 && node==null) { 
			return true;
		}
		
		if (node == null) {
			return false;
		}
		
		boolean isLeft = printPathSum(node.left, sum-node.val);
		boolean isRight = printPathSum(node.right, sum-node.val);
		
		if (isLeft|| isRight) {
			System.out.print(node.val + " ");
		}
		
		return isLeft||isRight;
	}
}
