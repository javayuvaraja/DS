package com.yuva.leetcode.tree;

/**
 * 117. Populating Next Right Pointers in Each Node
 * 
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
 * The binary tree has the following definition:

		class Node {
		  int val;
		  Node left;
		  Node right;
		  Node next;
		}
		Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
		
		Initially, all next pointers are set to NULL
 * @author Yuvaraja Kanagarajan
 *
 *  Approach 1  :
 *      1. Level order traversal. Save the prevNode , if prevNode not null, then prev.next = curr;
 *      
 *  Approach 2 Iterative:
 *  
 *  	1. currNode.left.next = currNode.right;
 *      2. currNode.right.next = currNode.next.left;
 *      
 */
public class PopulateNextPointerII {

	// We can do with level order traversal
	
	/*
	 *	This solution without additional space 
	 */
	public void populateNext (TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		TreeLinkNode curr = root;
		// Traversing level by level
		while (curr!=null) {
			TreeLinkNode nextLevelStartNode = null;
			TreeLinkNode prev = null;
			while (curr!=null) {
				if (curr.left!=null) {
					if (nextLevelStartNode==null) {
						nextLevelStartNode = curr.left;						
					} else {
						prev.next = curr.left;
					}
					prev = curr.left;
				}
				
				if (curr.right!=null) {
					if (nextLevelStartNode == null) {
						nextLevelStartNode = curr.right;
					} else {
						prev.next = curr.right;
					}
					prev = curr.right;
				}
				curr = curr.next;
			}
			curr = nextLevelStartNode;
		}
	}
	
	
	
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(4);
		root.left.left.left = new TreeLinkNode(5);
		root.left.left.right = new TreeLinkNode(6);
		root.right = new TreeLinkNode(3);
		root.right.right = new TreeLinkNode(7);
		root.right.right.right = new TreeLinkNode(8);
		PopulateNextPointerII obj = new PopulateNextPointerII();
		obj.populateNext(root);
		
		System.out.println(root);
	}
}
