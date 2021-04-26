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
}
