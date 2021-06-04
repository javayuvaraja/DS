package com.yuva.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
Leetcode : 226. Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.
 * @author Yuvaraja Kanagarajan
 *
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
	}
	
	
	public TreeNode invertTreeIterative(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
	
	public TreeNode invertTreeLevelOrder(TreeNode root) {

		if (root == null) {
			return null;
		}

		final Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			final TreeNode node = queue.poll();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}
	
	
	public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
	       root.left = new TreeNode(2);
	       root.right = new TreeNode(3);
	       root.left.left = new TreeNode(4);
	       root.left.right = new TreeNode(5);
	  
	}
}
