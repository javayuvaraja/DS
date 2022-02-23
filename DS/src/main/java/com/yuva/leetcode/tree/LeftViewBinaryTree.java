package com.yuva.leetcode.tree;

public class LeftViewBinaryTree {

	int maxLevel=0;
	void leftViewUtil(TreeNode node, int level)
    {
        // Base Case
        if (node == null)
            return;
 
        // If this is the first node of its level
        if (maxLevel < level) {
            System.out.print(" " + node.val);
            maxLevel = level;
        }
 
        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }
 
}
