package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
863. All Nodes Distance K in Binary Tree

We are given a binary tree (with root node root), a target node, and an integer value k.

Return a list of the values of all nodes that have a distance k from the target node.  
The answer can be returned in any order.
 
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.

 * @author Yuvaraja Kanagarajan
 *
 */
public class AllNodeDistanceKInBinaryTree {

	/*
	 * Logic : 
	 * 		1. Find child parent relationship.
			2. Get all childs from the target
			3. Find the parent of target and reduce by 1 each time a parent is found .
			   then go and find children at the reduced level from each parent
	 */
	HashMap<TreeNode, TreeNode> childParentMap = new HashMap<>();
	List<Integer> result = new ArrayList<>();
	HashSet<TreeNode> visited = new HashSet<>();
	
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	    
	    // dfs till target and build child - parent relationship
	    dfs(root, target, null);
	    
	    // straight away get descends from target 
	    drill(target, K);
	    int temp = K;

	    // iterate through each parent and reduce a level .
	    // get descends that are at reduced level .
	    while (temp >= 0) {

	        TreeNode node = childParentMap.get(target);
	        if (node == null) {
	            break;
	        }
	        drill(node, temp - 1);
	        temp = temp - 1;
	        target = node;
	    }
	    return result;
	}



	public void dfs(TreeNode node, TreeNode target, TreeNode parent) {

	    if (node == null) {
	        return;
	    }
	    childParentMap.put(node, parent);
	    if (node == target) {
	        return;
	    }

	    dfs(node.left, target, node);
	    dfs(node.right, target, node);

	}

	public void drill(TreeNode node, int K) {

	    if (node != null && !visited.contains(node)) {
	        if (K == 0) {
	            result.add(node.val);
	            return;
	        }
	        visited.add(node);
	        drill(node.left, K - 1);
	        drill(node.right, K - 1);
	    }
	}
}
