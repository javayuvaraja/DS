package com.yuva.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the 
root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindMinDepthTreeDistance {

	/** Solution 1: DFS 
	 * Key point: 
	 * if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
	 * if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1
	 * */
	public int minDepth(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }

	    int left = minDepth(root.left);
	    int right = minDepth(root.right);
	    if (left == 0 || right == 0) {
	        return Math.max(left, right) + 1;
	    }
	    else {
	        return Math.min(left, right) + 1;
	    }
	}


	/** Solution 2: BFS level order traversal */
	public int minDepth2(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    int level = 1;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            TreeNode curNode = queue.poll();
	            if (curNode.left == null && curNode.right == null) {
	                return level;
	            }
	            if (curNode.left != null) {
	                queue.offer(curNode.left);
	            }
	            if (curNode.right != null) {
	                queue.offer(curNode.right);
	            }
	        }
	        level++;
	    }
	    return level;
	}
}
