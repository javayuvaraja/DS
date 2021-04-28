package com.yuva.leetcode.tree;

/**
 783. Minimum Distance Between BST Nodes
 Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindMinimumDiffBST {
	private int min = Integer.MAX_VALUE;
    private Integer prev = null;
    
    // Logic : Inorder traversal and compare the curr val with the prev val
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return min;
        }
        
        minDiffInBST(root.left);
        
        if (prev != null){
            min  = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        minDiffInBST(root.right);
        
        return min;
    }
}
