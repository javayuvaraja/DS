package com.yuva.leetcode.tree;

/**
 * LeetCode 156 
 * Given a binary tree where all the right nodes are either leaf nodes 
 * with a sibling (a left node that shares the same parent node) or empty, 
 * flip it upside down and turn it into a tree where the original right nodes 
 * turned into left leaf nodes. Return the new root.
 * 
 *  Input :
		    1
		   / \
		  2   3
		 / \
		4   5    
		
		
	Output : 
	
	   4
	  / \
	 5   2
	    / \
	   3   1  
	   
	   
  Logic :
  
  Recursive :
  
  1) Retrieve the final new root from recursive calls. 
  2) Make the current node and its right child be the children of the current node’s left child. 
     Left point the left child to the current root’s right child and right point the left child to the current node.
     leftchild.right = root
     leftchild.left = root.rightchild;
     newroot = root.leftchild;
     
  Iterative :
  
  1. Mark the next, prev, temp node
     next - nodes left
     lastright - nodes right
     prev - prev root
     
 * @author Yuvaraja Kanagarajan
 *
 */

public class UpsideDown {

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode left = upsideDownBinaryTree(root.left);
		root.left.left = root.right;
		root.left.right = root;
		
		root.left=null;
		root.right=null;
		return left;
	}
	
	public TreeNode upsideDownBinaryTreeIterative(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		
		TreeNode prev= null;
		TreeNode lastRight = null;
		TreeNode next = null;
		TreeNode curr = null;
		
		while (curr!=null) {
			next = curr.left;
			curr.left = lastRight;  // points to the prev right
			lastRight = curr.right;  // 
			curr.right=prev;  // points to the prev root
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
