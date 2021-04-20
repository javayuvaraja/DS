package com.yuva.leetcode.tree;

/**
 * Leetcode 101. Symmetric Tre
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * @author Yuvaraja Kanagarajan
 *
 */
public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1==null && root2 == null) {
            return true;
        }
        if (root1==null || root2==null) {
            return false;
        }
        
        return root1.val == root2.val &&
            isSymmetric(root1.left, root2.right) &&
            isSymmetric(root1.right, root2.left);
    }
}
