package com.yuva.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 
 Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F

Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL
   
   
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
public class PopulateNextPointerI {

	public void populateNext (TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		TreeLinkNode curr = root;
		
		// Traversing level by level
		while (curr.left!=null) {
			// for traversing the next level
			TreeLinkNode temp = curr;
			while (curr!=null) {
				curr.left.next = curr.right;
				if (curr.next!=null) {
					curr.right.next = curr.next.left; 
				}
				curr = curr.next;				
			}
			curr = temp.left;
		}
	}
	
	public void populateNext1 (TreeLinkNode root) {
		if (root == null) {
			return;
		}
		connect(root,null);
	}
	
	public TreeLinkNode connect(TreeLinkNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.add(root);
		TreeLinkNode prevNode = null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode currNode = queue.poll();
				if (currNode.left!=null) {
					queue.add(currNode.left);
				}
				if (currNode.right!=null) {
					queue.add(currNode.right);
				}
				if (prevNode!=null) {
					prevNode.next = currNode;
				}
				prevNode = currNode;
			}
			prevNode = null;
			
		}
		return root;
    }
	
	
	/**
	 * 
	 * @param curr
	 * @param next
	 */
	private void connect (TreeLinkNode curr, TreeLinkNode next) {
		if (curr ==null) {
			return;
		}		
		curr.next = next;
		connect(curr.left, curr.right);
		connect(curr.right, next==null ? null : next.left);		
	}
	
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		PopulateNextPointerI obj = new PopulateNextPointerI();
		obj.populateNext(root);
		
		System.out.println(root);
	}
}
