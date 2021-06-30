package com.yuva.leetcode.tree;

import java.util.concurrent.atomic.AtomicBoolean;

public class CheckHeightBalanced {
	public int isHeightBalanced(TreeNode node, AtomicBoolean isBalanced) {
		if (node == null && !isBalanced.get()) {
			return 0;
		}
		
		int leftHeight = isHeightBalanced(node.left, isBalanced);
		int rightHeight = isHeightBalanced(node.right, isBalanced);
		
		if (Math.abs(leftHeight-rightHeight) > 1) {
			isBalanced.set(false);
		}
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	
	public boolean isBalanced(TreeNode root) {
		AtomicBoolean isBalanced = new AtomicBoolean(true);
        isHeightBalanced(root, isBalanced);
        return isBalanced.get();
    }
	
	public boolean isBalanced1(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root) != -1;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
