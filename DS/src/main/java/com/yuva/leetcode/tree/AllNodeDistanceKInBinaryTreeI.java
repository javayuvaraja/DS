package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class AllNodeDistanceKInBinaryTreeI {

	Map<TreeNode, Integer> distanceMap = new HashMap<>();
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	    List<Integer> res = new ArrayList<>();
	    findPath(root, target);
	    search(root, 0, K, res);
	    return res;
	}

	private void findPath(TreeNode root, TreeNode target) {
	    if (root == null) {
	        return;
	    }
	    
	    if (root == target) {
	        distanceMap.put(root, 0);
	        return;
	    }
	    
	    findPath(root.left, target);
	    if (distanceMap.containsKey(root.left)) {
	        distanceMap.put(root, distanceMap.get(root.left) + 1);
	        return;
	    }
	    
	    findPath(root.right, target); 
	    if (distanceMap.containsKey(root.right)) {
	        distanceMap.put(root, distanceMap.get(root.right) + 1);
	        return;
	    }
	    return;
	}

	public void search(TreeNode root, int dis, int K, List<Integer> res) {
	    if (root == null) {
	        return;
	    }
	    
	    if (distanceMap.containsKey(root)) {
	        dis = distanceMap.get(root);
	    }
	    
	    if (dis == K) {
	        res.add(root.val);
	    }
	    
	    search(root.left, dis + 1, K, res);
	    search(root.right, dis + 1, K, res);
	}
	
}
