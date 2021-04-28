package com.yuva.leetcode.tree;

/**
 * https://www.techiedelight.com/convert-normal-binary-tree-left-child-right-sibling-binary-tree/
 * @author Yuvaraja Kanagarajan
 *
 */
public class LeftChildRightSibling {

	 public static void convert(TreeNode root) {
		 if (root == null) {
			 return ;
		 }
		 
		 convert(root.left);
		 convert(root.right);
		 
		 if (root.left==null) {
			 root.left = root.right;
			 root.right = null;
		 } else {
			 root.left.right = root.right;
			 root.right = null;
		 }
		 
	 }
	 
	 public static void main(String[] args)
	    {
	        /* Construct the following tree
	                  1
	                /  \
	               /    \
	              2      3
	             / \    /
	            4   5  6
	                  / \
	                 7   8
	        */
	 
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.right.left = new TreeNode(6);
	        root.right.left.left = new TreeNode(7);
	        root.right.left.right = new TreeNode(8);
	 
	        convert(root);
	        TreeUtils.printPreorder(root);
	    }
}
