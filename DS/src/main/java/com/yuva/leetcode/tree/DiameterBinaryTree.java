package com.yuva.leetcode.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterBinaryTree {

	 public static int getDiameter(TreeNode root, AtomicInteger diameter)
	    {
	        // base case: tree is empty
	        if (root == null) {
	            return 0;
	        }
	 
	        // get heights of left and right subtrees
	        int left_height = getDiameter(root.left, diameter);
	        int right_height = getDiameter  (root.right, diameter);
	 
	        // calculate diameter "through" the current node
	        int max_diameter = left_height + right_height + 1;
	 
	        // update maximum diameter (note that diameter "excluding" the current
	        // node in the subtree rooted at the current node is already updated
	        // since we are doing postorder traversal)
	        diameter.set(Math.max(diameter.get(), max_diameter));
	 
	        // it is important to return the height of the subtree rooted at the
	        // current node
	        return Math.max(left_height, right_height) + 1;
	    }
	 
	    public static int getDiameter(TreeNode root)
	    {
	        AtomicInteger diameter = new AtomicInteger(0);
	        getDiameter(root, diameter);
	 
	        return diameter.get();
	    }
	 

}
