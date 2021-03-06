package com.yuva.leetcode.tree;

public class SumRootToLeafNumbers {
	private int sum =0;
	public int sumNumbers(TreeNode root) {
       rootToLeafSum(root, 0);
       return sum;
    }
	
	private void rootToLeafSum(TreeNode node, int currVal) {
		if (node == null) {
			return;
		}
		currVal = currVal*10 + node.val;
		if (node.left==null && node.right==null) {
			sum = sum+currVal;
		}
		rootToLeafSum(node.left, currVal);
		rootToLeafSum(node.right, currVal);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(0);
		
		SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
		System.out.println(obj.sumNumbers(root));
	}
}
