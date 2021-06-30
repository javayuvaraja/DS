package com.yuva.leetcode.tree;

/**
Leetcode 270
Given a binary search tree, the value of each node is an integer, and then given a floating-point number target, 
ask what is the nearest number to the target in the binary search tree.


 * @author Yuvaraja Kanagarajan
 *
 */
public class ClosestBSTValue {

	/*
	 * Logic: 
	 *  1. If the target is smaller than the root of the tree, 
		   then the answer only exists in the left subtree or the root itself; 
		2. If the target is greater than the root of the tree, 
		   then the answer only exists in the right subtree or the root itself. 
		3. First determine which half of the target is, find which half is closest to the target, 
		   and then compare with the root of the tree to get the final result
	 */
	
	public int closestValue(TreeNode root, double target) {
    	if (root.left == null && root.right == null) {
            return root.val;
        }

		int res = root.val;
		
        if (target < root.val && root.left != null) {
            res = closestValue(root.left, target);
        }
        if (target > root.val && root.right != null) {
            res = closestValue(root.right, target);
        }
        
        if (Math.abs(root.val - target) < Math.abs(res - target)) {
            res = root.val;
        }

        return res;
    }
	
	
	public int ClosestValue(TreeNode root, double target) {
		if (root == null)
			return 0;

		int val = root.val;
		double minDiff = Math.abs(target - val);
		TreeNode node = root;
		while (node != null) {
			double diff = Math.abs(target - node.val);
			if (diff <= minDiff) {
				minDiff = diff;
				val = node.val;
			}
			node = target <= node.val ? node.left : node.right;
		}

		return val;
	}
}
