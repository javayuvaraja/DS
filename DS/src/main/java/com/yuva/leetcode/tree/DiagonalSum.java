package com.yuva.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/diagonal-sum-binary-tree/
 * Diagonal Sum of a Binary Tree
 * @author Yuvaraja Kanagarajan
 *
 */
public class DiagonalSum {
	
	public static void diagonalSum (TreeNode node, int level, Map<Integer, Integer> levelMap) {
		if (node == null) {
			return ;
		}
		
		levelMap.put(level, levelMap.getOrDefault(level, 0)+node.val);
		
		diagonalSum(node.right, level, levelMap);
		diagonalSum(node.left, level+1, levelMap);
	}
	
	  public static void diagonalSum(TreeNode root) {
	        Map<Integer, Integer> map = new HashMap<>();
	        diagonalSum(root, 0, map);
	        System.out.println(map.values());
	  }
	  
	  public static void main(String[] args)
	    {
	        /* Construct the following tree
	                   1
	                 /   \
	                /     \
	               2       3
	              /      /  \
	             /      /    \
	            4      5      6
	                  / \
	                 /   \
	                7     8
	        */
	 
			TreeNode root = new TreeNode(1);
			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(4);
			root.right.left = new TreeNode(5);
			root.right.right = new TreeNode(6);
			root.right.left.left = new TreeNode(7);
			root.right.left.right = new TreeNode(8);

			diagonalSum(root);
	    }
}
