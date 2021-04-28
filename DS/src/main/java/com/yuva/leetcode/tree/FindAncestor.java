package com.yuva.leetcode.tree;

public class FindAncestor {
	static boolean findAncestor (TreeNode node, int target ) {
		if (node == null ) {
			return false;
		}
		
		if (node.val == target) {
			return true;
		}
		
		if (findAncestor(node.left, target) || 
			findAncestor(node.right, target)) {
			System.out.println(node.val + " ");
			return true;
		}
		return false;
	}
	
	 public static void main(String args[]) 
	    {
	        /* Construct the following binary tree
	                  1
	                /   \
	               2     3
	              /  \
	             4    5
	            /
	           7
	        */
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.left.left.left = new TreeNode(7);
	   
	        findAncestor(root, 7);
	   
	    }
}
