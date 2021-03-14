package com.yuva.leetcode.tree;

public class LowestCommonAncestor {

	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 return lca(root, p, q);				 
	 }
	 
	 private TreeNode lca (TreeNode root,TreeNode node1, TreeNode node2) {
		 if (root ==null) {
			 return null;
		 }
		 if (root.val == node1.val || root.val==node2.val) {
			 return root;
		 }
		 
		 TreeNode left = lca(root.left, node1, node2);
		 TreeNode right = lca(root.right, node1, node2);
		 
		 if (left!=null && right!=null) {
			 return root;
		 }
		 
		 return left!=null ? left : right;
	 }
	
}
